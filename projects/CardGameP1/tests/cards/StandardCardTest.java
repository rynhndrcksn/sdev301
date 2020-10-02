package cards;

import org.junit.Test;

import static org.junit.Assert.*;

public class StandardCardTest {

    @Test
    public void testConstructor() {
        // create a new StandardCard
        StandardCard card = new StandardCard("Ace", "Spades");

        // verify the StandardCard was constructed properly, AND verify toString works properly
        assertEquals("StandardCard was not constructed properly", "Ace of Spades", card.toString());
    }

}