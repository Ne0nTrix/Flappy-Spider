import java.awt.event.MouseEvent;

public class State {
    protected Game game;
    public State(Game game){
        this.game = game;
    }
    public boolean isInside(MouseEvent e,MenuButton button){
        return button.getHitbox().contains(e.getX(), e.getY());
    }
}
