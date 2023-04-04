
import java.math.*;
import java.util.*;
import java.io.*;

public class BigInteger_Exercise {

    public static void main(String[] args) {
        ArrayList<BigInteger> biggieList = new ArrayList<>();

        String fileName = "bigInts.txt";
        try {
            File inFile = new File(fileName);
            Scanner inScan = new Scanner(inFile);

            while (inScan.hasNext()) {
                biggieList.add(new BigInteger(inScan.next()));
            }
        } catch (IOException ioe) {
            System.err.println("Trouble with file: " + fileName);
            System.exit(0);
        }
        System.out.println("\n" + biggieList.size() + " elements in list");

        for (int dex = 0; dex < biggieList.size(); dex++) {
            System.out.print("\n" + biggieList.get(dex));
        }

        ArrayList<BigInteger> sortedList = new ArrayList<>();

        int size = biggieList.size();
        for (int cycle = 1; cycle < size; cycle++) {
            BigInteger maxElement = biggieList.get(0);
            int maxIndex = 0;
            int counter = 0;

            while (counter < biggieList.size()) {
                if (maxElement.compareTo(biggieList.get(counter)) < 0) {
                    maxElement = biggieList.get(counter);
                    maxIndex = counter;
                }
                counter++;
            }
            sortedList.add(biggieList.get(maxIndex));
            biggieList.remove(maxIndex);
        }

        sortedList.add(biggieList.get(0));
        biggieList.remove(0);

        System.out.println("\n\n");
        for (int cycle = 0; cycle < sortedList.size(); cycle++) {
            System.out.println(sortedList.get(cycle));
        }
        System.out.print("\n\n");

    }
}
