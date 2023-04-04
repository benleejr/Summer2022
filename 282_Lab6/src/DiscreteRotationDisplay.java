/*
    Class containing display of the star and the board from
       the discrete rotation tutorial
    
    Benedict Lee
    
    Last Edit: 1 July 2022
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DiscreteRotationDisplay extends JPanel {

    private int cellSize = 40;

    private DiscreteRotationLogic game;
    private Color rose = new Color(0Xa31de2);
    private Color rose2 = new Color(0XF000F0);
    private Color rose3 = new Color(0XFCBEFC);
    private Color[] colors = {Color.black, rose, rose2, rose3};

    public DiscreteRotationDisplay(DiscreteRotationLogic gs) {
        game = gs;

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.out.println("mouse click: " + me.getX() + ", " + me.getY());
                interpretClick(me);
                clickToMoveUp(me);
                clickToMoveDown(me);
            }
        });
    }

    public void interpretClick(MouseEvent me) {
        int clickedX = me.getX();
        int clickedY = me.getY();
        if (clickedX >= 0 && clickedX <= 500 && clickedY >= 100 && clickedY <= 400) {
            game.makeMove("R");
        }
        repaint();
    }

    public void clickToMoveUp(MouseEvent me) {
        int clickedX = me.getX();
        int clickedY = me.getY();
        if (clickedX >= 0 && clickedX <= 500 && clickedY <= 100) {
            game.makeMove("U");
        }
        repaint();
    }

    public void clickToMoveDown(MouseEvent me) {
        int clickedX = me.getX();
        int clickedY = me.getY();
        if (clickedX >= 0 && clickedX <= 500 && clickedY >= 400) {
            game.makeMove("D");
        }
        repaint();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        // draw start design only
        for (int seg = 0; seg < game.getNumSegs(); seg++) {
            g.setColor(colors[game.getStarColor(seg)]);
            g.fillRect(game.getStarCol(seg) * cellSize,
                    game.getStarRow(seg) * cellSize,
                    cellSize, cellSize);
            g.setColor(colors[0]);
            g.drawRect(game.getStarCol(seg) * cellSize,
                    game.getStarRow(seg) * cellSize,
                    cellSize, cellSize);
        }

    }
}
