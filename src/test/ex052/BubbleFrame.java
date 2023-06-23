package test.ex052;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// main Thread를 GUI 프로그램에서는 ui Thread라고 한다.
public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initObjcet();
        initSetting();
        initListener();
        setVisible(true); // while이 돌아가는 메서드 >> Thread의 길이가 무한이다.
    }

    private void initObjcet() {
        backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
        player = new Player();
        // 순서가 중요하다
        setContentPane(backgroundMap); // 배경이 먼저
        add(player); // 배경다음에 플레이어 캐릭터가 나옴
    }

    private void initSetting() {
        setSize(1000, 640);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // 키보드이벤트는 프레임자체(화면전체)에다가 적용해야 한다.
    private void initListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // System.out.println(e.getKeyCode());

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (!player.isLeft()) { // 왼쪽 안보고있으면 false >> !로 인해 true >> player.left() 실행
                        player.left();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (!player.isRight()) {
                        player.right();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (!player.isUp() && !player.isDown()) {
                        player.up();
                    } else if ((!player.isUp() && player.isDown()) || (player.isUp() && !player.isDown())) {
                        System.out.println("더블");
                        player.setDoubleswitch(true);
                        player.doubleup();
                    }
                }
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setRight(false);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.setLeft(false);
                }
            }

        });
    }

    public static void main(String[] args) {
        new BubbleFrame();
    }
}
