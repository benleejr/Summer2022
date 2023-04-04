
import java.util.*;

public class AnimationGame {

    private int rows;
    private int cols;
    int[][] board;
    Random randGen;

    public AnimationGame(int rs, int cs) {
        rows = rs;
        cols = cs;
        board = new int[rows][cols];
        randGen = new Random();
        initBoard();
    }

    public void initBoard() {
        int initialBlocks = 20;
        for (int block = 0; block < initialBlocks; block++) {
            int row = randGen.nextInt(getRows());
            int col = randGen.nextInt(getCols());
            board[row][col] = 1;
        }
    }

    public void driftDown() {
        for (int row = rows - 2; row >= 0; row--) {
            for (int col = 0; col < cols; col++) {
                board[row + 1][col] = board[row][col];
            }
        }
        for (int col = 0; col < cols; col++) {
            board[0][col] = 0;
        }
    }

    public int getBoardPosition(int row, int col) {
        return board[row][col];
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
