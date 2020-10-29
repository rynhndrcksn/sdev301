package streamobjects;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// helpful demo for Card Game Part 2
public class StreamDie {
	public static void main(String[] args) {
		// create a stream of die objects
		Stream<Die> dice = Stream.of(new Die(6), new Die(12), new Die(20));

		// collect the stream into a permanent data structure like ArrayList, LinkedList, Set, Maps (List interface), etc
		// make a new list of Dice, collect them up, and send them to a List
		List<Die> diceList = dice.collect(Collectors.toList());

		// print out Die objects in a stream
		diceList.forEach(n -> System.out.println("Rolled a " + n));

		// call a method on the Die objects
		dice.map(d -> d.rollDie()).forEach(n -> System.out.println("Rolled a " + n));
	}
}
