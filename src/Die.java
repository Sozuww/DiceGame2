import java.util.Random;
public class Die
{
    /** Instance Variables **/

    private int numSides;
    private int highest = 0;

    /** Constructors **/

    public Die(int numSides) {
        this.numSides = numSides;
    }

    public Die() {
        numSides = 6;
    }

    /** Methods
     * Returns the number of sides on the Die.
     */
    public int getSides() {
        return numSides;
    }

    /**
     * Returns a random int between 1 and 
     * the number of sides on the Die
     */
    public int roll() {
        return ((int) (1 + Math.random() * numSides));
    }

    /**
     * Rolls the dice the numRolls times 
     * and returns the max value of the rolls
     */
    public int getMaxRoll(int numRolls) {

        for (int i = 0; i < numRolls; i++)
        {
            int roll = roll();
            if(roll > highest)
            {
                highest = roll;
            }
        }
        return highest;
    }

    public static int drawCard()
    {
        Random random = new Random();
        return random.nextInt(9) + 2;
    }
    /**
     * Returns a String in the following form:
     * "This is a n-sided die."
     */
    public String toString() {
        return "This is a " + getSides() + "-sided die";
    }
}