package test.ex032;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

    private int x;
    private int y;

    private ImageIcon playerR, playerL;

    public Player() {
        initObjcet();
        initSetting();
        setVisible(true);
    }

    private void initObjcet() {
        playerR = new ImageIcon("image/playerR.png");
        playerL = new ImageIcon("image/playerL.png");
    }

    private void initSetting() {
        x = 70;
        y = 535;

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
    }

    public void right() {
        setIcon(playerR);
        x = x + 10;
        setLocation(x, y);
    }

    public void left() {
        setIcon(playerL);
        x = x - 10;
        setLocation(x, y);
    }
}
