import java.util.ArrayList;
//import java.util. (math class - don't forget)

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    //String[] ranks = {"Ace", "2", "3", "4", "5","6","7","8","9","10","Jack","Queen","King"};
    //String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
    // Multiple 10 values as Jack, Queen, and King are worth 10 points each in BlackJack
    // Ace value set to 1 regardless of house or player hand
    //int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,10};

    public Deck(String[] ranks, String[] suits, int[] values) {

        for (int i=0; i < ranks.length; i++) {
            for (int j=0; j < suits.length; j++) {
                Card fillerCard = new Card(ranks[i], suits[j], values[i]);
                cards.add(fillerCard);
            }
        }
        cardsLeft = suits.length * ranks.length;
        shuffle();
    }
    public boolean isEmpty() {
        return cardsLeft == 0;
    }
    public int getCardsLeft(){
        return cardsLeft;
    }
    public Card deal(){
        if (isEmpty()) {
            return null;
        }
    cardsLeft--;
    return cards.get(cardsLeft);

    }
    // For i = last index of the deck down to 0
    // Generate a random integer r (using Math.random) between 0 and i, inclusive
    // Exchange cards[i] and cards[r]
    public void shuffle() {
    int index = cards.size() - 1;
    int randomNumber = (int)(Math.random() * (index + 1));
    while(index >= 0) {
        Card temporary = cards.get(index);
        cards.set(index, cards.get(randomNumber));
        cards.set(randomNumber, temporary);
        index--;
    }
    cardsLeft = cards.size();
    }

}
