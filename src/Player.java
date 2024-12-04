import java.util.ArrayList;

public class Player {
    // Instance variables
    private String name;
    private ArrayList<Card> hand;
    private int points;

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

    // Gets the name
    public String getName() {
        return name;
    }

    // Gets the players hand
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Gets the players points
    public int getPoints() {
        return points;
    }

    // Adds points
    public int addPoints(int addedPoints) {
        return points += addedPoints;
    }

    // Adds another card to the players hand
    public void addCard(Card otherCard) {
        hand.add(otherCard);
        addPoints(otherCard.getValue());
    }

    // Returns how many points the player has and the players hand
    public String toString() {
        return name + " has " + points + " points" + "\n" + name + "'s cards: " + hand;
    }
}
