/* Subclass for the square shaped brick 
 *
 */
/** Square Shaped Brick
 *
 * @version 0.2
 * @author benedictlee 30 June 2022
 */

public class SquareBrick extends TetrisBrick {

    public SquareBrick() {
        colorNum = 4;
    }

    @Override
    public void initPosition(int cenX) {
        position = new int[][]
        { {0, cenX - 1},
          {1, cenX - 1},
          {0, cenX},
          {1, cenX}
        };        
    }
}
