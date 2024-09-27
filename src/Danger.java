import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

public class Danger extends Entity{
    private final int HITBOX_WIDTH = 6, HITBOX_HEIGHT = 12;
    public static final int RAIN_WIDTH = 9, RAIN_HEIGHT = 15;
    private BufferedImage rainImg;
    private final float Y_HITBOX_OFFSET = 3, X_HITBOX_OFFSET = 1;
    private final float CHANGE_Y = 1;

    public Danger(float x, float y, int width, int height) {
        super(x, y, width, height);
        rainImg = LoadImages.getImage(LoadImages.RAIN_FILENAME);
        initHitbox(x, y, HITBOX_WIDTH, HITBOX_HEIGHT);
    }

    public void update() {
        y += CHANGE_Y;
        if (y > Window.WINDOW_HEIGHT) resetPosition();
        if (hitbox.intersects(Playing.getPlayer().hitbox)) Playing.gameEnd();
        updateHitbox();
    }
    public void draw(Graphics g){
        g.drawImage(rainImg, (int)(x - X_HITBOX_OFFSET), (int)(y - Y_HITBOX_OFFSET), null);
        //drawHitbox(g);
    }
    private void resetPosition() {
        x = ThreadLocalRandom.current().nextInt(5, Window.WINDOW_WIDTH - 5);
        y = ThreadLocalRandom.current().nextInt(-Window.WINDOW_HEIGHT, -100);
    }
}
