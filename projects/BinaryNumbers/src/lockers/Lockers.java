package lockers;

import bitarray.BitArray;

/**
 * Lockers class works with BitArray to help solve the "locker problem" so we make a BitArray of 50 lockers, and have
 * 50 students walk past them. As each student walks by, they open or close the locker that matches their multiple.
 * 1st opens all, 2nd then closes all multiples of 2, 3rd inverts multiples of 3, etc.
 * @author Ryan Hendrickson
 * @version 1.0
 */
public class Lockers {
    private static final int LOCKERS = 50;
    public static void main(String[] args) {
        BitArray lockers = new BitArray();


        printLockers(lockers);
    }

    /**
     * method that just helps us print the status of the lockers
     * @param lockers is a BitArray that gets iterated through and the state of each bit is printed
     */
    public static void printLockers(BitArray lockers) {
        for (int i = 0; i < LOCKERS; i++) {
            System.out.println((i+1) + ": " + lockers.get(i));
        }
    }
}
