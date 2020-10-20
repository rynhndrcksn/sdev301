package telemetry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Telemetry {

    private static final int NUM_BITS = 8;

    public static void main(String[] args) {

        // what is my working directory?  (Where will my IDE look for files to open by default?)
        System.out.println(System.getProperty("user.dir"));

        // open the switches.txt file
        try (Scanner fileIn = new Scanner(new File("data/switches.txt"))){
            while (fileIn.hasNextInt()) {
                int num = fileIn.nextInt();
                printStatus(num, NUM_BITS);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * This method prints out the status of the first numBits of an
     * integer where a bit set to 1 is considered "on" and a bit set to
     * "0" is considered off.  Using a mask and a bitwise AND & the status of the
     * switches are printed to the console
     *
     * @param num  - switch status
     * @param numBits - number of bits to check in the switch status
     */
    public static void printStatus(int num, int numBits){
        System.out.println("Switch status for data value "+num);
        // TODO: add your code here
        // need a loop to look at each bit
        for (int i = 0; i < numBits; i++) {
            // create a mask
            int mask = 1 << i;
            // if our num & mask result is = 0 we assign "is off" to status, else "is on" is assigned
            // ternary operator | if ?then :else
            String status = (num & mask) == 0 ? "is off" : "is on";
            System.out.println("Switch #" + (i+1) + " " + status);
        }

        System.out.println();
    }
}
