import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class End extends State implements Statemethods {
    private BufferedImage backgroundImg;
    public End(Game game) {
        super(game);
        backgroundImg = LoadImages.getImage(LoadImages.END_BACKGROUND_FILENAME);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawImage(backgroundImg, 0, 0, null);
        g.drawString(String.valueOf(Playing.getScore()), Window.WINDOW_WIDTH/2-5, 550);
    }


    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
