import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {

    private Image[] images;
    private Image homePage;
    private Image gamePlay;
    private Image loss;
    private Image win;

    private Game game;
    
    public Viewer(Game game)
    {

        // Die faces
        images = new Image[12];
        images[0] = new ImageIcon("resources/die/blackdie1.png").getImage();
        images[1] = new ImageIcon("resources/die/REDIE1.png").getImage();
        images[2] = new ImageIcon("resources/die/blackdie2.png").getImage();
        images[3] = new ImageIcon("resources/die/REDIE2.png").getImage();
        images[4] = new ImageIcon("resources/die/blackdie3.png").getImage();
        images[5] = new ImageIcon("resources/die/REDIE3.png").getImage();
        images[6] = new ImageIcon("resources/die/blackdie4.png").getImage();
        images[7] = new ImageIcon("resources/die/REDIE4.png").getImage();
        images[8] = new ImageIcon("resources/die/blackdie5.png").getImage();
        images[9] = new ImageIcon("resources/die/REDIE5.png").getImage();
        images[10] = new ImageIcon("resources/die/blackdie6.png").getImage();
        images[11] = new ImageIcon("resources/die/REDIE6.png").getImage();

        // Background Images
        homePage = new ImageIcon("resources/homepage.png").getImage();
        homePage = homePage.getScaledInstance(960, 540, Image.SCALE_SMOOTH);

        gamePlay = new ImageIcon("resources/gameplay.png").getImage();
        win = new ImageIcon("resources/youwin.png").getImage();
        loss = new ImageIcon("resources/youlose.png").getImage();


        this.game = game;
        
        this.setTitle("Black Jack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(960, 540);
        this.setVisible(true);
    }
    
    public void paint(Graphics g)
    {

        if (Game.getGameState() == 0)
        {
            // Homescreen image
            g.drawImage(homePage, 0, 0, this);
        }

        else if (Game.getGameState() == 1)
        {
            g.drawImage(gamePlay, 0, 0, this);
        }





    }

}
