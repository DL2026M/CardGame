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
        // Asking the player for their name
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
        player1.addCard(gameDeck.deal());
        player1.addCard(gameDeck.deal());
        player2.addCard(gameDeck.deal());
        player2.addCard(gameDeck.deal());
    }

    private void printInstructions() {
        System.out.println("Welcome to playing BlackJack against the house!");
        System.out.println("Here are the rules and instructions to play BlackJack");
        System.out.println("");

    }
    private void playerHitMe(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.print(player + ", do you want to hit? \n If you say no, then you choice to stand (enter yes or no): ");
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
    private void blackJack() {
        if (player1.getPoints() == 21) {
            System.out.println(player1 + " has blackjack!");
        }
        if (player2.getPoints() == 21) {
            System.out.println(player2 + " has blackjack!");
        }
    }

    // calculates who won the game
    private void winner() {
        if (player1.getPoints() > player2.getPoints()) {
            if (player1.getPoints() <= 21) {
                System.out.println("Congratulations! " + player1 + " has won the game with " + player2.getPoints() +
                        "points! You have won $ " + player2Betting +
                        " .You should leave the casino with your earnings of $ " +
                        (player1Betting + player2Betting));
            }
        } else if (player2.getPoints() > player1.getPoints() && player2.getPoints() <= 21) {
            System.out.println("Congratulations! " + player2 + " has won the game with " + player2.getPoints() +
                    "points! You have won $ " + player1Betting +
                    " .You should leave the casino with your earnings of $ " +
                    (player1Betting + player2Betting));
        } else if (player1.getPoints() > 21 && player2.getPoints() <= 21) {
            System.out.println("Congratulations! " + player2 + " has won the game with " + player2.getPoints() +
                    "points! You have won $ " + player1Betting +
                    " .You should leave the casino with your earnings of $ " +
                    (player1Betting + player2Betting));
        } else {
            System.out.println("Congratulations! " + player2 + " has won the game with " + player2.getPoints() +
                    "points! You have won $ " + player1Betting +
                    " .You should leave the casino with your earnings of $ " +
                    (player1Betting + player2Betting));
        }
    }
    // If both players stand, then call the isTie game method
    private void isTieGame() {
        if ((player1.getPoints() > 21) && (player2.getPoints() > 21)) {
            System.out.println("Tie");
        }
        if (player1.getPoints() == player2.getPoints()) {
            System.out.println("Tie");
        }
    }
    // How much player 1 wants to bet
    private void bettingAmountPlayer1() {
            Scanner input = new Scanner(System.in);
            System.out.print(player1.getName() + " Enter how much you want to bet on this round of blackjack." +
                    " Only integers are valid to bet. Place your bet: $ ");
            player1Betting = input.nextInt();
        }
    // How much player 2 wants to bet
    private void bettingAmountPlayer2() {
            Scanner input = new Scanner(System.in);
            System.out.print(player2.getName() + " Enter how much you want to bet on this round of blackjack." +
                    " Only integers are valid to bet. Place your bet: $ ");
            player2Betting = input.nextInt();
        }

    private void playBlackJack() {
        printInstructions();
        bettingAmountPlayer1();
        bettingAmountPlayer2();
        playerHitMe(player1);
        blackJack();
        playerHitMe(player2);
        blackJack();
        isTieGame();
        winner();

    }
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.playBlackJack();
    }
    }
//}
