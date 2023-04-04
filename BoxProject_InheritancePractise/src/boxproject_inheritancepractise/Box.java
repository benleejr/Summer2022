public class Box
{
    private int width;
    private int height;
    private int length;
    
    public Box(int wid, int hei, int len)
    {
        width = wid;
        height = hei;
        length = len;
        
    }
    
    public int calculateVolume()
    {
        return getWidth() * getHeight() * getLength();
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }
    
    public String toString()
    {
        return "Width: "+width+" Height: "+"Length: "+length;
    }
    
    public static void main(String[] args) {
    Box myBox = new Box(1,2,7);
        System.out.println("\n"+myBox.toString());
}
}