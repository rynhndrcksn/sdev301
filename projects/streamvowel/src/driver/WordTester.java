package driver;

import java.util.List;
import util.*;

public class WordTester {
	public static void main(String[] args)
	{
		List<String> words = Words.fiveUniqueDistinctVowels("data/words.txt");
		System.out.println("Number of words: " + words.size());
		System.out.println("Expected: 351");

		if(words.size() > 20) {
			System.out.println(words.get(2));
			System.out.println("Expected: abstentious");
			System.out.println(words.get(20));
			System.out.println("Expected: beauvoir");
		}

	}
}
