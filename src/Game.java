// Created by David Lutch on December 4th, 2024
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // Instance variables
    private Player player1;
    private Player player2;
    private Deck gameDeck;
    // Each characteristic of a card
    private String[] ranks;
    private String[] suits;
    // Multiple 10 values as Jack, Queen, and King are worth 10 points each in BlackJack
    // Ace value set to 1 regardless of house or player hand
    private int[] values;
    private int player1Betting;
    private int player2Betting;

    public Game() {
        // Initializing the deck
        ranks = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        suits = new String[]{"♥", "♣", "♠", "♢"};
        values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        // Asks the player for their name
        Scanner input = new Scanner(System.in);
        System.out.print("Player 1, Enter your game name: ");
        String playerName1 = input.nextLine();
        System.out.print("Player 2, Enter your game name: ");
        String playerName2 = input.nextLine();

        // Creates a new player object for both player 1 and player 2
        player1 = new Player(playerName1);
        player2 = new Player(playerName2);
        // Creates a new game deck object that has cards with a rank, suit, and value
        gameDeck = new Deck(ranks, suits, values);
        // Adds two cards to both player 1 and player 2's hand
        player1.addCard(gameDeck.deal());
        player1.addCard(gameDeck.deal());
        player2.addCard(gameDeck.deal());
        player2.addCard(gameDeck.deal());
    }
    // Prints out of the rules and instructions on how to play this version of blackjack
    private void printInstructions() {
        System.out.println("Welcome to playing BlackJack! Let's see how good your gambling skills are!");
        System.out.print("Here are the rules and instructions to play this version of BlackJack. ");
        System.out.println("");

    }
    // Asks the player if they would like to hit or stand
    // If they hit, then this method will call itself again
    // It will then ask the player if they want to hit again providing that they have less than 21 points
    private void playerHitMe(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.print(player + ", do you want to hit?\nIf you say no, then you choice to stand (enter yes or no): ");
        String hit = input.nextLine();
        if (hit.equals("yes") && (player.getPoints() < 21)) {
            player.addCard(gameDeck.deal());
            if (player.getPoints() > 21) {
                System.out.println(player + " has busted!");
                return;
            }
            playerHitMe(player);
        }
    }
    // Prints out if either or both of the players have a blackjack
    private void blackJack() {
        if (player1.getPoints() == 21) {
            System.out.println(player1 + " has blackjack!");
        }
        if (player2.getPoints() == 21) {
            System.out.println(player2 + " has blackjack!");
        }
    }

    // Prints out who won the game if there is a winner
    private void winner() {
        // Case #1: See's if player 1 has more points than player 2 and hasn't busted
        if (player1.getPoints() > player2.getPoints() && player1.getPoints() <= 21) {
                System.out.println("Congratulations! " + player1 + " has won the game with " + player1.getPoints() +
                        " points! You have won $" + player2Betting +
                        ". You should leave the casino with your earnings of $" +
                        (player1Betting + player2Betting));
        }
        // Case #2: See's if player 2 has more points than player 1 and hasn't busted
        else if (player2.getPoints() > player1.getPoints() && player2.getPoints() <= 21) {
            System.out.println("Congratulations! " + player2 + " has won the game with " + player2.getPoints() +
                    " points! You have won $" + player1Betting +
                    ". You should leave the casino with your earnings of $" +
                    (player1Betting + player2Betting));
        }
        // Case #3: See's if player 1 has busted and player 2 hasn't busted
        else if (player1.getPoints() > 21 && player2.getPoints() <= 21) {
            System.out.println("Congratulations! " + player2 + " has won the game with " + player2.getPoints() +
                    " points! You have won $" + player1Betting +
                    ". You should leave the casino with your earnings of $" +
                    (player1Betting + player2Betting));
        }
        // Case #4: See's if player 2 has busted and player 1 hasn't busted
        else if (player2.getPoints() > 21 && player1.getPoints() <= 21) {
            System.out.println("Congratulations! " + player1 + " has won the game with " + player1.getPoints() +
                    " points! You have won $" + player2Betting +
                    ". You should leave the casino with your earnings of $" +
                    (player1Betting + player2Betting));
        }
    }
    // Checks to see if either both of the players have busted or if they have the same amount of points
    private void isTieGame() {
        if ((player1.getPoints() > 21) && (player2.getPoints() > 21)) {
            System.out.println("Tie");
        }
        if (player1.getPoints() == player2.getPoints()) {
            System.out.println("Tie");
        }
    }
    // Asks player 1 how much they would like to bet
    private void bettingAmountPlayer1() {
            Scanner input = new Scanner(System.in);
            System.out.print(player1.getName() + " Enter how much you want to bet on this round of blackjack." +
                    " Only integers are valid to bet. Place your bet: $ ");
            player1Betting = input.nextInt();
        }
    // Asks player 2 how much they would like to bet
    private void bettingAmountPlayer2() {
            Scanner input = new Scanner(System.in);
            System.out.print(player2.getName() + " Enter how much you want to bet on this round of blackjack." +
                    " Only integers are valid to bet. Place your bet: $ ");
            player2Betting = input.nextInt();
        }
    // All the methods put here to play the full game of blackjack
    private void playBlackJack() {
        // Prints the instructions and the rules of blackjack to both of the players
        printInstructions();
        // Gets how much player 1 wants to bet
        bettingAmountPlayer1();
        // Gets how much player 2 wants to bet
        bettingAmountPlayer2();
        // Checks to see if player 1 wants to hit
        // This method continues to call itself if the player 1 is under 21 and wants to hit again
        playerHitMe(player1);
        // Checks to see if player 1 has gotten blackjack
        blackJack();
        // This method continues to call itself if the player 2 is under 21 and wants to hit again
        playerHitMe(player2);
        // Checks to see if player 2 has gotten blackjack
        blackJack();
        // Checks to see if both of the players have busted or if they have the same amount of points
        isTieGame();
        // Prints out who has won the game and with how points
        // This method also prints out how much the winning player has made
        winner();

    }
    // Creates a new game and plays the game of blackjack
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.playBlackJack();
    }
}
