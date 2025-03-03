// Created by David Lutch on March 2nd, 2025
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Front end
public class GameViewer extends JFrame {
    // Instance Variables
    private Game game;
    private Image cardBackSide;
    private Image background;
    private Image introPage;
    private Image winningPage;
    private String winningMessage;

    // 0 equals in instructions page, 1 equals gameplay, and 2 equals winning page
    private int gameState = 0;
    private boolean cardsUp = false;
    public boolean player1CardsUp = false;
    public boolean player2CardsUp = false;

    // Constants
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 750;
    private final int CARD_DIMENSIONS = 125;
    private final int YCORD_PLAYER1 = 400;
    private final int XCORD_PLAYER1 = 400;
    private final int YCORD_PLAYER2 = 225;
    private final int XCORD_PLAYER2 = 400;
    private final int FONT_SIZE = 40;
    private final int PLAYERNAMES_XCORD= 450;
    private final int PLAYER1_YCORD = 630;
    private final int PLAYER2_YCORD = 120;
    private final int PLAYER1_XCORD_BETTING = 35;
    private final int PLAYER2_XCORD_BETTING = 600;
    private final int PLAYER1_YCORD_BETTING= 700;
    private final int PLAYER2_YCORD_BETTING = 80;
    private final int STARTING_XCORD = 0;
    private final int STARTING_YCORD = 0;
    private final int WINNING_XCORD = 10;
    private final int WINNING_YCORD = 200;


    public GameViewer(Game game) {
        this.game = game;
        this.background = new ImageIcon("Resources/table.jpeg").getImage();
        this.cardBackSide = new ImageIcon("Resources/Cards/back.png").getImage();
        this.introPage = new ImageIcon("Resources/IntroWindow.png").getImage();
        this.winningPage = new ImageIcon("Resources/winningPage.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("BlackJack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    // A helper function that either draws a card face up or face down depending on the parameters inputted
    private void drawCards(Graphics g, ArrayList<Card> Cards, int xCord, int yCord, boolean faceUp) {
        for (int j = 0; j < Cards.size(); j++) {
            if (faceUp) {
                g.drawImage(Cards.get(j).getImage(), xCord + (j * 50), yCord, CARD_DIMENSIONS, CARD_DIMENSIONS,
                        this);
            }
            else {
                g.drawImage(cardBackSide, xCord + (j * 50), yCord, CARD_DIMENSIONS, CARD_DIMENSIONS, this);
            }
        }
    }

    public void setWinningMessage(String winningMessage) {
        this.winningMessage = winningMessage;
    }

    public void paint(Graphics g) {
        // Beckett taught me how to do a switch statement
        g.setColor(Color.black);
        switch(gameState) {
            // Beginning of the game page
            case 0:
                g.drawImage(introPage, STARTING_XCORD, STARTING_YCORD, WINDOW_WIDTH,WINDOW_HEIGHT,this);
                gameState++;
                break;
            // Gameplay page
            case 1:
                g.drawImage(background, STARTING_XCORD, STARTING_YCORD, WINDOW_WIDTH,WINDOW_HEIGHT,this);
                g.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
                g.drawString(game.getPlayer(1).getName(), PLAYERNAMES_XCORD, PLAYER1_YCORD);
                g.drawString(game.getPlayer(2).getName(), PLAYERNAMES_XCORD, PLAYER2_YCORD);
                // Displays the amount of money each played bet
                g.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE - 10));
                g.drawString(" Betting Amount = $" +
                        Integer.toString(game.getPlayer(1).getBettingAmount()), +
                        PLAYER1_XCORD_BETTING, PLAYER1_YCORD_BETTING);
                g.drawString(" Betting Amount = $" +
                        Integer.toString(game.getPlayer(2).getBettingAmount()), +
                        PLAYER2_XCORD_BETTING, PLAYER2_YCORD_BETTING);
                // Draws 4 cards face down
                if (!cardsUp) {
                    drawCards(g, game.getPlayer(1).getHand(), XCORD_PLAYER1, YCORD_PLAYER1, false);
                    drawCards(g, game.getPlayer(2).getHand(), XCORD_PLAYER2, YCORD_PLAYER2, false);
                    cardsUp = true;
                }
                else if (!player2CardsUp) {
                    drawCards(g, game.getPlayer(1).getHand(), XCORD_PLAYER1, YCORD_PLAYER1, true);
                    drawCards(g, game.getPlayer(2).getHand(), XCORD_PLAYER2, YCORD_PLAYER2, false);
                }
                // Draws player 1 cards face down and player 2 cards face up
                else if (!player1CardsUp) {
                    drawCards(g, game.getPlayer(1).getHand(), XCORD_PLAYER1, YCORD_PLAYER1, false);
                    drawCards(g, game.getPlayer(2).getHand(), XCORD_PLAYER2, YCORD_PLAYER2, true);
                }
                // Both players turns are over so all the cards will be drawn face up
                else {
                    drawCards(g, game.getPlayer(1).getHand(), XCORD_PLAYER1, YCORD_PLAYER1, true);
                    drawCards(g, game.getPlayer(2).getHand(), XCORD_PLAYER2, YCORD_PLAYER2, true);
                    gameState++;
                }
                break;
            case 2:
                // Winning page
                g.drawImage(winningPage, STARTING_XCORD, STARTING_YCORD, WINDOW_WIDTH,WINDOW_HEIGHT,this);
                g.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE -17));
                // Prints the winning message that displays how much the winning player won
                g.drawString(winningMessage, WINNING_XCORD, WINNING_YCORD);
                gameState++;
                break;
        }
    }
}
