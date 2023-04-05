/* Creates all components related to the game though the method paintComponent
 * Will listen to keyboard input to determine movement of bricks in game
 * Displays the status of the game
 */
/** Displays Tetris Game using four methods
 *
 * @author benedictlee
 * @version 1.00 
 * 27 June 2022
 */
import java.awt.*;
import javax.swing.*;

public class TetrisDisplay extends JPanel {

    private TetrisGame game;
    private int startX = 50;
    private int startY = 50;
    private int cellSize = 10;
    private int speed;
    private Timer timer;
    private Color[] colors;

    public TetrisDisplay(TetrisGame gam) {
        game = gam;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawWell(g);
    }

    public void drawWell(Graphics g) {
        int polygonCorners = 8;        
        int columns = cellSize * game.getCols();
        int rows = cellSize * game.getRows();

        int[] xCoords = new int[8];
        int[] yCoords = new int[8];

        xCoords[0] = startX;
        yCoords[0] = startY;

        xCoords[1] = xCoords[0];
        yCoords[1] = yCoords[0] + rows;

        xCoords[2] = xCoords[1] + columns;
        yCoords[2] = yCoords[1];

        xCoords[3] = xCoords[2];
        yCoords[3] = yCoords[2] - rows;

        xCoords[4] = xCoords[3] - 3;
        yCoords[4] = yCoords[3];

        xCoords[5] = xCoords[4];
        yCoords[5] = yCoords[4] + rows - 3;

        xCoords[6] = xCoords[0] + 3;
        yCoords[6] = yCoords[0] + rows - 3;

        xCoords[7] = xCoords[0] + 3;
        yCoords[7] = yCoords[0];
        
        g.setColor(Color.white);
        g.fillRect(startX,startY,columns,rows);

        g.setColor(Color.black);
        g.fillPolygon(xCoords, yCoords,polygonCorners); 
               
        g.drawLine(xCoords[0],yCoords[0],xCoords[4],yCoords[4]);
    }

    public void drawBrick() {

    }

    private void cycleMove() {

    }
}
