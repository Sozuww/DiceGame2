import java.util.Random;
public class Die
{
    /** Instance Variables **/

    private int numSides;

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

    public int roll() {
        return ((int) (1 + Math.random() * numSides));
    }

    public static int drawCard()
    {
        Random random = new Random();
        return random.nextInt(9) + 2;
    }

}