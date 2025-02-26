import javax.swing.*;
import java.awt.*;

// Front end
public class GameViewer extends JFrame {
    // Instance Variables
    private Game game;
    private Image cardBackSide;
    private Image background;
    private Image introPage;
    private Image aceCard;

    // 0 equals in instructions page, 1 equals gameplay, and 2 equals winning page
    private int gameState = 0;
    private boolean cardsUp = false;
    // Constants
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 750;
    private final int TOTAL_CARDS = 53;
    private int CARD_DIMENSIONS = 125;
    private int CARD_YCORD_PLAYER1 = 400;
    private int FIRSTCARD_XCORD_PLAYER1 = 400;
    private int CARD_YCORD_PLAYER2 = 225;
    private int SECONDCARD_XCORD_PLAYER2 = 400;
    private int FONT_SIZE = 40;
    private final int PLAYERNAMES_XCORD= 450;
    private final int PLAYER1_YCORD = 650;
    private final int PLAYER2_YCORD = 120;
    private final int PLAYER1_XCORD_BETTING = 35;
    private final int PLAYER2_XCORD_BETTING = 600;
    private final int PLAYER1_YCORD_BETTING= 700;
    private final int PLAYER2_YCORD_BETTING = 80;
    private final int STARTING_XCORD = 0;
    private final int STARTING_YCORD = 0;
    private final int INTRO_QUESTION_XCORD = 60;
    private final int INTRO_QUESTION_YCORD = 100;
    private final int INTROCARDS_YCORD = 300;
    private final int ACE_XCORD = 200;
    private final int BACKSIDE_XCORD = 500;
    private final int INTROCARD_DIMENSIONS = 350;
    // CHANGE GAME.GETPLAYER(1 || 2) TO A INSTANCE VARIABLE - DOES THIS WORK
    //private Player Player1;
    // GET A MARGIN VARIABLE THAT I CAN USE DOING A FOR LOOP FOR DIMENSIONS


    public GameViewer(Game game) {
        this.game = game;
        this.background = new ImageIcon("Resources/table.jpeg").getImage();
        this.cardBackSide = new ImageIcon("Resources/Cards/back.png").getImage();
        this.introPage = new ImageIcon("Resources/blankTable.png").getImage();
        this.aceCard = new ImageIcon("Resources/Cards/1.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("BlackJack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    public void paint(Graphics g) {
        // Beckett taught me how to do a switch statement
        g.setColor(Color.black);
        switch(gameState) {
            // Beginning of the game page
            case 0:
                g.drawImage(introPage, STARTING_XCORD, STARTING_YCORD, WINDOW_WIDTH,WINDOW_HEIGHT,this);
                g.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE - 10));
                g.drawString("The instructions are displayed in the terminal. Enter Yes if you want to play: ",
                        INTRO_QUESTION_XCORD, INTRO_QUESTION_YCORD);
                g.drawString("If you want to play, enter your name and betting amount into the terminal: ",
                        INTRO_QUESTION_XCORD, INTRO_QUESTION_YCORD+75);
                g.drawImage(aceCard, ACE_XCORD, INTROCARDS_YCORD, INTROCARD_DIMENSIONS,INTROCARD_DIMENSIONS,
                        this);
                g.drawImage(cardBackSide,BACKSIDE_XCORD, INTROCARDS_YCORD, INTROCARD_DIMENSIONS,INTROCARD_DIMENSIONS,
                        this);
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
                // ASK IF I CAN MAKE THIS ONE FOR LOOP FOR CASE #2
                // Draws 4 cards face down
                if (!cardsUp) {
                    for (int i = 0; i < 2; i++) {
                        g.drawImage(cardBackSide, FIRSTCARD_XCORD_PLAYER1 + (i * 50), CARD_YCORD_PLAYER1, CARD_DIMENSIONS,
                                CARD_DIMENSIONS, this);
                        g.drawImage(cardBackSide, SECONDCARD_XCORD_PLAYER2 + (i * 50), CARD_YCORD_PLAYER2, CARD_DIMENSIONS,
                                CARD_DIMENSIONS, this);
                        cardsUp = true;
                    }
                }
                else {
                    for (int j = 0; j < game.getPlayer(1).getHand().size(); j++) {
                        g.drawImage(game.getPlayer(1).getHand().get(j).getImage(),FIRSTCARD_XCORD_PLAYER1 + (j*50),
                                CARD_YCORD_PLAYER1, CARD_DIMENSIONS, CARD_DIMENSIONS, this);
                    }
                }
                break;
            case 2:
                // Winning page
                break;
        }

    }
}
