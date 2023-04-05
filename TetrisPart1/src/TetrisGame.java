/* Contains all logic for directing the game
 * Responds to all moves communicated by TetrisDisplay class as valid or invalid
 * End-game detection
 */
/** Tetris Logic Control
 *
 * @author benedictlee
 * @version 0.2 Last Edit: 1 July 2022
 */
import java.util.Random;

public class TetrisGame {

    private TetrisBrick fallingBrick;
    private int rows;
    private int cols;
    private int numBrickTypes = 7;
    private Random randomGen;

    public TetrisGame(int rw, int col) {
        rows = rw;
        cols = col;
        randomGen = new Random();
        spawnBrick();
    }

    private void spawnBrick() {        
        int cenX = cols/2;
        int index = randomGen.nextInt(numBrickTypes);
        switch (index) {
            case 0:
                fallingBrick = new ElBrick();                  
                fallingBrick.initPosition(cenX);
                break;
            case 1:
                fallingBrick = new JayBrick();         
                fallingBrick.initPosition(cenX);
                break;
            case 2:
                fallingBrick = new EssBrick();    
                fallingBrick.initPosition(cenX);
                break;
            case 3:
                fallingBrick = new ZeeBrick();     
                fallingBrick.initPosition(cenX);
                break;
            case 4:
                fallingBrick = new SquareBrick();   
                fallingBrick.initPosition(cenX);
                break;
            case 5:
                fallingBrick = new StackBrick();
                fallingBrick.initPosition(cenX);
                break;
            case 6:
                fallingBrick = new LongBrick(); 
                fallingBrick.initPosition(cenX);
                break;
        }
    }

    public void makeMove() {
        fallingBrick.moveDown();
        if (validateMove() == 0) {
            fallingBrick.moveUp();
            spawnBrick();        
        }
    }

    private int validateMove() {
        int row;        
        int col = 0;
        for (int segment = 0; segment < fallingBrick.numSegments; segment++) {
            row = fallingBrick.position[segment][col];
            if (row == rows) {
                return 0;
            }
        }
        return 1;     
    }
   
    public int getNumSegs() {
        return fallingBrick.numSegments;
    }

    public int getSegRow(int segNum) {
        return fallingBrick.position[segNum][0];
    }

    public int getSegCol(int segNum) {
        return fallingBrick.position[segNum][1];
    }

    public int getFallingBrickColor() {
        int fallingBrickColor = fallingBrick.getColorNumber();
        return fallingBrickColor;
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
