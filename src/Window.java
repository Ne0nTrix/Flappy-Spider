import javax.swing.*;

public class Window {
    private JFrame window;
    public static final int WINDOW_WIDTH = 374;
    public static final int WINDOW_HEIGHT = 640;
    public Window(Panel gamePanel){
        window = new JFrame("Flappy spider");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }
}
