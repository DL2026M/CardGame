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
    private boolean player1Turn = true;
    private boolean player2Turn = false;

    public Game() {
        // Initializing the deck
        ranks = new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        suits = new String[]{"Hearts", "Clubs", "Spades", "Diamonds"};
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

    public void printInstructions() {
        System.out.println("Welcome to playing BlackJack against the house!");
        System.out.println("Here are the rules and instructions to play BlackJack");
        System.out.println("");

    }
    //methods needed to play (create a turn system)
    // playerHitMe
    // stand
    // blackJack (if 21 points)
    // winner (if neither player busted)
    // bust (if higher than 21 points)
    // tieGame (if points are the same amount)
    // bettingAmount
    // split
    // Creating boolean variables to see who's turn it is
    // The game starts off with it being player 1's turn

    public void playerTurn() {
        if (player1Turn) {
            System.out.println("It's currently " + player1 + " turn!");
        } else {
            System.out.println("It's currently " + player2 + " turn!");
        }
    }

    public void changeTurns(boolean player1Turn, boolean player2Turn) {
        if (player1Turn) {
            player1Turn = false;
            player2Turn = true;
        } else {
            player1Turn = true;
            player2Turn = false;
        }
    }

    public void playerHitMe(Player otherPlayer) {
        otherPlayer.addCard(gameDeck.deal());
    }

    //public void stand(Player otherPlayer) {
    //   otherPlayer =
    //}
    public void blackJack() {
        if (player1.getPoints() == 21) {
            System.out.println(player1 + " has blackjack!");
        }
        if (player2.getPoints() == 21) {
            System.out.println(player2 + " has blackjack!");
        }
    }

    // calculates who won the game
    public void winner() {
        if (player1.getPoints() > player2.getPoints()) {
            if (player1.getPoints() <= 21) {
                System.out.println("Congratulations! " + player1 + " has won the game with " + player2.getPoints() +
                        "points! You have won $ " + bettingAmountPlayer2() +
                        " .You should leave the casino with your earnings of $ " +
                        (bettingAmountPlayer2() + bettingAmountPlayer1()));
            }
        }
        if (player2.getPoints() > player1.getPoints()) {
            if (player1.getPoints() <= 21) {
                System.out.println("Congratulations! " + player2 + " has won the game with " + player2.getPoints() +
                        "points! You have won $ " + bettingAmountPlayer1() +
                        " .You should leave the casino with your earnings of $ " +
                        (bettingAmountPlayer1() + bettingAmountPlayer2()));
            }
        }
    }

    // See's if either player has over 21 points
    public void bust() {
        if (player1.getPoints() > 21) {
            System.out.println(player1 + " has busted!");
        }
        if (player2.getPoints() > 21) {
            System.out.println(player2 + " has busted!");
        }
    }
//    public boolean bothPlayerStand() {
//
//    }
    // If both players stand, then call the isTie game method
    public boolean isTieGame() {
        if ((player1.getPoints() > 21) && (player2.getPoints() > 21)) {
              return true;
        }
    return (player1.getPoints() == player2.getPoints());
    }
    // How much player 1 wants to bet
    public int bettingAmountPlayer1() {
            Scanner input = new Scanner(System.in);
            System.out.print(player1 + " Enter how much you want to bet on this round of blackjack." +
                    " Only integers are valid to bet. Place your bet: $ ");
            int player1Betting = input.nextInt();
            return player1Betting;
        }
    // How much player 2 wants to bet
    public int bettingAmountPlayer2() {
            Scanner input = new Scanner(System.in);
            System.out.print(player2 + " Enter how much you want to bet on this round of blackjack." +
                    " Only integers are valid to bet. Place your bet: $ ");
            int player2Betting = input.nextInt();
            return player2Betting;
        }

    //public boolean isGameOver() {
        //if (player1.getPoints() > 21)
    //}
    // WILL ONLY MAKE THIS FUNCTION IF I HAVE TIME ()
    //public void splitMyHand(Player otherPlayer) {
        // if the cards are the same rank
        //if () {
            //System.out.println("Do you want to split your hand? If so, then you will ");

       // }
    public void playBlackJack() {
        printInstructions();
        playerTurn();
        changeTurns(player1Turn, player2Turn);
        //playerHitMe(player1);
        //playerHitMe(player2);
        blackJack();
        winner();
        bust();
        bettingAmountPlayer1();
        bettingAmountPlayer2();

    }
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.playBlackJack();
    }
    }
//}
