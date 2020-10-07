import java.util.Scanner;

/**
 * console program to enter binary numbers and convert them to their decimal and char variants.
 * methods will ask how you want to handle input (enter binary, decimal, char, etc.
 * will elaborate on this program as needed
 * @author Ryan Hendrickson
 * @version 0.1
 * @date October 6th, 2020.
 */

public class BinaryExerciseChecker {
	public static void main(String[] args) {
		int option = printOptions();
		parseOption(option);

		// problem  1
		int num1 = 0b01101110;
		int num2 = 0b10100010;

		int answer = (num1 & num2);
		printOpts(answer);
	}

	private static void parseOption(int option) {
		if(option == 1) {
			procBin(option);
		} else if(option == 2) {
			procChar(option);
		} else if(option == 3) {
			procDec(option);
		} else {
			System.out.println("I'm not sure how we got here...");
		}
	}

	public static void printOpts(int num) {
		System.out.println("The binary is: " + Integer.toBinaryString(num));
		System.out.println("The char is: " + (char)(num));
		System.out.println("The decimal is: " + num);
	}

	public static int printOptions() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Hello! What do you want to enter?");
		System.out.println("Binary: 1");
		System.out.println("Char: 2");
		System.out.println("Decimal: 3");
		int n = kb.nextInt();
		kb.close();
		// if statement to see whether n is an int or not
		return n;
	}

	private static void procDec(int num) {

	}

	private static void procChar(int num) {

	}

	private static void procBin(int num) {

	}

}
