/*
    Class containing  the star for discrete rotation and also movement up and
    down when clicking on the upper or lower part of the window respectively.

    Benedict Lee
    
    Last Edit: 1 July 2022
 */

public class Star {

    private int[][] segPosition;             // grid location of each segment relative to center
    private int[] segColor = {3, 0, 2, 2, 1, 1};  // color of each segment

    private int numSegs = 6;                  // number of segments
    private int orient = 0;

    public Star(int row, int col) {
        segPosition = new int[numSegs][2];
        initPos(row, col);
    }

    public void initPos(int cent_row, int cent_col) {
        segPosition = new int[][]{{cent_col - 1, cent_row - 1},
        {cent_col, cent_row},
        {cent_col - 1, cent_row + 1},
        {cent_col + 1, cent_row + 1},
        {cent_col + 1, cent_row - 1},
        {cent_col + 2, cent_row - 2}};
    }

    public void rotate() {
        int cent_col = segPosition[1][0];
        int cent_row = segPosition[1][1];
        switch (orient) {
            case 0:
                segPosition = new int[][]{{cent_col - 1, cent_row - 1},
                {cent_col, cent_row},
                {cent_col - 1, cent_row + 1},
                {cent_col + 1, cent_row + 1},
                {cent_col + 1, cent_row - 1},
                {cent_col + 2, cent_row - 2}};
                break;
            case 1:
                segPosition = new int[][]{{cent_col + 1, cent_row - 1},
                {cent_col, cent_row},
                {cent_col - 1, cent_row - 1},
                {cent_col - 1, cent_row + 1},
                {cent_col + 1, cent_row + 1},
                {cent_col + 2, cent_row + 2}};
                break;
            case 2:
                segPosition = new int[][]{{cent_col + 1, cent_row + 1},
                {cent_col, cent_row},
                {cent_col + 1, cent_row - 1},
                {cent_col - 1, cent_row - 1},
                {cent_col - 1, cent_row + 1},
                {cent_col - 2, cent_row + 2}};
                break;
            case 3:
                segPosition = new int[][]{{cent_col - 1, cent_row + 1},
                {cent_col, cent_row},
                {cent_col + 1, cent_row + 1},
                {cent_col + 1, cent_row - 1},
                {cent_col - 1, cent_row - 1},
                {cent_col - 2, cent_row - 2}};
                break;
        }

    }

    public void shiftUp() {
        for (int seg = 0; seg < numSegs; seg++) {
            int rowPos = segPosition[seg][1];
            segPosition[seg][1] = rowPos - 1;

        }

    }

    public void shiftDown() {
        for (int seg = 0; seg < numSegs; seg++) {
            int rowPos = segPosition[seg][1];
            segPosition[seg][1] = rowPos + 1;
        }
    }

    public int starColor(int segNum) {
        return segColor[segNum];
    }

    public int starRow(int segNum) {
        return segPosition[segNum][1];
    }

    public int starCol(int segNum) {
        return segPosition[segNum][0];
    }

    public int getNumSegs() {
        return numSegs;
    }

    public int setOrient(int orientation) {
        orient = orientation;
        return orient;
    }

    public int getOrient() {
        return orient;
    }
}
