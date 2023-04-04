/*
    Class containing window to frame the the display of the star and the board from the
       the discrete rotation tutorial
    
    Benedict Lee
    
    Last Edit: 1 July 2022
*/

import javax.swing.*;

public class DiscreteRotationWindow extends JFrame{
    
    private int winWid = 500;
    private int winHei = 500;

    private int row = 4;
    private int col = 5;
    
    private DiscreteRotationDisplay display;
    private DiscreteRotationLogic game;
    
    public DiscreteRotationWindow() 
    {
        this.setTitle("Discrete 90 degree rotation Lab ");
        this.setSize(winWid,winHei);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        game = new DiscreteRotationLogic(row,col);
   	    display = new DiscreteRotationDisplay(game);

        this.add(display);        
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        DiscreteRotationWindow myWin = new DiscreteRotationWindow();
    }
}

