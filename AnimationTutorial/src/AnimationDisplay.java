
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimationDisplay extends JPanel {

    AnimationGame game;
    Timer timer;
    int boardStart_x = 50;
    int boardStart_y = 30;
    int cellSize = 10;
    int wallWid = 10;

    private int delay = 300;

    public AnimationDisplay(AnimationGame gam) {
        game = gam;

        timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                updateAnimation();
            }
        });
        timer.start();
    }

    public void updateAnimation() {
        game.driftDown();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        drawWalls(g);
        drawBoard(g);
    }

    public void drawWalls(Graphics g) {
// Left wall
        g.fillRect(boardStart_x - wallWid, boardStart_y - wallWid,
                wallWid, cellSize * game.getRows() + 2 * wallWid);
// Top wall
        g.fillRect(boardStart_x - wallWid, boardStart_y - wallWid,
                cellSize * game.getCols() + 2 * wallWid, wallWid);
// Left Wall
        g.fillRect(boardStart_x + cellSize * game.getCols(),
                boardStart_y - wallWid, wallWid,
                cellSize * game.getRows() + 2 * wallWid);
// Bottom Wall
        g.fillRect(boardStart_x - wallWid,
                boardStart_y - wallWid + cellSize * game.getRows() + wallWid,
                cellSize * game.getCols() + 2 * wallWid, wallWid);
    }

    public void drawBoard(Graphics g) {
        for (int row = 0; row < game.getRows(); row++) {
            for (int col = 0; col < game.getCols(); col++) {
                if (game.getBoardPosition(row, col) == 1) {
                    g.setColor(Color.MAGENTA);
                    g.fillRect(boardStart_x + col * cellSize,
                            boardStart_y + row * cellSize, cellSize, cellSize);
                    g.setColor(Color.BLACK);
                    g.drawRect(boardStart_x + col * cellSize,
                            boardStart_y + row * cellSize, cellSize, cellSize);
                }
            }
        }
    }
}
