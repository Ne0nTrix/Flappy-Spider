import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadImages {
    public static final String PLAYER_FILENAME = "Spider.png";
    public static final String MENU_BUTTON_FILENAME = "Button.png";
    public static final String MENU_BACKGROUND_FILENAME = "MenuBackground.png";
    public static final String PLAYING_BACKGROUND_FILENAME = "Background.png";
    public static final String FLY_FILENAME = "Fly.png";
    public static final String END_BACKGROUND_FILENAME = "EndBackground.png";
    public static final String RAIN_FILENAME = "Rain.png";
    public static BufferedImage getImage(String fileName) {
        BufferedImage playerImg = null;
        InputStream is = LoadImages.class.getResourceAsStream("/" + fileName);
        try {
            playerImg = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return playerImg;
    }
}
