import java.awt.*;
public class Game implements Runnable {
    private Window gameWindow;
    private Panel gamePanel;
    private Thread gameThread;
    private final int SET_FPS = 120;
    private Playing playing;
    private Start menu;
    private End end;
    public Game(){
        initClasses();
        gamePanel = new Panel(this);
        gameWindow = new Window(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();

    }

    private void initClasses() {
        menu = new Start(this);
        playing = new Playing(this);
        end = new End(this);
    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void update(){
        switch(Gamestate.state){
            case PLAYING:
                playing.update();
                break;
            case START:
                menu.update();
                break;
            case END:
                end.update();
        }
    }
    public void render(Graphics g){
        switch(Gamestate.state){
            case PLAYING:
                playing.draw(g);
                break;
            case START:
                menu.draw(g);
                break;
            case END:
                end.draw(g);
        }
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / SET_FPS;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        while(true){
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                gamePanel.repaint();
                update();
                lastFrame = now;
            }
        }
    }
    public Start getStart(){
        return menu;
    }
    public Playing getPlaying(){
        return playing;
    }
    public End getEnd(){
        return end;
    }
}
