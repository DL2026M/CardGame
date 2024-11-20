import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // Instance variables
    private Player player;
    private Deck gameDeck;

    public Game() {
        // Each characteristic of a card
        String[] ranks = {"Ace", "2", "3", "4", "5","6","7","8","9","10","Jack","Queen","King"};
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        // Multiple 10 values as Jack, Queen, and King are worth 10 points each in BlackJack
        // Ace value set to 1 regardless of house or player hand
        int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,10};

        // Asking the player for their name
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your game name: ");
        String playerName = input.nextLine();

        // Creates a new player object
        Player gamePlayer = new Player(playerName);
        // Creates a new game deck object that has cards with a rank, suit, and value
        gameDeck = new Deck(ranks, suits, values);
    }
    public void printInstructions() {
        System.out.println("");

    }
}
