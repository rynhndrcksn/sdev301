import java.util.Scanner;

/**
 * console program to enter binary numbers and convert them to their decimal and char variants.
 * methods will ask how you want to handle input (enter binary, decimal, char, etc.
 * will elaborate on this program as needed
 * @author Ryan Hendrickson
 * @version 0.3
 * @date October 6th, 2020.
 */

public class BinaryExerciseChecker {
	public static void main(String[] args) {
		boolean loop = true;
		while(loop) {
			int option = printOptions();
			parseOption((int)(option));
			loop = false;
		}


		// problem  1
		int num1 = 0b01101110;
		int num2 = 0b10100010;

		int answer = (num1 & num2);
		printOperations(answer);
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

	public static void printOperations(int num) {
		System.out.println("The binary is: " + Integer.toBinaryString(num));
		System.out.println("The char is: " + (char)(num));
		System.out.println("The decimal is: " + num);
	}

	public static int printOptions() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Hello! What do you want to do?");
		System.out.println("Convert Binary: 1");
		System.out.println("Convert Char: 2");
		System.out.println("Convert Decimal: 3");
		System.out.println("Bitwise OR: 4");
		System.out.println("Bitwise AND: 5");
		System.out.println("Bitwise Complement: 6");
		System.out.println("Bitwise XOR: 7");
		System.out.println("Bitwise Left Shift: 8");
		System.out.println("Bitwise Right Shift: 9");
		System.out.println("Bitwise Unsigned Right Shift: 10");
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

	/**
	 * takes 2 numbers and performs an OR operation
	 * @param num1 is a binary number to be "OR'd" with num2
	 * @param num2 is a binary number to be "OR'd" with num1
	 */
	public static void bitwiseOr(int num1, int num2) {
		int output = num1 | num2;
		System.out.println(output);
	}

	/**
	 * takes 2 numbers and performs an AND operation
	 * @param num1 is a binary number to be "AND'd" with num2
	 * @param num2 is a binary number to be "AND'd" with num1
	 */
	public static void bitwiseAnd(int num1, int num2) {
		int output = num1 & num2;
		System.out.println(output);
	}

	/**
	 * takes 1 number and performs a "2's complement" on it
	 * @param num is the binary number to be "complemented"
	 */
	public static void bitwiseComplement(int num) {
		int output = ~num;
		System.out.println(output);
	}

	/**
	 * takes 2 numbers and performs a XOR operation
	 * @param num1 is a binary number to be XOR'd with num2
	 * @param num2 is a binary number to be XOR'd with num1
	 */
	public static void bitwiseXor(int num1, int num2) {
		int output = num1 ^ num2;
		System.out.println(output);
	}

	/**
	 * takes 2 numbers and performs a LEFT shift operation
	 * @param num1 is the binary number to shift
	 * @param num2 is the amount of times they want to shift num1
	 */
	public static void bitwiseLeftShift(int num1, int num2) {
		System.out.println(num1 << num2);
	}

	/**
	 * takes 2 numbers and performs a RIGHT shift operation
	 * @param num1 is the binary number to shift
	 * @param num2 is the amount of times they want to shift num1
	 */
	public static void bitwiseRightShift(int num1, int num2) {
		System.out.println(num1 >> num2);
	}

	/**
	 * takes 2 numbers and will perform an UNSIGNED RIGHT shift
	 * @param num1 is the binary number to shift
	 * @param num2 is the amount of times they want to shift num1
	 */
	public static void bitwiseUnsignedRightShift(int num1, int num2) {
		System.out.println(num1 >>> num2);
	}
}
