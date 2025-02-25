import java.awt.*;

public class Card {
    // Instance variables
    private String rank;
    private String suit;
    private int value;
    private Image image;


    // Constructor that initializes the cards rank, suit, and value
    public Card(String rank, String suit, int value, Image image) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        this.image = image;
    }

    // Getters & setter methods
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Returns the rank and suit of the card
    public String toString() {
        return rank + " of " + suit;
    }
}
