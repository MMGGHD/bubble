package test.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initObjcet();
        initSetting();
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

    public static void main(String[] args) {
        new BubbleFrame();
    }
}
