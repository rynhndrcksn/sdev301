package streamchars;

import java.util.stream.IntStream;

// helpful demo for Pair Program Word Identification
public class StreamChars {
	public static void main(String[] args) {
		// how do you look at individual characters in a String?
		String word = "hello";

		/*
		create a stream of individual primitive characters
		'h' - 104, 'e' - 101, 'l' - 108, 'l' - 108, 'o' -111
		chars are stored as ints, swap them to ints and compare to ascii table
		then count how many vowels are in here
		 */
		// take each letter in word, make it a char (int), and add it to IntStream
		IntStream letters = word.chars();

		// print the results of the above conversion (will spell "hello" in ascii.
		letters.forEach(n -> System.out.println(n));
		// words.chars().forEach(n -> System.out.println((char)n)); is a more condensed way of doing it

		// go through word, look for chars, filter them, and if theres a vowel then increment "count"
		long count = word.chars()
				.filter(c-> c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
				.count();

		System.out.println(word + " has " + count + " vowels.");
	}
}
