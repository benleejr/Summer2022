/* Subclass containing J shaped brick
 * 
 */
/** J Shaped Brick
 *
 * @version 0.2
 * @author benedictlee 30 June 2022
 */

public class JayBrick extends TetrisBrick {

    public JayBrick() {
        colorNum = 1;
    }

    @Override
    public void initPosition(int cenX) {
        position = new int[][]
        { {0, cenX - 1},
          {0, cenX},
          {0, cenX + 1},
          {1, cenX + 1}
        };
    }
}
