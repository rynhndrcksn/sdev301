package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Complete the hasFiveDistinctVowels method below which is used
 * by fiveUniqueDistinctVowels
 *
 * The fiveUniqueDistinctVowels method will
 * read all of the words in filename and return a list of
 * all words which contain all five vowels, aeiou, where each vowel
 * occurs only once. You may assume that the file will have
 * one word per line.
 */
public class Words {
	// field (create an array to help determine the vowels)
	private static final Character[] vowelsArray = {'a', 'e', 'i', 'o', 'u'};

	/**
	 * This method creates and returns a list of all words which contain a,e,i,o,u only once
	 *
	 * @param filename name of the file containing the words
	 * @return a list of words that has vowels a e i o u only once
	 */
	public static List<String> fiveUniqueDistinctVowels(String filename) {

		try (Stream<String> lines = Files.lines(Paths.get(filename))) {

			return lines
					.filter(Words::hasFiveDistinctVowels)
					.collect(Collectors.toList());


		} catch (IOException e) {

			System.err.println(e);

		}

		// return an empty list if there is an IO Exception
		return new ArrayList<>();

	}

	/**
	 * @param word the word to check
	 * @return true if word has a,e,i,o,u only once, false otherwise
	 */
	public static boolean hasFiveDistinctVowels(String word) {
		return isUnique(word.toLowerCase().chars()) && hasVowels(word.toLowerCase().chars());
	}

	/**
	 * helper method to determine if the word has 1 of each vowel only
	 * @param word is passed in as an IntStream
	 * @return TRUE if there's only a, e, i, o, and u as vowels with no extras
	 */
	private static boolean isUnique(IntStream word) {
		return (word
				.filter(c-> Arrays.asList(vowelsArray).contains((char)c))
				.distinct()
				.count()) == 5;
	}

	/**
	 * helper method to determine if word has all 5 vowels present
	 * @param word is passed in as an IntStream
	 * @return TRUE if the word has at least 1 a, e, i, o, and u
	 */
	private static boolean hasVowels(IntStream word) {
		return (word
				.filter(c-> Arrays.asList(vowelsArray).contains((char)c))
				.count()) == 5;
	}

}
