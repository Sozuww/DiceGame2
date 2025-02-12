public class Dealer {

    private int hand;
    private final int random = (int) (Math.random() * 4);

    private final int MAX_HAND_VALUE = 21;

    public Dealer(int diff)
    {

        if(diff == 1)
        {
            hand = easy();
        }

        else if(diff == 2)
        {
            hand = medium();
        }

        else
        {
            hand = hard();
        }
    }

    // Different difficulty levels; each level is slightly randomized
    private int easy()
    {
        while (hand < (7 + random))
        {
            hand += Die.drawCard();
            if (hand > 24)
            {
                return 22;
            }
        }


        return hand;
    }

    private int medium()
    {
        while (hand < (12 + random))
        {
            hand += Die.drawCard();
            if (hand > MAX_HAND_VALUE)
            {
                return 22;
            }
        }

        return hand;
    }

    private int hard()
    {
        while (hand < (17 + random))
        {
            hand += Die.drawCard();
            if (hand > MAX_HAND_VALUE)
            {
                hand = 0;
            }
        }

        return hand;
    }


    public int getHand()
    {

        return hand;

    }

}