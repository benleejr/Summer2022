/* Superclass that contains all attributes and methods that the seven brick 
 * types have in common. 
 */
/**
 * Abstract Class containing all bricks in Tetris game
 * @author benedictlee
 * @version 1.00
 * 27 June 2022
 */
public abstract class TetrisBrick {

    protected int[][] position;
    protected int numSegments;
    protected int colorNum;

    public TetrisBrick() {
        position = new int[numSegments][2];
        
    }

    public void moveDown() {

    }

    public void moveUp() {

    }

    public int getColorNumber() {
        return colorNum;
    }

    public void initPosition() {

    }

}












