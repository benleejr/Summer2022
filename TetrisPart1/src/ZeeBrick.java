/* Subclass for the Z shaped brick 
 *
 */
/** Z shaped Brick
 *
 * @version 0.2
 * @author benedictlee 30 June 2022
 */

public class ZeeBrick extends TetrisBrick {

    public ZeeBrick() {
        colorNum = 3;
    }

    @Override
    public void initPosition(int cenX) {
        position = new int[][]
        { {0, cenX - 1},
          {0, cenX},
          {1, cenX},
          {1, cenX + 1}
        };        
    }
}
