/* Subclass for superclass ship
 * Benedict Lee
 * 16 June 2022
 */

public class CruiseShip extends Ship {
    private int numberOfExecStateRooms;
    private int numberOfDoubleBunkRooms;
    private int numberOfQuadBunkRooms;
    
    public CruiseShip (int numExecStRm, int numDblBunkRm, int numQuadBunkRm, String nam,  String nat,  
            int yer, int len, int dra, int bem)
    {
        super(nam,  nat,  yer, len, dra, bem);
        numberOfExecStateRooms = numExecStRm;
        numberOfDoubleBunkRooms = numDblBunkRm;
        numberOfQuadBunkRooms = numQuadBunkRm;        
    }
    
    public String toString()
    {
        String cruiseShipDetails = super.toString()+", Executive State Rooms: "+
                getNumberOfExecStateRooms()+", Double Bunk Rooms: "+getNumberOfDoubleBunkRooms()
                +", Quad Bunk Rooms: "+getNumberOfQuadBunkRooms();        
        return cruiseShipDetails;
    }

    /**
     * @return the numberOfExecStateRooms
     */
    public int getNumberOfExecStateRooms() {
        return numberOfExecStateRooms;
    }

    /**
     * @return the numberOfDoubleBunkRooms
     */
    public int getNumberOfDoubleBunkRooms() {
        return numberOfDoubleBunkRooms;
    }

    /**
     * @return the numberOfQuadBunkRooms
     */
    public int getNumberOfQuadBunkRooms() {
        return numberOfQuadBunkRooms;
    }
    
    
}
