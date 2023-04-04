/*
 * Demo code referenced in lecture M0_2A
 * C. Anderson
 * 5/11/2022
 */

public class Max_min_patterns 
{
    public static void main(String[] args) 
    {
        String[] storeNames = {"DalMart", "Marget", "Souls", "Super Paver", "Market Casket"};
        double[] rates      = {     0.33,     0.45,    0.19,          0.24,    0.09};
        int[] daysOfSale    = {        3,        2,       1,             7,      4};
        
        ////////////////////////
        // direct code
        ////////////////////////
        // What is the name of the store that has the deepest discount?
        ////////////////////////
        //1. Find index of best/deepest discount
        //2. Display store name with this deepest discount
        
        double maxRate = 0.0;
        int maxIndex = 0;
        
        for(int dex = 0; dex < rates.length; dex++)
        {
            if(maxRate < rates[dex])
            {
                maxRate = rates[dex];
                maxIndex = dex;
            }
        }
        
        String result = "The store '"+storeNames[maxIndex]+ 
                        "' has the deepest discount of "+maxRate+"%";
        System.out.print(result+"\n\n");
        
        ////////////////////////
        // using static method
        ////////////////////////
        // What is the discount for the store with the shortest sale?
        ////////////////////////
        //1. find index of shortest sale
        //2. Display store name of shortest index
        
        int shortestSaleIndex = findIndexMinValue(daysOfSale);
        String result2 = "The discount of '"+rates[shortestSaleIndex]+ 
                         "' is given at the shortest sale which is "+
                          daysOfSale[shortestSaleIndex]+" days";
        System.out.print(result2+"\n\n\n");
        
    }
    
    public static int findIndexMinValue(int[] array)
    {
        int minVal = array[0];
        int minIndex = 0;
        for(int dex = 0; dex < array.length; dex++)
        {
            if(minVal > array[dex])
            {
                minVal = array[dex];
                minIndex = dex;
            }
        }
        return minIndex;
    }
}
