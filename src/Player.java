import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Player extends Entity{
    private BufferedImage playerImg;
    public static final int SPIDER_WIDTH = 66, SPIDER_HEIGHT = 48;
    private BufferedImage[] spiderBlinking;
    private int animationTick = 0, animationIndex = 4, animationSpeed = 20;
    private static boolean isJumping = false;
    private final float GRAVITY = 0.05f;
    private double yVelocity = 0;
    private float xDirection = 0.5f;
    private final float X_HITBOX_OFFSET = 21, Y_HITBOX_OFFSET = 14;
    private final int HITBOX_WIDTH = 28, HITBOX_HEIGHT = 28;
    public void update(){
        updatePlayer();
        updateHitbox();
        updateAnimationTick();
    }
    public void render(Graphics g){
        g.drawImage(spiderBlinking[animationIndex], (int)(x - X_HITBOX_OFFSET), (int)(y - Y_HITBOX_OFFSET), null);
        //drawHitbox(g);
    }

    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadAnimations();
        initHitbox(x, y, HITBOX_WIDTH, HITBOX_HEIGHT);
    }

    private void loadAnimations() {
        BufferedImage playerImg = LoadImages.getImage(LoadImages.PLAYER_FILENAME);
        spiderBlinking = new BufferedImage[5];
        for(int i = 0; i < spiderBlinking.length; i++) {
            spiderBlinking[i] = playerImg.getSubimage(i * SPIDER_WIDTH, 0, SPIDER_WIDTH, SPIDER_HEIGHT);
        }
    }
    public static void setJumping(){
        isJumping = true;
    }
    private void updateAnimationTick() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if(animationIndex >= spiderBlinking.length)animationIndex = 0;
        }
    }
    private void updatePlayer() {
        x += xDirection;
        if((x - X_HITBOX_OFFSET) > Window.WINDOW_WIDTH - SPIDER_WIDTH/2 || (x - X_HITBOX_OFFSET) < -SPIDER_WIDTH/2)xDirection *= -1;
        if(!isJumping){
            yVelocity += GRAVITY;
            y += yVelocity;
        }
        else {
            isJumping = false;
            yVelocity = -2.5;
        }
        if(y > Window.WINDOW_HEIGHT + 50)Gamestate.state = Gamestate.END;
    }

}
