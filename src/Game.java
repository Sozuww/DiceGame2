import java.util.Scanner;

public class Game {

    private static final int MAX_HAND_VALUE = 21;
    private final Viewer window;
    private final Scanner scanner;
    private static int gameState;
    private int roll1;
    private int roll2;

    public Game() {
        this.window = new Viewer(this);
        this.scanner = new Scanner(System.in);
        gameState = 0;
    }

    public static boolean checkStatus(int playerHand) {
        if (playerHand > MAX_HAND_VALUE) {
            System.out.println("Bust! You lose");
            gameState = 2;
            return false;
        } else if (playerHand == MAX_HAND_VALUE) {
            System.out.println("21! You won!");
            gameState = 3;
            return false;
        }
        return true;
    }

    public void displayGameState(Player player) {
        System.out.println("\n\t--- Current Game State ---");
        System.out.println("\t     Player's hand: " + player.getHand());
        System.out.println("\t     Dealer's hand: ▒▒");
        System.out.println("\t----------------------------\n");
    }

    public void displayFinalGameState(Player player, Dealer dealer) {
        gameState = 3;
        window.updateView();
        System.out.println("\n\t---  Final Game State  ---");
        System.out.println("\t     Player's hand: " + player.getHand());
        System.out.println("\t     Dealer's hand: " + dealer.getHand());
        System.out.println("\t----------------------------\n\n");
    }

    private int getPlayerChoice() {
        int choice;
        while (true) {
            System.out.print("Do you want to hit? (1 for yes or 2 for no)\n");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    return choice;
                }
            }
            System.out.println("Invalid Choice. Please enter (1 for yes or 2 for no)\n");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public void startGame() {

        Player player = new Player();
        Dealer dealer = new Dealer(player.getDifficulty());


        System.out.println("Type PLAY when you're ready to play");
        while (!player.getPlayInput().equals("PLAY"))
        {
            // Loop until player inputs "PLAY"
        }

        gameState = 1;
        window.updateView(1, 1);
        boolean playing = true;

        while (playing) {
            displayGameState(player);
            if (getPlayerChoice() == 1) {
                player.Hit();
                roll1 = player.getLastRoll();
                player.Hit();
                roll2 = player.getLastRoll();
                window.updateView(roll1, roll2);
                playing = checkStatus(player.getHand());
            } else {
                playing = false;
                gameState = 2;
                displayFinalGameState(player, dealer);
                determineWinner(player.getHand(), dealer.getHand());
            }
        }

    }

    private void determineWinner(int playerHand, int dealerHand)
    {
        if (playerHand > MAX_HAND_VALUE || playerHand < dealerHand)
        {
            System.out.println("You lost. Good luck next time");
            gameState = 2;
        }

        else if (playerHand == dealerHand)
        {
            System.out.println("You tied! Good luck next time");
            gameState = 2;
        }
        else
        {
            System.out.println("You won! Congrats");
            gameState = 3;
        }

        window.updateView();
    }


    public static int getGameState() {
        return gameState;
    }

    public static void main(String[] args) {
        new Game().startGame();
    }
}