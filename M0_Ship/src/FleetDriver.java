import java.io.*;
import java.util.*;
import javax.swing.*;

public class FleetDriver {
    public static void main(String[] args) {
        ArrayList<Ship> fleet = new ArrayList<>();
        String fileName = "Tia_RosasFleet.csv";
        File inFile = new File(fileName);
        try
        {
            Scanner inScan = new Scanner(inFile).useDelimiter("[,\n]");
            while(inScan.hasNext())
            {
                String name = inScan.next();
                String flag = inScan.next();
                int year = inScan.nextInt();
                int length = inScan.nextInt();
                int beam = inScan.nextInt();
                int draft = inScan.nextInt();
                fleet.add(new Ship(name, flag, year, length, beam, draft));
            }
        }
        catch(IOException ioe)
        {
            String err_mess = "TROUBLE READING DATA FROM: "+fileName+"\n";
            System.err.print(err_mess);
            System.exit(0);
        }
        
        String fleetReport = "Tia Rosa's Yacht: \n\n";
        for(int dex = 0; dex < fleet.size(); dex++)
        {
            fleetReport += fleet.get(dex).toString()+"\n";
        }
        JOptionPane.showMessageDialog(null, fleetReport, "Tia Rosa's Fleet Roster ", 1);
        
        Ship maxShip = fleet.get(0);
        Ship minShip = fleet.get(0);
        Ship newestShip = fleet.get(0);
        Ship oldestShip = fleet.get(0);
        
        for(int dex = 1; dex < fleet.size(); dex++)
        {
            if(fleet.get(dex).estimateDisplacement() > maxShip.estimateDisplacement())
            {
                maxShip = fleet.get(dex);
            }
            if(fleet.get(dex).estimateDisplacement() < minShip.estimateDisplacement())
            {
            minShip = fleet.get(dex);    
            }
            if(fleet.get(dex).isOlder(oldestShip))
            {
                oldestShip = fleet.get(dex);
            }
            if(newestShip.isOlder(fleet.get(dex)))
            {
                newestShip = fleet.get(dex);
            }
        }
        String shipReport = "The ship with the largest displacement is \n\t"+maxShip+
                "\n\nThe ship with the lowest displacement is \n\t"+minShip+
                "\n\n\nThe oldest ship is \n\t"+oldestShip+"\n\nThe newest ship is\n\t"+
                newestShip;
        
        ImageIcon icon = new ImageIcon("Yacth2.png");
        JOptionPane.showMessageDialog(null,shipReport, "Tia Rosa's Fleet Roster ",
                1, icon);
        
    }
    
}
