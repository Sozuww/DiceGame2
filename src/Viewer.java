import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {

    // dont fully understand
    private GamePanel gamePanel;
    private Game game;

    public Viewer(Game game)
    {
        this.game = game;
        // dont fully understand
        this.gamePanel = new GamePanel();

        this.setTitle("Black Jack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(960, 540);
        this.add(gamePanel);
        this.setVisible(true);
    }

    public void updateView(int newRoll1, int newRoll2)
    {
        // dont fully understand
        gamePanel.updateDice(newRoll1, newRoll2);
    }

    public void updateView()
    {
        // dont fully understand
        gamePanel.repaint();
    }

    // dont fully understand
    private class GamePanel extends JPanel
    {
        private Image[] images;
        private Image homePage;
        private Image gamePlay;
        private Image loss;
        private Image win;
        private int roll1;
        private int roll2;

        public GamePanel()
        {
            // dont fully understand
            setDoubleBuffered(true);

            // Load die faces
            images = new Image[6];
            for (int i = 0; i < 6; i++)
            {
                String path = "resources/die/blackdie" + (i + 1) + ".png";
                System.out.println("Loading image: " + path);
                ImageIcon icon = new ImageIcon(path);
                images[i] = icon.getImage();


                if (images[i] == null || icon.getIconWidth() <= 0)
                {
                    System.out.println("Error: Image not loaded correctly for " + path);
                }
            }

            // Load background images
            homePage = new ImageIcon("resources/homepage.png").getImage();
            homePage = homePage.getScaledInstance(960, 540, Image.SCALE_SMOOTH);

            gamePlay = new ImageIcon("resources/gameplay.png").getImage();
            gamePlay = gamePlay.getScaledInstance(960, 540, Image.SCALE_SMOOTH);

            win = new ImageIcon("Resources/win.png").getImage();
            win = win.getScaledInstance(960, 540, Image.SCALE_SMOOTH);

            loss = new ImageIcon("resources/youlose.png").getImage();
            loss = loss.getScaledInstance(960, 540, Image.SCALE_SMOOTH);
        }

        public void updateDice(int newRoll1, int newRoll2)
        {
            this.roll1 = newRoll1;
            this.roll2 = newRoll2;
            repaint();
        }
        // dont fully understand
        @Override

        // dont fully understand "protected"

        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            int state = Game.getGameState();

            if (state == 0)
            {
                // Draw homepage
                g.drawImage(homePage, 0, 0, this);

                // Set font and color
                g.setFont(new Font("Arial", Font.BOLD, 18));
                g.drawString("The goal of the game is to get a higher number than the dealer,", 10, 50);
                g.drawString("but you can't go over 21. If you go over 21, you lose.", 10, 70);
                g.drawString("To gain a card (add 2-10 numbers), choose hit.", 10, 90);
                g.drawString("Otherwise, choose stand to determine the winner.", 10, 110);
                g.drawString("Type PLAY to begin!", 10, 130);
            }
            else if (state == 1)
            {
                g.drawImage(gamePlay, 0, 0, this);

                if (images != null && roll1 > 0 && roll2 > 0 && roll1 <= 6 && roll2 <= 6) {

                    System.out.println("\nDrawing dice - Debug Info:");
                    System.out.println("Roll 1: " + roll1 + ", Image index: " + (roll1 - 1));
                    System.out.println("Roll 2: " + roll2 + ", Image index: " + (roll2 - 1));


                    if (images[roll1 - 1] == null || images[roll2 - 1] == null)
                    {
                        System.out.println("Error: Dice images are null - Roll1 image: " + images[roll1 - 1] +
                                ", Roll2 image: " + images[roll2 - 1]);
                    }
                    else {


                        // Fixed positions with good spacing
                        int die1X = 300;
                        int die2X = 500;
                        int dieY = 140;

                        // Draw dice
                        g.drawImage(images[roll1 - 1], die1X, dieY, this);
                        g.drawImage(images[roll2 - 1], die2X, dieY, this);


                        System.out.println("Drew dice at positions: (" + die1X + "," + dieY + ") and (" +
                                die2X + "," + dieY + ")");

                    }
                }
            }
            else if (state == 2)
            {
                g.drawImage(loss, 0, 0, this);
            }
            else if (state == 3)
            {
                g.drawImage(win, 0, 0, this);
            }
        }
    }
}
