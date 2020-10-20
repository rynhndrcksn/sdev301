package bitset;

import java.util.BitSet;

public class BitSetLockers {
    public static final int LOCKERS = 50;

    public static void main(String[] args) {
        BitSet lockers = new BitSet(LOCKERS);


        // TODO: rework the Lockers problem to use the built in Java BitSet class rather the BitArray class
        // iterate through and start opening/closing them in multiples
        int count = 0;
        while(count < LOCKERS) {
            for (int i = count; i < LOCKERS; i+=(count+1)) {
                lockers.set(i, !lockers.get(i)); // get lockers[i] state, then make it the opposite
            }
            count++;
        }
        printLockers(lockers);

    }
    // TODO: rework the printLockers method to accept a BitSet object rather than a BitArray object

    /**
     * This method prints out the open and closed status for 50 lockers in the format
     * 1: open
     * 2: closed
     * 3: closed
     * 4: open
     * ...
     * @param lockers - a set of 1 and 0's indicating whether a locker is open or closed
     */
    public static void printLockers(BitSet lockers) {
        for (int i = 0; i < LOCKERS; i++) {
            int mask = 1 << i;
            String status = !lockers.get(i) ? "closed" : "open";
            System.out.println((i+1) + ": " + status);
        }
    }
}
