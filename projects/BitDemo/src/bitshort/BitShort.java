package bitshort;

/**
 * BitShort is a class that demonstrates how to make a short, getter, and setter.
 * @author Ryan Hendrickson
 * @version 0.8
 */
public class BitShort {
    // fields
    private short data;

    // public BitShort() { arr = 0; } Java provides a default constructor

    public boolean get(int index) {
        short mask = createMask(index);
        // bitwise AND mask with data and return true or false
        return ((short)(data & mask) == mask);
    }

    public void set(int index, boolean val) {
        short mask = createMask(index);
        //  set bit
        if(val) {
            data = (short)(data | mask);
        } else { // unset bit
            // flip the mask then AND it with the data
            data = (short)(data & ~mask);
        }
    }

    // helper method
    private short createMask(int index) {
        // create a mask
        short mask = 1; // 0000_0000_0000_0001
        // shift mask over index shifts
        return (short)(mask << index);
    }
}
