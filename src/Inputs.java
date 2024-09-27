import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Inputs implements KeyListener, MouseListener {
    private Panel gamePanel;
    public Inputs(Panel gamePanel){
        this.gamePanel = gamePanel;

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (Gamestate.state) {
            case PLAYING:
                gamePanel.getGame().getPlaying().keyPressed(e);
                break;
            case START:
                gamePanel.getGame().getStart().keyPressed(e);
                break;
            case END:
                gamePanel.getGame().getEnd().keyPressed(e);
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (Gamestate.state) {
            case PLAYING:
                gamePanel.getGame().getPlaying().keyReleased(e);
                break;
            case START:
                gamePanel.getGame().getStart().keyReleased(e);
                break;
            case END:
                gamePanel.getGame().getEnd().keyReleased(e);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(Gamestate.state){
            case PLAYING:
                gamePanel.getGame().getPlaying().mousePressed(e);
                break;
            case START:
                gamePanel.getGame().getStart().mousePressed(e);
                break;
            case END:
                gamePanel.getGame().getEnd().mousePressed(e);
                break;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(Gamestate.state){
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseReleased(e);
                break;
            case START:
                gamePanel.getGame().getStart().mouseReleased(e);
                break;
            case END:
                gamePanel.getGame().getEnd().mouseReleased(e);
                break;
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
