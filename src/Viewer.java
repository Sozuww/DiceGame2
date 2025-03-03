import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {

    private Image[] images;
    private Image homePage;
    private Image gamePlay;
    private Image loss;
    private Image win;

    private int lastCard;
    private int roll1;
    private int roll2;

    private Game game;
    
    public Viewer(Game game)
    {

        // Die faces

        images = new Image[6];
        for (int i = 0; i < 6; i++) {
            String path = "resources/die/blackdie" + (i + 1) + ".png";
            System.out.println("Loading image: " + path);
            images[i] = new ImageIcon(path).getImage();

            if (images[i] == null) {
                System.out.println("Error: Image not loaded for " + path);
            }
        }
        // Background Images
        homePage = new ImageIcon("resources/homepage.png").getImage();
        homePage = homePage.getScaledInstance(960, 540, Image.SCALE_SMOOTH);

        gamePlay = new ImageIcon("resources/gameplay.png").getImage();
        gamePlay = gamePlay.getScaledInstance(960, 540, Image.SCALE_SMOOTH);

        win = new ImageIcon("Resources/win.png").getImage();
        win = win.getScaledInstance(960, 540, Image.SCALE_SMOOTH);

        loss = new ImageIcon("resources/youlose.png").getImage();
        loss = loss.getScaledInstance(960, 540, Image.SCALE_SMOOTH);



        this.game = game;
        
        this.setTitle("Black Jack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(960, 540);
        this.setVisible(true);
    }
    
    public void paint(Graphics g)
    {

        int state = Game.getGameState();

        // Loops to determine current state of the game
        if (state == 0)
        {
            g.drawImage(homePage, 0, 0, this);
        }

        else if (state == 1)
        {

            g.drawImage(gamePlay, 0, 0, this);
        }

        else if (state == 2)
        {
            g.drawImage(loss, 0, 0, this);
        }

        else if (state == 3)
        {
            g.drawImage(win, 0, 0, this);
        }

        // Draw dice only if game is active
        if (state == 1)
        {
            System.out.println("in state roll 1:" + roll1 + " & roll2: " + roll2);
            g.drawImage(images[roll1 - 1], 400, 250, this);
            g.drawImage(images[roll2 - 1], 500, 250, this);
        }


    }



    public void updateView(int newRoll1, int newRoll2)
    {
        this.roll1 = newRoll1;
        this.roll2 = newRoll2;

        System.out.println("Updating view: Roll1 = " + roll1 + ", Roll2 = " + roll2);

        repaint();
    }

    public void updateView()
    {
        repaint();
    }

}
