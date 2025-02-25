import javax.swing.*;
import java.awt.*;

// Front end
public class GameViewer extends JFrame {
    // Instance Variables
    private Game game;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 750;
    private Image cardBackSide;
    private final int TOTAL_CARDS = 53;
    private Image background;
    // Constants
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
    // GET A MARGIN VARIABLE THAT I CAN USE DOING A FOR LOOP FOR DIMENSIONS
    // MAKE CONSTANTS FOR ALL OF THE NUMBERS AROUND THE GAME


    public GameViewer(Game game) {
        this.game = game;
        this.background = new ImageIcon("Resources/table.jpeg").getImage();
        this.cardBackSide = new ImageIcon("Resources/Cards/back.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("BlackJack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawImage(background, 0, 0, WINDOW_WIDTH,WINDOW_HEIGHT,this);
        g.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
        g.drawString(game.getPlayer(1).getName(), PLAYERNAMES_XCORD, PLAYER1_YCORD);
        g.drawString(game.getPlayer(2).getName(), PLAYERNAMES_XCORD, PLAYER2_YCORD);

        g.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE - 10));
        g.drawString(" Betting Amount = $" + Integer.toString(game.getPlayer(1).getBettingAmount()),+
                PLAYER1_XCORD_BETTING, PLAYER1_YCORD_BETTING);
        g.drawString(" Betting Amount = $" + Integer.toString(game.getPlayer(2).getBettingAmount()),+
                PLAYER2_XCORD_BETTING, PLAYER2_YCORD_BETTING);

        for (int i = 0; i < 2; i++) {
            g.drawImage(cardBackSide, FIRSTCARD_XCORD_PLAYER1 + (i * 50), CARD_YCORD_PLAYER1, CARD_DIMENSIONS,
                    CARD_DIMENSIONS, this);
            g.drawImage(cardBackSide, SECONDCARD_XCORD_PLAYER2 + (i * 50), CARD_YCORD_PLAYER2, CARD_DIMENSIONS,
                    CARD_DIMENSIONS, this);
        }

    }
}
