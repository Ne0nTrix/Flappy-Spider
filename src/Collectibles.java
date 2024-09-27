import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

public class Collectibles extends Entity{
    private final int HITBOX_WIDTH = 10, HITBOX_HEIGHT = 10;
    public static final int FLY_WIDTH = 16, FLY_HEIGHT = 16;
    private BufferedImage flyImg;
    private final float Y_HITBOX_OFFSET = 5;
    private final float CHANGE_Y = 0.5f;

    public Collectibles(float x, float y, int width, int height) {
        super(x, y, width, height);
        flyImg = LoadImages.getImage(LoadImages.FLY_FILENAME);
        initHitbox(x, y, HITBOX_WIDTH, HITBOX_HEIGHT);
    }

    public void update() {
        y += CHANGE_Y;
        if (y > Window.WINDOW_HEIGHT) resetPosition();
        if (hitbox.intersects(Playing.getPlayer().hitbox)) {
            resetPosition();
            Playing.addScore();
        }
        updateHitbox();
    }
    public void draw(Graphics g){
        g.drawImage(flyImg, (int)x, (int)(y - Y_HITBOX_OFFSET), null);
        //drawHitbox(g);
    }
private void resetPosition() {
    x = ThreadLocalRandom.current().nextInt(5, Window.WINDOW_WIDTH - 5);
    y = ThreadLocalRandom.current().nextInt(-100, -30);
}
}
