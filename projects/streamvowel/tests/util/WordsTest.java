package util;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordsTest {

	@Test
	public void testWords() {
		assertTrue(Words.hasFiveDistinctVowels("Absentious"));
		assertFalse(Words.hasFiveDistinctVowels("Hello, World!"));
	}
}