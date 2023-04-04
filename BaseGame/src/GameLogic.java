/*
 *
 *
 */

/** Java Doc Tag
 *
 * @author benedictlee
 * @version
 */
import java.io.*;
import java.util.*;

public class GameLogic {

    private int[][] board;
    private int curRow;
    private int curCol;

    public GameLogic(int rows, int cols) {
        board = new int[rows][cols];
    }

    public String toString() {

        String stuff = "" + board.length + " " + board[0].length + "\n" + curRow
                + " " + curCol + "\n";
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                stuff += board[row][col] + " ";
            }
            stuff += "\n";
        }
        stuff = stuff.substring(0, stuff.length() - 1); //substring will extract everything

        return stuff;
    }

    public void saveToFile(String fName) {
        File fileConnection = new File(fName);
        if (fileConnection.exists() && !fileConnection.canWrite()) {
            System.err.print("Trouble Opening to write file " + fName);
            return;
        }
        try {
            FileWriter outWriter = new FileWriter(fileConnection);
            outWriter.write(this.toString());
            outWriter.close();
        } catch (IOException ioe) {

        }
    }

    public void initFromFile(String fName) {
        File fileConnection = new File(fName);
        try {
            Scanner inScann = new Scanner(fileConnection);
            int rows = inScann.nextInt();
            int cols = inScann.nextInt();
            board = new int[rows][cols];
            
            curRow = inScann.nextInt();
            curCol = inScann.nextInt();
            
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    board[row][col] = inScann.nextInt();
                }
            }
        } catch(FileNotFoundException fnfe) {
            System.err.print("Trouble opening file to read: "+fName);
            return;
        } catch (Exception e) {
            System.err.print("Error occurred during retrieve from file ");
        } 
    }

    public void makeMove(int row, int col) {
        board[row][col] = 1;
        curRow = row;
        curCol = col;
    }

    public void moveRight() {
        System.err.print("\nMove Left key clicked ");
        if (curCol + 1 < board[0].length) { //Check if move is valid
            curCol++;
            board[curRow][curCol] = 1;
        }
    }

    public void moveLeft() {
        System.err.print("\nMove Left key clicked ");
        if (curCol - 1 >= 0) {
            curCol--;
            board[curRow][curCol] = 1;
        }
    }

    public void moveUp() {
        System.err.print("\nMove Left key clicked ");
        if (curRow - 1 >= 0) {
            curRow--;
            board[curRow][curCol] = 1;
        }
    }

    public void moveDown() {
        System.err.print("\nMove Left key clicked ");
        if (curRow + 1 < board.length) {
            curRow++;
            board[curRow][curCol] = 1;
        }
    }

    public boolean checkForToken(int row, int col) {
        if (board[row][col] > 0) {
            return true;
        }
        return false;
    }

    public int fetchPosition(int row, int col) //ACCESSORS: Get returns the value of an attribute/Fetch does not return the value of an attribute but the attribute itself
    {
        return board.length;
    }

    public int fetchRows() {
        return board.length;
    }

    public int fetchCols() {
        return board[0].length;
    }

    public int getCurRow() {
        return curRow;
    }

    public int getCurCol() {
        return curCol;
    }

}
