/* Driver class that will display a list of all ships in the fleet in JOptionPane.
 * User can select from the three ship designations to view specific details of
 * the ships in each designation.
 * Benedict Lee
 * 16 June 2022
 */
import java.util.*;
import java.io.*;
import javax.swing.*;
public class FlotillaDriver {
    public static void main(String[] args) throws Exception {
        String flotillaFileName = "flotilla_data.csv";
        File inFile = new File(flotillaFileName);
        ArrayList<Ship> ShipList = new ArrayList<>();
        ArrayList introList = new ArrayList<>();
        ArrayList<Yacht> yachtList = new ArrayList<>();
        ArrayList<CruiseShip> cruiseShipList = new ArrayList<>();
        ArrayList<CargoShip> cargoShipList = new ArrayList<>();
        String cargoShipAbb = "CG";
        String yachtAbb = "YT";
        String cruiseShipAbb = "CR";

        Scanner inScan = new Scanner(inFile).useDelimiter("[,\n]");

        while (inScan.hasNext()) {
            if (inScan.hasNext(cargoShipAbb)) {
                String abbreviation = inScan.next();
                String name = inScan.next();
                int year = inScan.nextInt();
                String nation = inScan.next();
                int length = inScan.nextInt();
                int draft = inScan.nextInt();
                int beam = inScan.nextInt();
                int tonnage = inScan.nextInt();
                int fridgeSize = inScan.nextInt();
                ShipList.add(new CargoShip(tonnage, fridgeSize, name, nation,
                        year, length, draft, beam));
                cargoShipList.add(new CargoShip(tonnage, fridgeSize, name, nation,
                        year, length, draft, beam));
                introList.add("\t\t\t" + name + ", " + year + ", " + nation);

            }
            if (inScan.hasNext(yachtAbb)) {
                String abbreviation = inScan.next();
                String name = inScan.next();
                int year = inScan.nextInt();
                String nation = inScan.next();
                int length = inScan.nextInt();
                int draft = inScan.nextInt();
                int beam = inScan.nextInt();
                int stateRooms = inScan.nextInt();
                double poolSize = inScan.nextInt();
                int numDecks = inScan.nextInt();
                int power = inScan.nextInt();
                ShipList.add(new Yacht(stateRooms, poolSize, numDecks, power,
                        name, nation, year, length, draft, beam));
                yachtList.add(new Yacht(stateRooms, poolSize, numDecks, power,
                        name, nation, year, length, draft, beam));
                introList.add("\t\t\t" + name + ", " + year + ", " + nation);
            }
            if (inScan.hasNext(cruiseShipAbb)) {
                String abbreviation = inScan.next();
                String name = inScan.next();
                int year = inScan.nextInt();
                String nation = inScan.next();
                int length = inScan.nextInt();
                int draft = inScan.nextInt();
                int beam = inScan.nextInt();
                int execStateRms = inScan.nextInt();
                int dblBunkRms = inScan.nextInt();
                int quadBunkRms = inScan.nextInt();
                ShipList.add(new CruiseShip(execStateRms, dblBunkRms, quadBunkRms,
                        name, nation, year, length, draft, beam));
                cruiseShipList.add(new CruiseShip(execStateRms, dblBunkRms,
                        quadBunkRms, name, nation, year, length, draft, beam));
                introList.add("\t\t\t" + name + ", " + year + ", " + nation);
            }
        }

        String fleetReport = "All Ships:\n\n";
        for (int dex = 0; dex < introList.size(); dex++) {
            fleetReport += introList.get(dex).toString() + "\n";
        }

        String iconFolder = "icon/";
        String[] images = {"select.png", "yacht.png", "CargoShip.png", "CruiseShip.png"};
        ImageIcon selectionIcon = new ImageIcon(iconFolder + images[0]);
        ImageIcon yachtIcon = new ImageIcon(iconFolder + images[1]);
        ImageIcon cargoShipIcon = new ImageIcon(iconFolder + images[2]);
        ImageIcon cruiseShipIcon = new ImageIcon(iconFolder + images[3]);

        String[] options = {"Quit", "Yachts", "Cargo Ships", "Cruise Ships"};
        int viewShipList = 1;
        String yachtReport = "";
        String cargoShipReport = "";
        String cruiseShipReport = "";

        String introduction = "<html>This program will display ships currently in the "
                + "fleet.<br>Ship information as well as class specific information<br>"
                + " can be displayed by clicking on the buttons labelled by ship"
                + " class.<br><br>To exit the program: click on button labelled \"Quit\" "
                + "while in the main popup.";
        JOptionPane.showMessageDialog(null, introduction, "Welcome!", 0);

        while (viewShipList != 0) {
            viewShipList = JOptionPane.showOptionDialog(null, fleetReport,
                    "Benedict's Fleet", 0, 0, selectionIcon, options, options[0]);
            if (viewShipList == 1) {
                for (int dex = 0; dex < yachtList.size(); dex++) {
                    yachtReport += yachtList.get(dex).toString() + "\n";
                }
                JOptionPane.showMessageDialog(null, yachtReport, "All Yachts - Benedict Lee",
                        0, yachtIcon);
            }
            if (viewShipList == 2) {
                for (int dex = 0; dex < cargoShipList.size(); dex++) {
                    cargoShipReport += cargoShipList.get(dex).toString() + "\n";
                }
                JOptionPane.showMessageDialog(null, cargoShipReport, "All Cargo Ships - Benedict Lee",
                        0, cargoShipIcon);
            }
            if (viewShipList == 3) {
                for (int dex = 0; dex < cruiseShipList.size(); dex++) {
                    cruiseShipReport += cruiseShipList.get(dex).toString() + "\n";
                }
                JOptionPane.showMessageDialog(null, cruiseShipReport, "All Cargo Ships - Benedict Lee",
                        0, cruiseShipIcon);
            }
            if (viewShipList == 0) {
                JOptionPane.showMessageDialog(null, "This Program Will Now Exit",
                        "GOODBYE!", 0);
                break;
            }
        }

    }
}