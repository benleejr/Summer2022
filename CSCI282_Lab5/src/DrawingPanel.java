
/* Learning how to draw ovals and drawing rotational graphics.
 * Created own graphics through java.awt
 * Benedict Lee
 * 11 July 2022
 */
import javax.swing.*;
import java.awt.*; 

public class DrawingPanel extends JPanel {

    int strokeWeight = 2;
    
    @Override
    public void paintComponent(Graphics g) {
        this.setBackground(Color.black);
        int maxRadius = 200;
        int maxRadius2 = 350;
        int radiusIncrement = 15;
        int radiusIncrement2 = 30;
        for (int radius = 0; radius < maxRadius; radius += radiusIncrement) {
            drawDesign(g, 450, 350, radius, 0, 360);
        }
        for (int radius = 210; radius < maxRadius2; radius += radiusIncrement2) {
            drawDesign2(g, 450, 350, radius, 0, 360);
        }
    }

    public void drawDesign(Graphics g, int xCenter, int yCenter, int halfWidth,
            int angle, int maxAngle) {
        int angleIncrement = 13;
        int red = 255;
        int green = 100;
        int blue = 150;
        int redChange = 5;
        int greenChange = 5;
        int blueChange = 5;
        int maxRGB = 255;
        int minRGB = 0;

        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(strokeWeight));

        while (angle < maxAngle) {
            g2.setColor(new Color(red, green, blue));

            int x1 = xCenter + (int) (halfWidth * Math.cos(Math.toRadians(angle)));
            int x2 = xCenter + (int) (halfWidth * Math.cos(Math.toRadians(angle + 90)));
            int x3 = xCenter + (int) (halfWidth * Math.cos(Math.toRadians(angle + 180)));
            int x4 = xCenter + (int) (halfWidth * Math.cos(Math.toRadians(angle + 270)));
            int y1 = yCenter + (int) (halfWidth * Math.sin(Math.toRadians(angle)));
            int y2 = yCenter + (int) (halfWidth * Math.sin(Math.toRadians(angle + 90)));
            int y3 = yCenter + (int) (halfWidth * Math.sin(Math.toRadians(angle + 180)));
            int y4 = yCenter + (int) (halfWidth * Math.sin(Math.toRadians(angle + 270)));

            int xCoords[] = new int[]{x1, x2, x3, x4};
            int yCoords[] = new int[]{y1, y2, y3, y4};

            g.drawPolygon(xCoords, yCoords, xCoords.length);
            angle += angleIncrement;

            red -= redChange;
            green += greenChange;
            blue += blueChange;
            if (red < minRGB) {
                red = maxRGB;
            }
            if (green > maxRGB) {
                green = maxRGB;
            }
            if (blue > maxRGB) {
                blue = minRGB;
            }

        }
    }

    public void drawDesign2(Graphics g, int xCenter, int yCenter, int radius,
            int angle, int maxAngle) {

        int angleIncrement = 5;        
        int red = 255;
        int green = 100;
        int blue = 150;
        int redChange = 5;
        int greenChange = 5;
        int blueChange = 5;
        int maxRGB = 255;
        int minRGB = 0;

        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(strokeWeight));

        while (angle < maxAngle) {
            g2.setColor(new Color(red, green, blue));

            int x1 = xCenter + (int) (radius * Math.cos(Math.toRadians(angle)));
            int x2 = xCenter + (int) (radius * Math.cos(Math.toRadians(angle + 45)));
            int x3 = xCenter + (int) (radius * Math.cos(Math.toRadians(angle + 45)));
            int x4 = xCenter + (int) (radius * Math.cos(Math.toRadians(angle)));
            int y1 = yCenter + (int) (radius * Math.sin(Math.toRadians(angle)));
            int y2 = yCenter + (int) (radius * Math.sin(Math.toRadians(angle + 45)));
            int y3 = yCenter + (int) (radius * Math.sin(Math.toRadians(angle + 45)));
            int y4 = yCenter + (int) (radius * Math.sin(Math.toRadians(angle)));

            int xCoords[] = new int[]{x1, x2, x3, x4};
            int yCoords[] = new int[]{y1, y2, y3, y4};

            g.drawPolygon(xCoords, yCoords, xCoords.length);
            angle += angleIncrement;            

            red -= redChange;
            green += greenChange;
            blue += blueChange;
            if (red < minRGB) {
                red = maxRGB;
            }
            if (green > maxRGB) {
                green = maxRGB;
            }
            if (blue > maxRGB) {
                blue = minRGB;
            }
        }
    }

    public static void main(String[] args) {
        int winWid = 900;
        int winHei = 700;
        JFrame myFrame = new JFrame("My Rotation Image");
        myFrame.setSize(winWid, winHei);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.add(new DrawingPanel());

        myFrame.setVisible(true);
    }
}
