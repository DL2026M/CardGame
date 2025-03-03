import java.util.ArrayList;

public class Player {
    // Instance variables
    private String name;
    /**
        // Content Standard #6: Understand the differences between Arrays and ArrayLists and can articulate the reasons for
        // using one over the other.
        // The difference between Arrays and ArrayLists is that you cannot change the size of an array once it’s declared
        // (fixed size), but can change the size of an ArrayList once it's declared. This means you cannot add or remove an
        // element to an Array, but can for an ArrayList. If the problem you are coding/solving requires you to add or
        // remove elements, you have to use an ArrayList. In addition, ArrayLists don’t hold primitive object types
        // (Int, double, boolean, or char) and instead you have to use a wrapper class. If you have a fixed size
        // (grid or something), you have to use Arrays. In this case, the amount of cards a player has in the hands cannot
        // be fixed as they could add more cards, which is why this is an ArrayList.
        */
    private ArrayList<Card> hand;
    /**
     // Content Standard #5: Can declare and initialize Arrays, ArrayLists, and 2D Arrays.
     // Line #17 declares an ArrayList and line #35 initializes this ArrayList. In my Game class, I declare and
     // initialize multiple 1D array's. For example, in the Game class I declare 3 Arrays from line #12 to line #14.
     // I initialize these Arrays between line #23 to line #25. This line of code would be the same for a 2D Array
     // beside adding arrayName[][] while declaring and initializing both the rows and columns.
     */
    private int points;
    private int bettingAmount;

    // Constructor that initializes the name, players hand, and sets points to 0
    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = hand;
        points = 0;
    }

    // Constructor that initializes the name, creates a new card, and sets points to 0
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        points = 0;
    }

    // Getters & setter methods
    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public int addPoints(int addedPoints) {
        return points += addedPoints;
    }

    public void addCard(Card otherCard) {
        hand.add(otherCard);
        addPoints(otherCard.getValue());
    }
    public int getBettingAmount() {
        return bettingAmount;
    }
    public void setBettingAmount(int bettingAmount) {
        this.bettingAmount = bettingAmount;
    }
    // Returns how many points the player has and the players hand
    public String toString() {
        return name + " has " + points + " points" + "\n" + name + "'s cards: " + hand;
    }
}
