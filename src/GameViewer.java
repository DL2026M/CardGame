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

    public GameViewer(Game game) {
        this.game = game;
        this.background = new ImageIcon("Resources/table.jpeg").getImage();
        this.cardBackSide = new ImageIcon("Resources/Cards/back.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawImage(background, 0, 0, 1000,750 ,this);
        g.setFont(new Font("Serif", Font.PLAIN, 50));
        g.drawString(game.getPlayer(1).getName(), 450, 700);
        g.drawString(game.getPlayer(2).getName(), 450, 100);

        // CHECK FOR ABSTRACTION HERE
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        g.drawString(" Betting Amount = $ " + Integer.toString(game.getPlayer(1).getBettingAmount()),+
                35, 700);
        g.drawString(" Betting Amount = $ " + Integer.toString(game.getPlayer(2).getBettingAmount()),+
                600, 80);

        // CHECK FOR ABSTRACTION HERE
        g.drawImage(cardBackSide, 400, 225, 125,125,this);
        g.drawImage(cardBackSide, 450, 225, 125,125,this);
        g.drawImage(cardBackSide, 400, 400, 125,125,this);
        g.drawImage(cardBackSide, 450, 400, 125,125,this);

    }
}
