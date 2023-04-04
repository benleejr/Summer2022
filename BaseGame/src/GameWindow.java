/* 
 *
 *
 */

/**
 *
 * @author Hales
 */
import javax.swing.*;

public class GameWindow extends JFrame {

    private int windWid = 500;
    private int winHei = 500;

    private GameDisplay display;
    private GameLogic game;

    private int rows = 10;
    private int cols = 10;

    public GameWindow() {
        this.setTitle("My Game Board");
        this.setSize(windWid, winHei);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //EXIT_ON_CLOSE is a constant but also conveys meaning

        game = new GameLogic(rows, cols); //Variable names will convey meaning
        display = new GameDisplay(game);

        this.add(display);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}
