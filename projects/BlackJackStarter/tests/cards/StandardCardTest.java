package cards;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StandardCardTest {

	@Test
	public void testGetRankValue() {
		StandardCard c1 = new StandardCard("Ace", "Spades");
		StandardCard c2 = new StandardCard("Jack", "Diamonds");
		StandardCard c3 = new StandardCard("8", "Clubs");
		StandardCard c4 = new StandardCard("2", "Hearts");

		assertEquals(11, c1.getRankValue());
		assertNotEquals(10, c1.getRankValue());

		assertEquals(10, c2.getRankValue());
		assertNotEquals(5, c2.getRankValue());

		assertEquals(8, c3.getRankValue());
		assertNotEquals(6, c3.getRankValue());

		assertEquals(2, c4.getRankValue());
		assertNotEquals(54, c4.getRankValue());
	}
}