public class Card {
    // Instance variables
    private String rank;
    private String suit;
    private int value;

    // Constructor that initializes the cards rank, suit, and value
    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    // Gets the cards rank
    public String getRank() {
        return rank;
    }

    // Sets the cards rank
    public void setRank(String rank) {
        this.rank = rank;
    }

    // Gets the cards suit
    public String getSuit() {
        return suit;
    }

    // Sets the cards suit
    public void setSuit(String suit) {
        this.suit = suit;
    }

    // Gets the value of the card
    public int getValue() {
        return value;
    }

    // Sets the value of the card
    public void setValue(int value) {
        this.value = value;
    }

    // Returns the rank and suit of the card
    public String toString() {
        return rank + " of " + suit;
//        return "------------]\n" +
//                "|" + rank + suit +
//                "          |\n" +
//                "|            |\n" +
//                "|            |\n" +
//                "|            |\n" +
//                "|            |\n" +
//                "|            |\n" +
//                "|         " + rank + suit + "|\n" +
//                "[------------]" + "\n";


    }
}
