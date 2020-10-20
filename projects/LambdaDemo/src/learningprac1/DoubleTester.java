package learningprac1;

import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

/** program that shows how lambda expressions work and how useful they can be
 * @author Ryan Hendrickson
 * @date October 20th, 2020.
 * @version 1.0
 */
public class DoubleTester {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the first number: ");
		double num1 = kb.nextDouble();
		System.out.println("Please enter the second number: ");
		double num2 = kb.nextDouble();

		produceAnswers(num1, num2, "area is ", (x,y) -> x*y);
		produceAnswers(num1, num2, "perimeter is ", (x,y) ->(2*x)+(2*y));
		produceAnswers(num1, num2, "difference is ", (x,y) -> x-y);
	}

	/**
	 * takes in a lambda expression and formats the output we want
	 * @param x is a user inputted number
	 * @param y is a user inputted number
	 * @param s is the string that is supplied
	 * @param op is the lambda expression we are inputting
	 */
	public static void produceAnswers(double x, double y, String s, DoubleBinaryOperator op) {
		System.out.println("Number 1: " + x + " and Number 2: " + y + " means the " + s + op.applyAsDouble(x, y));
	}
}
