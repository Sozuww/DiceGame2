import java.util.Random;
public class Die
{
    /** Instance Variables **/

    private int numSides;
    private final Random random;

    /** Constructors **/

    public Die(int numSides) {
        this.numSides = numSides;
        this.random = new Random();
    }

    public Die() {
        numSides = 6;
        this.random = new Random();
    }

    /** Methods
     * Returns the number of sides on the Die.
     */

    public int roll() {
        return random.nextInt(numSides) + 1;
    }

    public static int drawCard()
    {
        Random random = new Random();
        return random.nextInt(9) + 2;
    }

}