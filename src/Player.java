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

    // Returns how many points the player has and the players hand
    public String toString() {
        return name + " has " + points + " points" + "\n" + name + "'s cards: " + hand;
    }
}
