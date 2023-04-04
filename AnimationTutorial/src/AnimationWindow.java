
import javax.swing.*;

public class AnimationWindow extends JFrame {

    private int winWid = 200;
    private int winHei = 400;
    private int rows = 30;
    private int cols = 10;

    private AnimationDisplay display;
    private AnimationGame game;

    public AnimationWindow() {
        this.setTitle("My Animation Project");
        this.setSize(winWid, winHei);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game = new AnimationGame(rows, cols);
        display = new AnimationDisplay(game);
        this.add(display);

        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        AnimationWindow myWindow = new AnimationWindow();
    }
}
