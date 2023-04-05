/* Subclass for superclass ship
 * Benedict Lee
 * 16 June 2022
 */

public class Yacht extends Ship {
    private int numStateRooms;
    private double poolSize;
    private int numDecks;
    private int power;
    
    public Yacht(int nsr, double pSiz, int numDec, int pow, String nam,  String nat,  
            int yer, int len, int dra, int bem)
    {
        super(nam,  nat,  yer, len, dra, bem);
        numStateRooms = nsr;
        poolSize = pSiz;
        numDecks = numDec;
        power = pow;
    }
    
    public String toString()
    {
        String yachtStatistics = super.toString()+", Number of State Rooms: "+getNumStateRooms()
                +", Pool Size: "+getPoolSize()+", Number of Decks: "+getNumDecks()
                +", Engine Displacement: "+ getPower();        
        return yachtStatistics;
    }

    /**
     * @return the numStateRooms
     */
    public int getNumStateRooms() {
        return numStateRooms;
    }

    /**
     * @return the poolSize
     */
    public double getPoolSize() {
        return poolSize;
    }

    /**
     * @return the numDecks
     */
    public int getNumDecks() {
        return numDecks;
    }

    /**
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(int power) {
        this.power = power;
    }
}
