/*
 * MouseClick listener and mouse adapter to override the listener anonymously
 * Challenge what to change to make it a two player game
 * 
 */
/**
 *
 * @author Hales
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameDisplay extends JPanel {

    private int cellSize = 30;
    private int startX = 20;
    private int startY = 20;
    private double tokenScale = 0.75;

    private Color[] colors = {Color.red, Color.black, Color.white, Color.lightGray};

    private GameLogic game;

    public GameDisplay(GameLogic gam) {
        game = gam;

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                interpretClick(me);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                keyReader(ke);
            }
        });

        this.setFocusable(true); //game display panel will have focus
        this.setFocusTraversalKeysEnabled(false); //whatever key is pressed will get attention
    }

    public void keyReader(KeyEvent ke) {

        int code = ke.getKeyCode();
        System.err.print("\n Key Pressed " + code);

        switch (code) {
            case KeyEvent.VK_UP:
                game.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                game.moveDown();
                break;
            case KeyEvent.VK_RIGHT:
                game.moveRight();
                break;
            case KeyEvent.VK_LEFT:
                game.moveLeft();
                break;
            case KeyEvent.VK_S:
                game.saveToFile("TrialGame.dat");
            case KeyEvent.VK_R:
                game.initFromFile("TrialGame.dat");
                repaint();
                return;
        }
        repaint();
    }

    public void interpretClick(MouseEvent me) {
        System.err.print("\nMouse clicked at " + me.getX() + ", " + me.getY());
        int clickedX = me.getX();
        int clickedY = me.getY();

        if (clickedX < startX || clickedY < startY
                || clickedX > startX + game.fetchCols() * cellSize
                || clickedY > startY + game.fetchRows() * cellSize) {
            System.err.print("\nYOU ARE CLICKING OUTSIDE THE BOARD!");
        } else {
            int clickedRow = (clickedY - startY) / cellSize; //gives integer of row
            int clickedCol = (clickedX - startX) / cellSize; //gives integer of column
            System.err.println("\nYou clicked on row " + clickedRow + " And column " + clickedCol);

            game.makeMove(clickedRow, clickedCol);

            repaint(); //repaint method
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x;
        int y = startY; //multiplication operations are more costly in machine cycles

        int tokenSize = (int) (cellSize * tokenScale);
        int tokenIndent = (cellSize - tokenSize) / 2;

        for (int row = 0; row < game.fetchRows(); row++) {
            x = startX;
            for (int col = 0; col < game.fetchCols(); col++) {
                g.setColor(colors[(row + col) % 2]);
                g.fillRect(x, y, cellSize, cellSize);

                if (game.checkForToken(row, col)) {
                    g.setColor(colors[2]);
                    g.fillOval(x + tokenIndent, y + tokenIndent, tokenSize, tokenSize);
                }
                x += cellSize; //More efficient machine cycles
            }
            y += cellSize;
        }
        int curX = game.getCurCol() * cellSize + startX;
        int curY = game.getCurRow() * cellSize + startY;

        g.setColor(colors[3]);
        g.fillOval(curX + 2 * tokenIndent, curY + 2 * tokenIndent, tokenSize - 2
                * tokenIndent, tokenSize - 2 * tokenIndent);
    }
}
