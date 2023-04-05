/* Contains all logic for directing the game
 * Responds to all moves communicated by TetrisDisplay class as valid or invalid
 * End-game detection
*/
/** Tetris Logic Control
 * @author benedictlee
 * @version 1.00
 * 27 June 2022
 */
import java.util.Random;

public class TetrisGame {

    private TetrisBrick fallingBrick;
    private int rows;
    private int cols;
    private int numBrickTypes;
    private Random randomGen;

    public TetrisGame(int rw, int col) {
        rows = rw;
        cols = col;
    }

    private void spawnBrick() {

    }

    public void makeMove() {

    }

    private void validateMove() {

    }

    public int getNumSegs() {
        return fallingBrick.numSegments;
    }

    public int[][] getSegRow() {
        return fallingBrick.position;
    }

    public int[][]getSegCol() {
        return fallingBrick.position; 
   }

    public int getFallingBrickColor() {
        return fallingBrick.colorNum;
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return the cols
     */
    public int getCols() {
        return cols;
    }
}
