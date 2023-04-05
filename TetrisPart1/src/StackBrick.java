/* Subclass for the T shaped brick 
 *
 */
/** T Shaped Brick
 *
 * @version 0.2
 * @author benedictlee 30 June 2022
 */

public class StackBrick extends TetrisBrick {

    public StackBrick() {
        colorNum = 5;
    }
//

    public void initPosition(int cenX) {
        position = new int[][]
        { {1, cenX - 1},
          {1, cenX},
          {0, cenX},
          {1, cenX + 1}
        };        
    }
}
