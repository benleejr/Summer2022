import javax.swing.*;

public class Carton extends Box 
{
    private String material;
    private double weightCap;
    
    public Carton (int len, int wid, int hei, String mat, double den)
    {        
        super(len,wid,hei);
        material = mat;
        weightCap = den;        
    }
    
    public String toString()
    {
        String stuff = super.toString()+" mat:"+getMaterial()+" weight cap: ";
        return stuff;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * @return the weightCap
     */
    public double getWeightCap() {
        return weightCap;
    }

    /**
     * @param weightCap the weightCap to set
     */
    public void setWeightCap(double weightCap) {
        this.weightCap = weightCap;
    }
    
    public static void main(String[] args) {
        Carton myCar1 = new Carton(1,2,3,"wood",3.4);
        Carton myCar2 = new Carton(4,5,6,"Cardboard",1.2);
        Carton myCar3 = new Carton(7,8,9,"High Den.Plas.",1.2);
        
        String stuff = ""+myCar1+"\n"+myCar2+"\n"+myCar3;
        
        JOptionPane.showMessageDialog(null,stuff,"Carton Test", 1);
                
    }
}

    
