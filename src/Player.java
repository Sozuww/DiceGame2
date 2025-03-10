import java.util.Scanner;

public class Player {
    private Scanner scanner;
    private int playerHand;
    private int lastRoll;
    private Die d1;

    public Player(){
        scanner = new Scanner(System.in);
        playerHand = 0;
        d1 = new Die(6);
    }

    public String getPlayInput() {
        return scanner.nextLine();
    }

    public int getDifficulty() {
        System.out.println("What level of black jack would you like to play? Easy (1) Medium (2) or Hard (3)?");
        return scanner.nextInt();
    }

    public void Hit() {
        lastRoll = d1.roll();
        playerHand += lastRoll;
    }

    public int getLastRoll()
    {
        return lastRoll;
    }

    public int getHand()
    {
        return playerHand;
    }
}