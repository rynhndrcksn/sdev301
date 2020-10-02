package cards;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testConstructor() {
        // create a new Card
        Card card = new Card("Ace of Spades");

        // verify the Card was constructed properly, AND verify toString works properly
        assertEquals("Card was not constructed properly", "Ace of Spades", card.toString());
    }
}