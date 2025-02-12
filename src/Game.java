import java.awt.*;
import java.util.Scanner;

public class Game {

    private static final int MAX_HAND_VALUE = 21;
    private final Viewer window;
    private final Scanner scanner;
    private int gameState;

    public Game() {
        this.window = new Viewer(this);
        this.scanner = new Scanner(System.in);
    }

    public static boolean checkStatus(int playerHand) {
        if (playerHand > MAX_HAND_VALUE) {
            System.out.println("Bust! You lose");
            return false;
        } else if (playerHand == MAX_HAND_VALUE) {
            System.out.println("21! You won!");
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

        while (!player.getPlayInput().equals("PLAY")) {
            // Loop until player inputs "PLAY"
        }

        boolean playing = true;
        int playerHand = 0;

        while (playing) {
            displayGameState(player);
            if (getPlayerChoice() == 1) {
                playerHand = player.Hit();
                playing = checkStatus(playerHand);
            } else {
                playing = false;
                displayFinalGameState(player, dealer);
                determineWinner(playerHand, dealer.getHand());
            }
        }
    }

    private void determineWinner(int playerHand, int dealerHand) {
        if (playerHand > MAX_HAND_VALUE) {
            System.out.println("You busted! Dealer wins.");
        } else if (playerHand < dealerHand) {
            System.out.println("You lost. Good luck next time");
        } else if (playerHand == dealerHand) {
            System.out.println("You tied! Good luck next time");
        } else {
            System.out.println("You won! Congrats");
        }
    }

    public static void main(String[] args) {
        new Game().startGame();
    }
}