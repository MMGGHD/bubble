package test.ex062;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*  
Background에서 실행되는 클래스
메인클래스는 키보드이벤트를 처리하기 바쁨
이 클래스는 Background에서 관찰
*/
public class BackgroundPlayerService implements Runnable { // 클래스를 Thread로 만듦, 인자들을 전달받기 위해 (익명클래스로 하면 인자전달이 안됨)

    private Player player;
    private BufferedImage image;

    public BackgroundPlayerService(Player player) {
        this.player = player;

        File file = new File("image/backgroundMapService.png");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() { // 새로운 Thread의 생명줄
        while (true) {
            Color color = new Color(image.getRGB(player.getX(), player.getY()));
            System.out.println("보글이 위치의 빨간색상" + color.getRed());
            System.out.println("보글이 위치의 초록색상" + color.getGreen());
            System.out.println("보글이 위치의 블루색상" + color.getBlue());
            System.out.println("보글이의 x값" + player.getX());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
