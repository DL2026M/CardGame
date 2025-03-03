import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Deck {
    // Instance variables
    private ArrayList<Card> cards;
    private int cardsLeft;

    // This constructor initializes each of the 52 cards in the deck and gives each of them a rank, suit, and value
    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<Card>();
        int counter = 1;
        /**
            // Content Standard #1: Understand how to use nesting to embed loops and conditionals inside of other loops
            // and conditionals.
            // While I don't have any if or while statements in my nested for loops for this code, I'll still explain it.
            // You could have one for loop (or more), and then  an if statement between or after both of those for loops.
            // This could be helpful for many different reasons, but one of these reasons can be to keep track of the sum
            // of the numbers in a 2D array.
            */
        for (int i=0; i < ranks.length; i++) {
            for (int j=0; j < suits.length; j++) {
                Image cardImage = new ImageIcon("Resources/Cards/" + counter + ".png").getImage();
                Card fillerCard = new Card(ranks[i], suits[j], values[i], cardImage);
                cards.add(fillerCard);
                counter++;
            }
        }
        cardsLeft = suits.length * ranks.length;
        shuffle();
    }

    // Returns if the there isn't any cards left
    public boolean isEmpty() {
        return cardsLeft == 0;
    }

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

    /**
      // This function shuffles the deck of cards
      // For i = last index of the deck down to 0
      // Generates a random integer r (using Math.random) between 0 and i, inclusive
      // Exchange cards[i] and cards[r] to shuffle/mix up the cards
     */
    public void shuffle() {
    int index = cards.size() - 1;
    int randomNumber = (int)(Math.random() * (index + 1));
    /**
    // Content standard #2: Can use if, while, and for.
        // An example of an if statement, which is used in my deal() method above, will return null if there isn't
        // any cards left in the cardsLeft variable. However, if there is cards, then the method will subtract 1
        // from the cardsLeft variable and return the updated number of cards left in the deck.

        // The while loop displayed below is used to shuffle the cards 52 times as index is declared above. The shuffling
        // code below will result in the cards swapping locations randomly while the index is greater or equal to 0.
        // After two cards are swapped, index will have one subtracted from it and the while loop will check to see if
        // index is above or equal to 0.

        // An example of a for loop (in this case a nested for loop, but many single for loops around my code), is
        // displayed above between lines 22 and 23. A for loop will run and operate the code inside of
        // it for a set amount, which in this case creates the cards images and all the attributes attached to each
        // card.
         */
    while(index >= 0) {
    /**
    // Content standard #7: Can use ArrayList methods.
        // While I don't use every ArrayList, I use more than half in my code. First, on line 26, I use the
        // .add() method when adding a new card that has a rank, suit, value, and an image to my cards ArrayList.
        // Secondly, I use the .get() method in this while loop to get the location of a card and to get a random number.
        // I also the .set() method in this while loop to set cards in the deck to a random locations throughout the deck
        // in order to get the cards properly shuffled. Finally, I use the .size() method to get the size of the card
        // deck. The size() method tells me how long an ArrayList is and starts counting from 0.
         */
        Card temporary = cards.get(index);
        cards.set(index, cards.get(randomNumber));
        cards.set(randomNumber, temporary);
        index--;
        randomNumber = (int)(Math.random() * (index + 1));
    }
    cardsLeft = cards.size();
    }

}
