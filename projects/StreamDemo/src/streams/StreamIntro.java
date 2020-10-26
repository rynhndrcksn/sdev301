package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntro {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("apple", "potato", "carrot", "pickles", "fish");

		List<String> list = stream
				.collect(Collectors.toList());
		System.out.println(list);

		/*
		stream
				.forEach(n-> System.out.println(n));

		// count how many strings have length of 5
		long count = stream
				.filter(w-> w.length() >= 5) // lambda expression to count the length and filter out what doesn't match
				.limit(2) // limit it to the first 2
				.count(); // count stuff, obviously

		System.out.println("How many strings have a length of 5+: " + count);
		 */
	}
}
