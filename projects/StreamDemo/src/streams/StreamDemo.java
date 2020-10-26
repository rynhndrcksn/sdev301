package streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo
{
	public static void main(String[] args) throws IOException
	{
		long start = System.currentTimeMillis();

		// create a stream on strings to read in the file at once
		Stream<String> lines = Files.lines(Paths.get("data/countries.txt"));
		//Scanner in = new Scanner(new File("data/countries.txt"));
		// This file contains one country name per line
		List<String> wordList = new ArrayList<>();
		// placing the stream of strings into wordList
		wordList = lines.collect(Collectors.toList());
		//while (in.hasNextLine()) { wordList.add(in.nextLine()); }
		// Now wordList is a list of country names

		// Traditional loop for counting the long words
		long count = 0;
		for (String w : wordList)
		{
			if (w.length() > 10) { count++; }
		}

		System.out.println("Long words: " + count);

		// The same computation with streams
		count = wordList.stream()
				.filter(w -> w.length() > 10)
				.count();

		System.out.println("Long words: " + count);
		System.out.println("Elapsed time: " + (System.currentTimeMillis()-start) + " milliseconds");
	}
}

