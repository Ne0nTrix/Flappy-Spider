import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private Inputs inputs;
    private Game game;
    public Panel(Game game){
        this.game = game;
        inputs = new Inputs(this);
        addKeyListener(inputs);
        addMouseListener(inputs);
        setPanelSize();
    }
    private void setPanelSize() {
        Dimension size = new Dimension(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        setPreferredSize(size);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }
    public Game getGame(){
        return game;
    }
}
