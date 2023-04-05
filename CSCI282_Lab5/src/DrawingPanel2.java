/* Learning how to draw polygons in Java
 * Benedict Lee
 * 13 July 2022
 */
import javax.swing.*;
import java.awt.*;

public class DrawingPanel2 extends JPanel {

    int strokeWeight = 3;

    @Override
    public void paintComponent(Graphics g) {
        this.setBackground(Color.white);
        this.drawDesign(g, 350, 400, 125, 360);
    }

    public void drawDesign(Graphics g, int xCenter, int yCenter, int halfWidth, 
            int angle) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(strokeWeight));

        int redValue = 255;
        int greenValue = 0;
        int blueValue = 255;
        int maxValue = 255;
        
        int angleIncrement = 5;

        while (angle < 360) {
            Color myColor = new Color(redValue, greenValue, blueValue);
            g.setColor(myColor);
            
            int x1 = xCenter + (int) (halfWidth * Math.cos(Math.toRadians(angle)));
            int x2 = xCenter + (int) (halfWidth * Math.cos(Math.toRadians(angle + 90)));
            int x3 = xCenter + (int) (halfWidth * Math.cos(Math.toRadians(angle + 180)));
            int x4 = xCenter + (int) (halfWidth * Math.cos(Math.toRadians(angle + 270)));
            int y1 = yCenter + (int) (halfWidth * Math.sin(Math.toRadians(angle)));
            int y2 = yCenter + (int) (halfWidth * Math.sin(Math.toRadians(angle + 90)));
            int y3 = yCenter + (int) (halfWidth * 3 * Math.sin(Math.toRadians(angle + 180)));
            int y4 = yCenter + (int) (halfWidth * Math.sin(Math.toRadians(angle + 270)));
            int[] xes = {x1, x2, x3};
            int[] yes = {y1, y2, y3};
            
            g.drawPolygon(xes, yes, xes.length);
            angle += angleIncrement;
            greenValue += 10;
            if (greenValue > maxValue) {
                greenValue = 0;
            }
        }
    }

    public static void main(String[] args) {
        int winWid = 900;
        int winHei = 700;
        JFrame myFrame = new JFrame("My Rotation Image");
        myFrame.setSize(winWid, winHei);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.add(new DrawingPanel2());

        myFrame.setVisible(true);
    }
}
