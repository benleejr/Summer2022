/* Subclass for superclass ship
 * Benedict Lee
 * 16 June 2022
 */

public class CargoShip extends Ship{
    private int maxCargoTonnage;
    private int refrigeratorStorageSize;
    
    public CargoShip(int maxCargTon, int fridgeStoSize, String nam,  String nat,  
            int yer, int len, int dra, int bem)
    {
        super(nam,  nat,  yer, len, dra, bem);
        maxCargoTonnage = maxCargTon;
        refrigeratorStorageSize = fridgeStoSize;
        
    }
    
    public String toString()
    {
        String cargoShipDetails = super.toString()+", Max Cargo Tonnage: "+getMaxCargoTonnage()
                +", Refrigerator Storage Size: "+getRefrigeratorStorageSize();        
        return cargoShipDetails;
                
    }

    /**
     * @return the maxCargoTonnage
     */
    public int getMaxCargoTonnage() {
        return maxCargoTonnage;
    }

    /**
     * @return the refrigeratorStorageSize
     */
    public int getRefrigeratorStorageSize() {
        return refrigeratorStorageSize;
    }
}
