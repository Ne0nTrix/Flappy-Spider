import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Start extends State implements Statemethods {
    private MenuButton button;
    private BufferedImage backgroundImg;

    public Start(Game game) {
        super(game);
        button = new MenuButton(100, 400, Gamestate.PLAYING);
        backgroundImg = LoadImages.getImage(LoadImages.MENU_BACKGROUND_FILENAME);
    }


    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, null);
        button.draw(g);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (isInside(e, button)) {
            button.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isInside(e, button)) {
            if (button.isMousePressed()) button.changeGamestate();
        }
        button.resetMousePressed();
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Gamestate.state = Gamestate.PLAYING;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}