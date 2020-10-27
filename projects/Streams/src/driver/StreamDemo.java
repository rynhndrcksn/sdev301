package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamDemo {
	public static void main(String[] args) {

		try (Scanner fileIn = new Scanner(new File("data/countries.txt"))) {

			// Read in file which contains one country name per line
			List<String> wordList = new ArrayList<>();
			while (fileIn.hasNextLine()) {
				wordList.add(fileIn.nextLine());
			}

			long count;
			// for each loop for counting the words with length >= 10
			count = wordCount(wordList, 10);
			System.out.println("Words >= 10 characters: " + count);

			// uses streams to count
			count = streamCount(wordList,10);
			System.out.println("Words >= 10 characters: " + count);

			// TODO:uses streams to count
			count = letterCount(wordList,"A");
			System.out.println("Words begin with A: " + count);

			// TODO: uses streams to count
			count = containsCount(wordList,"tan");
			System.out.println("Words contain tan: " + count);

		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
	}


	/** TODO
	 * this letterCount method uses streams to count the number
	 * of words in the list that begin with the letter param
	 * @param wordList list of words
	 * @param letter  letter of interest
	 * @return count
	 */
	public static long letterCount(List<String> wordList, String letter) {
		return wordList.stream()
				.filter(word -> word.startsWith(letter))
				.count();
	}


	/** TODO
	 * this containsCount method uses streams to count the number
	 * of words in the list that contains the letters param
	 * @param wordList list of words
	 * @param letters  letter of interest
	 * @return count
	 */
	public static long containsCount(List<String> wordList, String letters) {
		return wordList.stream()
				.filter(word -> word.toLowerCase().contains(letters.toLowerCase()))
				.count();
	}

	/**
	 * this method uses streams to count the number
	 * of words in the list that begin with the letter
	 * @param wordList list of words
	 * @param length  word length of interest
	 * @return count
	 */
	public static long streamCount(List<String> wordList, int length){
		// The same computation with streams
		return wordList.stream()
				.filter(w -> w.length() >= length)
				.count();
	}

	/**
	 * this method uses a for each loop to count the number
	 * of words in the list with a length() >= to length
	 * @param wordList list of words
	 * @param length  word length of interest
	 * @return count
	 */
	public static long wordCount(List<String> wordList, int length){
		long count = 0;
		for (String w : wordList) {
			if (w.length() >= length) {
				count++;
			}
		}
		return count;
	}
}


