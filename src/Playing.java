import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Playing extends State implements Statemethods{
    private static Player player;
    private static List<Collectibles> collectibles;
    private static List<Danger> rain;
    private final float CHANGE_Y = 0.5f;
    private float y;
    private BufferedImage backgroundImg;
    private static int score;
    public Playing(Game game) {
        super(game);
        player = new Player(Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2, Player.SPIDER_WIDTH, Player.SPIDER_HEIGHT);
        initCollectibles();
        initDanger();
        backgroundImg = LoadImages.getImage(LoadImages.PLAYING_BACKGROUND_FILENAME);
        restartY();
    }

    private void initDanger() {
        rain = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int x = ThreadLocalRandom.current().nextInt(5, Window.WINDOW_WIDTH - 5);
            int y = ThreadLocalRandom.current().nextInt(-Window.WINDOW_HEIGHT-300, -100);
            rain.add(new Danger(x, y, Danger.RAIN_WIDTH, Danger.RAIN_HEIGHT));
        }
    }

    public static void initCollectibles() {
        collectibles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int x = ThreadLocalRandom.current().nextInt(5, Window.WINDOW_WIDTH - 5);
            int y = ThreadLocalRandom.current().nextInt(-200, -30);
            collectibles.add(new Collectibles(x, y, Collectibles.FLY_WIDTH, Collectibles.FLY_HEIGHT));
        }
    }

    public static Player getPlayer(){
        return player;
    }

    public static void addScore() {
        score++;
    }
    public static int getScore(){
        return score;
    }

    private void restartY(){
        y = -backgroundImg.getHeight()/2;
    }

    @Override
    public void update() {
        if(y > 0)restartY();
        else y += CHANGE_Y;
        player.update();
        for (Collectibles collectible : collectibles) {
            collectible.update();
        }
        for (Danger raindrops : rain) {
            raindrops.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, (int)y, null);
        player.render(g);
        for (Collectibles collectible : collectibles) {
            collectible.draw(g);
        }
        for (Danger raindrops : rain) {
            raindrops.draw(g);
        }
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
        switch(e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                Player.setJumping();
                break;
            case KeyEvent.VK_ESCAPE:
                Gamestate.state = Gamestate.START;
        }

    }

    public static void gameEnd(){
        Gamestate.state = Gamestate.END;
    }

}
