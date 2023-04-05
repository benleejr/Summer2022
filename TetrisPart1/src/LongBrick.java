/* Subclass for the long brick 
 *
 */
/** I Shaped Brick
 *
 * @version 0.2
 * @author benedictlee 30 June 2022
 */

public class LongBrick extends TetrisBrick {

    public LongBrick() {
        colorNum = 6;
    }

    public void initPosition(int cenX) {
        position = new int[][]
        { {0, cenX - 2},
          {0, cenX - 1},
          {0, cenX},
          {0, cenX + 1}
        };        
    }
}
