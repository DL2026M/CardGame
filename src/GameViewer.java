import javax.swing.*;
import java.awt.*;

// Front end
public class GameViewer extends JFrame {
    // Instance Variables
    private Game game;
    private final int WINDOW_WIDTH = 750;
    private final int WINDOW_HEIGHT = 750;
    private Image cards;
    private final int TOTAL_CARDS = 53;

    public GameViewer(Game game) {
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        for (int i = 0; i < TOTAL_CARDS; i++) {
            String card = "Resources/" + i + ".png";
            this.cards = new ImageIcon(card).getImage();
        }
    }
}
