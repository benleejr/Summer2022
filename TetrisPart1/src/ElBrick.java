/* Subclass for the L shaped brick 
 *
 */
/** L Shaped Brick
 *
 * @version 0.2
 * @author benedictlee 30 June 2022
 */

public class ElBrick extends TetrisBrick {

    public ElBrick() {
        colorNum = 0;

    }

    @Override
    public void initPosition(int cenX) {
        position = new int[][]
        { {1, cenX - 1},
          {0, cenX - 1},
          {0, cenX},
          {0, cenX + 1}
        };        
    }
}
