import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {

    private Game game;
    
    public Viewer(Game game)
    {


        this.game = game;
        
        this.setTitle("Black Jack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);


    }
}
