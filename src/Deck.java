import java.util.ArrayList;

public class Deck {
    // Instance variables
    private ArrayList<Card> cards;
    private int cardsLeft;

    // This constructor initializes each of the 52 cards in the deck and gives each of them a rank, suit, and value
    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<Card>();
        for (int i=0; i < ranks.length; i++) {
            for (int j=0; j < suits.length; j++) {
                Card fillerCard = new Card(ranks[i], suits[j], values[i]);
                cards.add(fillerCard);
            }
        }
        cardsLeft = suits.length * ranks.length;
        shuffle();
    }

    // Returns if the there isn't any cards left
    public boolean isEmpty() {
        return cardsLeft == 0;
    }

    // Returns how many cards are left
    public int getCardsLeft(){
        return cardsLeft;
    }

    // Removes one from the cardsLeft variable and returns that card
    public Card deal(){
        if (isEmpty()) {
            return null;
        }
    cardsLeft--;
    return cards.get(cardsLeft);
    }

    // This function shuffles the deck of cards
    // For i = last index of the deck down to 0
    // Generates a random integer r (using Math.random) between 0 and i, inclusive
    // Exchange cards[i] and cards[r] to shuffle/mix up the cards
    public void shuffle() {
    int index = cards.size() - 1;
    int randomNumber = (int)(Math.random() * (index + 1));
    while(index >= 0) {
        Card temporary = cards.get(index);
        cards.set(index, cards.get(randomNumber));
        cards.set(randomNumber, temporary);
        index--;
        randomNumber = (int)(Math.random() * (index + 1));
    }
    cardsLeft = cards.size();
    }

}
