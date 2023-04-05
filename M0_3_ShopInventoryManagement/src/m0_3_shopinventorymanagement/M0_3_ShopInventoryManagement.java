import java.io.*;
import java.util.*;

public class M0_3_ShopInventoryManagement
{
    public static void main(String[] args) 
    {
        String fileName = "imaginary_inventory_1.csv";
        String reportFileName = "inventoryReport.txt";
        String orderFileName = "orders_1.csv";
        File inFile = new File (fileName);
        if(!inFile.exists())
        {
            String errorMessage = "CANNOT SEE THE FILE "+fileName;
            System.err.print(errorMessage);
            System.exit(0);
        }
        ArrayList<String> shops = new ArrayList<>();
        ArrayList<String> items = new ArrayList<>();
        
        //Read in data from file to arrayList
        try
        {
            Scanner inScan = new Scanner(inFile).useDelimiter("[,\n]");
            String firstLine = inScan.nextLine();
            Scanner lineScan = new Scanner(firstLine).useDelimiter(",");

            while(lineScan.hasNext())
            {
                shops.add(lineScan.next());
            }
            
            lineScan.close();
            
            while(inScan.hasNext())
            {
                items.add(inScan.nextLine());
            }
            
            inScan.close();
            
        } 
        catch(IOException ioe)
        {
            String err_mess = "ISSUE READING DATA";
            System.err.print(err_mess);
            System.exit(0);
        }                 
        int[][] inventory = new int [items.size()][shops.size()];
        
        for(int item = 0; item < items.size(); item++)
        {
            Scanner lineScan = new Scanner(items.remove(item)).useDelimiter(",");
            String itemName = lineScan.next();
            
            for(int shop = 0; shop <shops.size(); shop++)
                inventory[item][shop] = lineScan.nextInt();
            
            items.add(item, itemName);
        }
        
        String reportText = "Initial Inventory\n";
        reportText+=formArrayDisplay(inventory,shops,items);
        System.out.print(reportText);
        writeToFile(reportText, reportFileName, false);
        processOrders(inventory, shops, items, orderFileName);
        
        reportText = "\n\nUpdated inventory\n";
        reportText += formArrayDisplay(inventory, shops, items);
        System.out.println(reportText);
        
        writeToFile(reportText, reportFileName, true);
                
    }
    
        
    public static void writeToFile(String text, String fileName, boolean append)
    {
        File outFile = new File(fileName);
        if(outFile.exists() && !outFile.canWrite())
        {
            String err_mess = "CANNOT WRITE";
            System.err.print(err_mess);
            System.exit(0);
        }
        
        try
        {
            FileWriter outWriter = new FileWriter(outFile,append);
            outWriter.write(text);
            outWriter.close();
        }
        catch(IOException ioe)
        {
            String err_mess = "CANNOT WRITE TO FILE";
            System.err.print(err_mess);
            System.exit(0);
        }
        
    }
    
    public static void processOrders(int[][] mainArray, ArrayList<String>
            columnHeader, ArrayList<String> rowHeader, String fileName)
    {
        File inFile = new File(fileName);
        if(!inFile.exists())
        {
            String err_mess = "FILE"+fileName+"DOES NOT EXIST";
            System.err.print(err_mess);
            System.exit(0);
        }
        
        try
        {
            Scanner fileScan = new Scanner(inFile).useDelimiter("[,\n]");
            
            while(fileScan.hasNext())
            {
                String item = fileScan.next();
                String shop = fileScan.next();
                int amount = fileScan.nextInt();
                                
                int rowDex = rowHeader.indexOf(item);
                int colDex = columnHeader.indexOf(shop);
                mainArray[ rowDex ][ colDex] -= amount;
            }
            fileScan.close();
        }
        catch(IOException ioe)
        {
            String err_mess = "CANNOT READ"+fileName;
            System.err.print(err_mess);
            System.exit(0);
        }
    }
    
    public static String formArrayDisplay(int[][] mainArray,ArrayList<String> 
            columnHeader, ArrayList<String> rowHeader)
    {
        String report = "           ";
        
        for(int col = 0; col< columnHeader.size(); col++)
        {
            report += String.format("%-10s", columnHeader.get(col));
        }
        report += "\n";
        
        for(int row = 0; row < rowHeader.size(); row++)
        {
            report += String.format("%8s", rowHeader.get(row));
            for(int col = 0; col < columnHeader.size(); col++)
            {
                report += String.format("%10d",mainArray[row][col]);
            }
            report+="\n";
        }
        return report;
    }
}
        



