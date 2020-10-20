package bitshort;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitShortTest {
    // make a constant field for num of bits
    public static final int NUM_BITS = 16;

    @Test
    public void testSetMethod() {
        BitShort bits = new BitShort();

        // set all bits to true
        for (int i = 0; i < NUM_BITS; i++) {
            bits.set(i, true);
        }

        // verify all bits are true
        for (int i = 0; i < NUM_BITS; i++) {
            assertTrue("get(" + i + ") incorrectly returned false", bits.get(i));
        }

        // set all bits to false
        for (int i = 0; i < NUM_BITS; i++) {
            bits.set(i, false);
        }

        // verify all bits are false
        for (int i = 0; i < NUM_BITS; i++) {
            assertFalse("get(" + i + ") incorrectly returned true", bits.get(i));
        }
    }
}