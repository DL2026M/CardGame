// Created by David Lutch on December 4th, 2024
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // Instance variables
    private Player player1;
    private Player player2;
    private Deck gameDeck;

    // Each characteristic of a card
    private final String[] ranks;
    private final String[] suits;
    private final int[] values;

    private GameViewer window;
    // Constant
    private final int MAX_POINTS = 21;

    public Game() {
        this.window = new GameViewer(this);
        // Initializing the deck
        ranks = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        suits = new String[]{"♥", "♣", "♠", "♢"};
        values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        // Asks the player for their name
        Scanner input = new Scanner(System.in);
        String willYouPlay = input.nextLine();
        if (willYouPlay.equals("Yes") || willYouPlay.equals("yes")) {
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
            for (int i = 0; i < 2; i++) {
                player1.addCard(gameDeck.deal());
                player2.addCard(gameDeck.deal());
            }
        }
        else {
            System.exit(0);
        }
    }
    public void printInstructions() {
        System.out.println("Welcome to playing BlackJack! Let's see how good your gambling skills are!\n" +
        "Here are the rules and instructions to play this version of BlackJack. Aces will be worth 1 point\n" +
        "throughout the entire game. First, both players must enter your name.\n" +
        "Then, each player will enter the amount of money they would like to bet.\n" +
        "After betting, player 1 will see their cards and be able to hit or stand. It will be player 2's turn once\n" +
        "player 1 stands or busts. Player 2 will then be able to hit or stand.\n" +
        "A player will bust if they have over 21 points. If both players stand and don't hit, whoever has the\n" +
        "number of points will win. If both players bust, then it's a tie game.\n" +
        "Once player 1 and player 2 make their moves, a winner will be declared unless it's a tie. Best of luck!\n");

    }

    /**
     * // Asks the player if they would like to hit or stand
     * // If they hit, then this method will call itself again
     * // It will then ask the player if they want to hit again providing that they have less than 21 points
     */
    private void playerHitMe(Player player) {
        window.repaint();
        Scanner input = new Scanner(System.in);
        System.out.print(player + ", do you want to hit?\nIf you say no, then you choice to stand (enter yes or no): ");
        String hit = input.nextLine();
        if (hit.equals("yes") && (player.getPoints() < MAX_POINTS)) {
            player.addCard(gameDeck.deal());
            // Checks to see if they have busted after hitting
            if (player.getPoints() > MAX_POINTS) {
                System.out.println(player + " has busted!");
                return;
            }
            playerHitMe(player);
        }
    }
    // Prints out if either or both of the players have a blackjack
    private void blackJack() {
        if (player1.getPoints() == MAX_POINTS) {
            System.out.println(player1 + " has blackjack!");
        }
        if (player2.getPoints() == MAX_POINTS) {
            System.out.println(player2 + " has blackjack!");
        }
    }

    // Prints out who won the game if there is a winner
    private void winner(Player winningPlayer, Player loserPlayer) {
        System.out.println("Congratulations! " + winningPlayer + " has won the game with " + winningPlayer.getPoints() +
                " points! You have won $" + loserPlayer.getBettingAmount() + ". You should leave the casino with your" +
                " earnings of $" + (winningPlayer.getBettingAmount() + loserPlayer.getBettingAmount()));
        }

    private void winningHelperFunction(Player player1, Player player2) {
        // Checks to see if player 1 has won the game
        if (player1.getPoints() > player2.getPoints() && player1.getPoints() <= MAX_POINTS ||
                (player2.getPoints() > MAX_POINTS && player1.getPoints() <= MAX_POINTS)) {
                    winner(player1, player2);
        }
        // Checks to see if player 2 has won the game
        else if (player2.getPoints() > player1.getPoints() && player2.getPoints() <= MAX_POINTS ||
                (player1.getPoints() > MAX_POINTS && player2.getPoints() <= MAX_POINTS)) {
                    winner(player2, player1);
        }
        else {
            System.out.println("Tie game! There is no winners and you didn't lose or make any money!");
        }
    }
    // ASK MS.NAMASIVAYAM ABOUT IF I CAN DO THIS IN A WHILE LOOP (BC THE GAME STOPS WORKING IF I DON'T ENTER A VALID INT
    // Asks each player how much they want to bet
    private void bettingAmount(Player player) {
            Scanner input = new Scanner(System.in);
            System.out.print(player.getName() + " Enter how much you want to bet on this round of blackjack." +
                    " Only integers are valid to bet. Place your bet: $ ");
            player.setBettingAmount(input.nextInt());
    }

    public Player getPlayer(int playerNumber) {
        if (playerNumber == 1) {
            return player1;
        }
        else {
            return player2;
        }
    }
    // ASK ABOUT REPAINT AND WHETHER TO PUT IT INO EACH SEPARATE FUNCTION
    private void playBlackJack() {
        printInstructions();
        window.repaint();
        bettingAmount(player1);
        window.repaint();
        bettingAmount(player2);
        window.repaint();
        playerHitMe(player1);
        window.repaint();
        blackJack();
        playerHitMe(player2);
        window.repaint();
        blackJack();
        window.repaint();
        winningHelperFunction(player1, player2);
    }
    // Creates a new game and plays the game of blackjack
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.playBlackJack();
    }
}
