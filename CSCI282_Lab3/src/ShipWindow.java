/* This program allows the user to view the data of a specific ship.
 * Benedict Lee
 * 22 June 2022
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class ShipWindow extends JFrame {

    final private int win_wid = 650;
    final private int win_hei = 240;
    private int gridRows = 3;
    private int gridColumns = 2;
    private int largeFontSize = 30;
    private int mediumFontSize = 14;
    private String font = "Arial";

    ArrayList<Ship> fleet = new ArrayList<>();

    JTextField nameField, nationField, yearField, lenField, drafField, beamField;

    JComboBox selectShipBox;

    public ShipWindow() throws Exception {
        String title = "Ship Information        Benedict Lee";
        String fleetFileName = "Tia_RosasFleet.csv";
        this.setTitle(title);
        this.setSize(win_wid, win_hei);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InitializeShips(fleetFileName);
        InitInfoPanel();
        InitSelectPanel();
        InitButtonPanel();

        this.setVisible(true);
    }

    public void InitializeShips(String fileName) {
        File inFile = new File(fileName);
        if (inFile.exists() == false) { 
            System.err.print("Cannot read file!");
        } 
        try {
            Scanner inScan = new Scanner(inFile).useDelimiter("[,\n]");

            while (inScan.hasNext()) {
                String name = inScan.next();
                String nation = inScan.next();
                int year = inScan.nextInt();
                int length = inScan.nextInt();
                int draft = inScan.nextInt();
                int beam = inScan.nextInt();
                fleet.add(new Ship(name, nation, year, length, draft, beam));

            }
        } catch (FileNotFoundException fnfe) {

        }

    }

    public void InitSelectPanel() {
        int fontType = 1;
        String label = "Select a Ship";
        Font bigFont = new Font(font, fontType, largeFontSize);
        JLabel lab = new JLabel(label);
        lab.setFont(bigFont);

        itemStateChanged();

        String yachtIcon = "Yacht_big.png";
        ImageIcon icon = new ImageIcon(yachtIcon);
        int scaleX = 164, scaleY = 82;

        JLabel iconLab = new JLabel() {
            public void paintComponent(Graphics g) {
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, scaleX, scaleY, this);
            }
        };

        iconLab.setPreferredSize(new Dimension(scaleX, scaleY));
        iconLab.setIcon(icon);

        JPanel northPan = new JPanel();
        northPan.add(iconLab);
        northPan.add(lab);
        northPan.add(selectShipBox);
        this.add(northPan, BorderLayout.NORTH);
    }

    private void itemStateChanged() {
        String[] shipNames = new String[fleet.size()];
        selectShipBox = new JComboBox();
        selectShipBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //selectShipBox = (JComboBox) e.getSource();
                Object name = selectShipBox.getSelectedItem();

                for (int fleetIndex = 0; fleetIndex < fleet.size(); fleetIndex++) {
                    if (fleet.get(fleetIndex).getName().equals(name)) {
                        nameField.setText(fleet.get(fleetIndex).getName());
                        nationField.setText(fleet.get(fleetIndex).getNation());
                        yearField.setText(Integer.toString(fleet.get(fleetIndex).getYearBuilt()));
                        lenField.setText(Integer.toString(fleet.get(fleetIndex).getLength()));
                        drafField.setText(Integer.toString(fleet.get(fleetIndex).getDraft()));
                        beamField.setText(Integer.toString(fleet.get(fleetIndex).getBeam()));
                        break;
                    }
                }
            }
        });
        for (int nameIndex = 0; nameIndex < fleet.size(); nameIndex++) {
            shipNames[nameIndex] = fleet.get(nameIndex).getName();
        }
        selectShipBox.setModel(new javax.swing.DefaultComboBoxModel<>(shipNames));
    }

    public void InitInfoPanel() {
        JPanel centerPanel = new JPanel(new GridLayout(gridRows, gridColumns));

        String name = "Ship Name: ";
        String country = "Country of Registration: ";
        String year = "Year of Construction: ";
        String length = "Length at Waterline: ";
        String draft = "Draft at Waterline: ";
        String beam = "Beam at Waterline: ";

        JLabel shipName = new JLabel(name);
        JLabel countryRegistered = new JLabel(country);
        JLabel yearConstructed = new JLabel(year);
        JLabel waterLineLength = new JLabel(length);
        JLabel waterLineDraft = new JLabel(draft);
        JLabel waterLineBeam = new JLabel(beam);

        nameField = new JTextField();
        nationField = new JTextField();
        yearField = new JTextField();
        lenField = new JTextField();
        drafField = new JTextField();
        beamField = new JTextField();

        centerPanel.add(shipName);
        centerPanel.add(nameField);
        centerPanel.add(countryRegistered);
        centerPanel.add(nationField);
        centerPanel.add(yearConstructed);
        centerPanel.add(yearField);
        centerPanel.add(waterLineLength);
        centerPanel.add(lenField);
        centerPanel.add(waterLineDraft);
        centerPanel.add(drafField);
        centerPanel.add(waterLineBeam);
        centerPanel.add(beamField);

        int fontType = 0;
        Font mediumFont = new Font(font, fontType, mediumFontSize);
        shipName.setFont(mediumFont);
        countryRegistered.setFont(mediumFont);
        yearConstructed.setFont(mediumFont);
        waterLineLength.setFont(mediumFont);
        waterLineDraft.setFont(mediumFont);
        waterLineBeam.setFont(mediumFont);

        shipName.setHorizontalAlignment(JLabel.RIGHT);
        countryRegistered.setHorizontalAlignment(JLabel.RIGHT);
        yearConstructed.setHorizontalAlignment(JLabel.RIGHT);
        waterLineLength.setHorizontalAlignment(JLabel.RIGHT);
        waterLineDraft.setHorizontalAlignment(JLabel.RIGHT);
        waterLineBeam.setHorizontalAlignment(JLabel.RIGHT);

        nameField.setHorizontalAlignment(JTextField.CENTER);
        nationField.setHorizontalAlignment(JTextField.CENTER);
        yearField.setHorizontalAlignment(JTextField.CENTER);
        lenField.setHorizontalAlignment(JTextField.CENTER);
        drafField.setHorizontalAlignment(JTextField.CENTER);
        beamField.setHorizontalAlignment(JTextField.CENTER);

        this.add(centerPanel, BorderLayout.CENTER);
    }

    public void InitButtonPanel() {
        JPanel southPanel = new JPanel();
        southPanel.add(addShipButton());
        southPanel.add(clearButton());
        southPanel.add(quitButton());
        this.add(southPanel, BorderLayout.SOUTH);

    }

    private JButton addShipButton() {
        String fileName = "Tia_RosasFleet.csv";
        String addShip = "Add Ship";        
        JButton addShipButton = new JButton(addShip);
        addShipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String nation = nationField.getText();
                String year = yearField.getText();
                String length = lenField.getText();
                String draft = drafField.getText();
                String beam = beamField.getText();

                String toString = "\n" + name + "," + nation + "," + year + "," + length
                        + "," + draft + "," + beam;

                saveToFile(fileName, toString);

                fleet.add(new Ship(name, nation, Integer.valueOf(year), Integer.valueOf(length),
                        Integer.valueOf(draft), Integer.valueOf(beam)));

                selectShipBox.addItem(name);
                selectShipBox.revalidate();
            }
        });
        return addShipButton;
    }

    public void saveToFile(String fName, String toString) {
        File fileConnection = new File(fName);
        try {
            FileWriter outWriter = new FileWriter(fileConnection, true);
            outWriter.write(toString);
            outWriter.close();
        } catch (IOException ioe) {

        }
    }

    private JButton clearButton() {
        String clear = "Clear";
        JButton clearButton = new JButton(clear);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emptyField = "";
                nameField.setText(emptyField);
                nationField.setText(emptyField);
                yearField.setText(emptyField);
                lenField.setText(emptyField);
                drafField.setText(emptyField);
                beamField.setText(emptyField);
            }
        });
        return clearButton;
    }

    private JButton quitButton() {
        String quit = "Quit";
        JButton quitButton = new JButton(quit);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return quitButton;
    }

    public static void main(String[] args) throws Exception {
        ShipWindow aw = new ShipWindow();
    }
}
