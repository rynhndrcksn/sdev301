package converter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TwosComplementConverter {

    public static final byte NUM_BITS = 8;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        byte num = 0;
        boolean good = false;
        
        do {
            System.out.print("Enter a decimal number in the range: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE + ": ");
            try {
                num = kb.nextByte();
                good = true;
            } catch (InputMismatchException e){
                System.out.println("You did not enter a value in range, Try Again ");
                kb.nextLine(); // clear buffer
                good = false;
            }
        } while (num < Byte.MIN_VALUE || num > Byte.MAX_VALUE || !good);

        System.out.println(createBinaryString(num,NUM_BITS));



    }

    // this helper method adds leading 0's to the BinaryString so the BinaryString always has NUM_BITS bits
    private static String createBinaryString(byte num, byte numBits){

        // this method does not return leading 0's to we must add them
        String result = Integer.toBinaryString(Byte.toUnsignedInt(num));

        // so we must add them, create empty zeros string
        String zeros = "";

        // pad leading zeros onto binary string, if result string length is < 32
        for (int i=0; i< numBits - result.length(); i++){
            zeros += "0";
        }
        return zeros + result;
    }

}
