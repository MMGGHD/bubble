package test.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Player extends JLabel {

    // 위치상태
    private int x;
    private int xr;
    private int xl;
    private int y;

    // 플레이어 방향 상태
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    private ImageIcon playerR, playerL;

    // 플레이어의 스피드
    private final int SPEED = 6;
    private final int JUMPSPEED = 4;
    private final int JUMPHEIGHT = 125;

    // 플레이어가 벽에 부딪힌 상태
    private boolean leftWallCrash;
    private boolean rightWallCrash;

    public Player() {
        initObjcet();
        initSetting();
        setVisible(true);
        new Thread(new BackgroundPlayerService(this)).start();
    }

    // new 하는 애들모음
    private void initObjcet() {
        playerR = new ImageIcon("image/playerR.png");
        playerL = new ImageIcon("image/playerL.png");
    }

    private void initSetting() {
        x = 80;
        y = 535;
        xr = x + 25;
        xl = x - 25;

        left = false;
        right = false;
        up = false;
        down = false;

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
    }

    public void left() {
        System.out.println("left 메서드 실행됨");
        left = true;
        new Thread(() -> {
            while (left) {
                setIcon(playerL);
                x = x - SPEED;
                setLocation(x, y);

                /*
                 * 1. 이벤프 루프에 등록, 등록된 이벤트는 메인스레드가 안바쁠때 소비됨
                 * 2. 순간이동 안하게 하려면
                 * 3. Thread와 while안에 메서드를 묶어 갈래를 만듦
                 * 4. left키를 누르면 메인스레드가 left메서드 발동
                 * 5. 메인스레드는 내부의 서브스레드를 확인, start()지점으로 점프
                 * 6. 이후 코드가 없으므로 놀게됨 (안바쁜 상태가됨)
                 * 7. while을 돌고있는 서브스레드가 이벤트를 던져줄때마다 처리함. >> 부드럽게 이동
                 */

                try {
                    Thread.sleep(10); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void right() {
        System.out.println("right 메서드 실행됨");
        right = true;
        new Thread(() -> {
            while (right) {
                setIcon(playerR);
                x = x + SPEED;
                setLocation(x, y);

                /*
                 * 1. 이벤프 루프에 등록, 등록된 이벤트는 메인스레드가 안바쁠때 소비됨
                 * 2. 순간이동 안하게 하려면
                 * 3. Thread와 while안에 메서드를 묶어 갈래를 만듦
                 * 4. right키를 누르면 메인스레드가 right메서드 발동
                 * 5. 메인스레드는 내부의 서브스레드를 확인, start()지점으로 점프
                 * 6. 이후 코드가 없으므로 놀게됨 (안바쁜 상태가됨)
                 * 7. while을 돌고있는 서브스레드가 이벤트를 던져줄때마다 처리함. >> 부드럽게 이동
                 */

                try {
                    Thread.sleep(10); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void up() {
        System.out.println("up 메서드 실행됨");
        up = true;
        new Thread(() -> {
            for (int i = 0; i < JUMPHEIGHT; i += JUMPSPEED) {
                y = y - JUMPSPEED;
                setLocation(x, y);
                try {
                    Thread.sleep(10); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }

            up = false;
            down();
        }).start();
    }

    public void down() {
        System.out.println("down 메서드 실행됨");
        down = true;
        new Thread(() -> {
            while (down) { // Thread 관리의 기본으로 While-true/false가 좋다.
                y = y + JUMPSPEED;
                setLocation(x, y);
                try {
                    Thread.sleep(6); // 0.01초
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            down = false;
        }).start();
    }
}
