import java.util.Scanner;

public class Player {
    private Scanner scanner;
    private int playerHand;
    private static int lastCard;
    Die d1 = new Die(6);

    public Player(){
        scanner = new Scanner(System.in);
        playerHand = 0;
    }

    public String getPlayInput() {
        System.out.print("The goal of the game is to get a higher number than ");
        System.out.print("the dealer, but you can't go over 21. If you go over ");
        System.out.print("21, you lose. To gain a card (add 2-10 numbers), then ");
        System.out.print("choose hit. Otherwise, press stand, and you'll ");
        System.out.print("know if you win or lose. ");
        System.out.print("That's all for now, good luck!");

        System.out.println("\n");
        System.out.println("Type PLAY when you're ready to play");
        return scanner.nextLine();
    }

    public int getDifficulty() {
        System.out.println("What level of black jack would you like to play? Easy (1) Medium (2) or Hard (3)?");
        return scanner.nextInt();
    }

    public void Hit() {
        lastCard = d1.roll();
        playerHand += lastCard;
    }

    public static int getLastRoll()
    {
        return lastCard;
    }


    public int getHand()
    {
        return playerHand;
    }


}