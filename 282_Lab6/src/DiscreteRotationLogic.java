/*
    Class containing the control and attribute of the star and the board from 
       the discrete rotation tutorial
    
    Benedict Lee

    Last Edit: 1 July 2022
 */

public class DiscreteRotationLogic {

    private Star star;    

    public DiscreteRotationLogic(int row, int col) {
        star = new Star(row, col);
    }

    public void makeMove(String code) {        
        switch (code) {
            case "R":                
                int orient = star.getOrient();
                if(orient == 3) {
                    orient = -1;
                }
                star.rotate();  
                orient++;
                star.setOrient(orient);                
                break;
            case "U":
                star.shiftUp();
                break;
            case "D":
                star.shiftDown();
                break;
        }
        
        
    }              
          
    public int getStarRow(int segNum) {
        return star.starRow(segNum);
    }

    public int getStarColor(int segNum) {
        return star.starColor(segNum);
    }

    public int getStarCol(int segNum) {
        return star.starCol(segNum);
    }

    public int getNumSegs() {
        return star.getNumSegs();
    }

}
