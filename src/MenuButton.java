import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuButton {
    private int x, y;
    private Gamestate state;
    private BufferedImage menuButtonImg;
    private boolean mousePressed;
    public static final int MENU_BUTTON_WIDTH = 167, MENU_BUTTON_HEIGHT = 54;
    private Rectangle hitbox;
    public MenuButton(int x, int y, Gamestate state){
        this.x = x;
        this.y = y;
        this.state = state;
        menuButtonImg = LoadImages.getImage(LoadImages.MENU_BUTTON_FILENAME);
        initHitbox();
    }

    private void initHitbox() {
        hitbox = new Rectangle(x, y, MENU_BUTTON_WIDTH, MENU_BUTTON_HEIGHT);
    }

    public void draw(Graphics g){
        g.drawImage(menuButtonImg, x, y, null);
    }
    public void changeGamestate(){
        Gamestate.state = Gamestate.PLAYING;
    }
    public boolean isMousePressed(){
        return mousePressed;
    }
    public void setMousePressed(boolean mousePressed){
        this.mousePressed = mousePressed;
    }
    public void resetMousePressed(){
        mousePressed = false;
    }
    public Rectangle getHitbox(){
        return hitbox;
    }
}
