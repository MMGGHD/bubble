package test.ex03;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initObjcet();
        initSetting();
        initListener();
        setVisible(true);
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
                System.out.println(e.getKeyCode());

                if (e.getKeyCode() == 39) {
                    player.right();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.left();
                }
            }
        });
    }

    public static void main(String[] args) {
        new BubbleFrame();
    }
}
