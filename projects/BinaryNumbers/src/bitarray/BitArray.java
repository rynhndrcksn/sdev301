package bitarray;

/**
 * BitArray is a class that makes a 64 bit long, then we manipulate the first 50 of those bits to
 * solve the "locker problem".
 * @author Ryan Hendrickson
 * @version 1.0
 */

public class BitArray {
    // fields
    private long data;

    // public BitArray() { arr = 0; } Java provides a default constructor

    /**
     * gets the value of index and returns whether it's set (true) or not (false)
     * @param index is whichever index the user wants to know the state of
     * @return whether the bit at index is set (true) or not (false)
     */
    public boolean get(int index) {
        long mask = createMask(index);
        // bitwise AND mask with data and return true or false
        return ((data & mask) == mask);
    }

    /**
     * sets the bit at index to the value
     * @param index is whichever index the user wants to manipulate
     * @param val is true (set the bit) or false (unset the bit)
     */
    public void set(int index, boolean val) {
        long mask = createMask(index);
        //  set bit
        if(val) {
            data = data | mask;
        } else { // unset bit
            // flip the mask then AND it with the data
            data = data & ~mask;
        }
    }

    /**
     * helper method that creates a mask for the BitArray
     * @param index is used for shifting the 1 in the mask over
     * @return a mask with the 1('s) shifted to where it/they need to be
     */
    private long createMask(int index) {
        // create a mask
        long mask = 1; // 0000_0000_0000_0001
        // shift mask over index shifts
        return mask << index;
    }
}
