import java.awt.*;

public class Card {
    // Instance variables
    private String rank;
    private String suit;
    private int value;
    private Image image;
    /**
        // Content Standard #3: Can write a class containing instance variables, constructors, and methods, using access
        // modifiers (private vs public) appropriately.
        // This entire card class is a perfect example of a class that contains instance variables, a constructor that
        // initializes the instance variables, a toString method that ranks the rank and suit of a card, and public
        // getters/setters for all the attributes of a card (rank, suit, value, and image).
        */

    // Constructor that initializes the cards rank, suit, and value
    public Card(String rank, String suit, int value, Image image) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        this.image = image;
    }
    /**
        // Content Standard #4: Can write methods, including accessors (getters) and mutators (setters), with correct
        // return types.
        // All the getters displayed below have no parameters and a correct return type. For example, the getRank() and
        // getSuit() methods return a string because both the rank and suit's data types are strings. The setters below
        // have a void return type and take in one parameter (the data type depends on what is being set).
        */

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

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    // Returns the rank and suit of the card
    public String toString() {
        return rank + " of " + suit;
    }
}
