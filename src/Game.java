import java.awt.*;
import java.util.Scanner;

public class Game {

    public static final int maxHandValue = 21;
    private Image[] images;
    private Viewer window;


    public Game()
    {
        this.window = new Viewer(this);
    }

    public static boolean checkStatus(boolean playing, int playerHand)
    {
        if(playerHand > maxHandValue)
        {
            System.out.println("Bust! You lose");
            playing = false;
        }

        else if (playerHand == maxHandValue)
        {
            System.out.println("21! You won!");
            playing = false;
        }

        return playing;

    }
    public void GameState(Player player)
    {
        System.out.println("\n\t--- Current Game State ---");
        System.out.println("\t     Player's hand: " + player.getHand());
        System.out.println("\t     Dealers's hand: ▒▒");
        System.out.println("\t----------------------------\n");
    }

    public void finalGameState(Player player, Dealer dealer)
    {
        System.out.println("\n\t---  Final Game State  ---");
        System.out.println("\t     Player's hand: " + player.getHand());
        System.out.println("\t     Dealers's hand: " + dealer.getHand());
        System.out.println("\t----------------------------\n\n");
    }

    public static void main(String[] args) {
        Player p1 = new Player();
        Scanner scanner = new Scanner(System.in);

        String play = p1.getPlayInput();

        while (!play.equals("PLAY")) {
            play = p1.getPlayInput();
        }

        int difficulty = p1.getDifficulty();
        Dealer theDealer = new Dealer(difficulty);

        Game game = new Game();

        boolean playing = true;
        int playerHand = 0;
        int choice;

        while (playing) {
            int dealerHand = theDealer.getHand();

            game.GameState(p1);

            do {

                System.out.print("Do you want to hit? (1 for yes or 2 for no)\n");
                if (scanner.hasNextInt())
                {
                    choice = scanner.nextInt();
                    if (choice == 1 || choice == 2)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid Choice. Please enter (1 for yes or 2 for no)\n");
                    }
                }


                else {
                    System.out.println("Invalid Choice. Please enter (1 for yes or 2 for no)");
                    scanner.next();

                }
            } while (true);

            if (choice == 1) {
                playerHand = p1.Hit();
                playing = checkStatus(playing, playerHand);
            }

            else {
                playing = false;

                game.finalGameState(p1, theDealer);

                if (playerHand < dealerHand)
                {
                    System.out.println("You lost. Good luck next time");
                }

                else if (playerHand == dealerHand)
                {
                    System.out.println("You tied! Good luck next time");
                }

                else
                {
                    System.out.println("You won! Congrats");
                }

            }
        }


    }

}