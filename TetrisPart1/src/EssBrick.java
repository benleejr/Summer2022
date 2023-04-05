/* Subclass for the S shaped brick 
 *
 */
/** S Shaped Brick
 *
 * @version 0.2
 * @author benedictlee 30 June 2022
 */

public class EssBrick extends TetrisBrick {

    public EssBrick() {
        colorNum = 2;
    }

    @Override
    public void initPosition(int cenX) {
        position = new int[][] 
        { {1,cenX - 1},
          {1, cenX},
          {0, cenX},
          {0, cenX + 1}
        };
    }
}
