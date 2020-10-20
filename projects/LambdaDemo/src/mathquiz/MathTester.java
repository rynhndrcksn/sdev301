package mathquiz;

import java.util.Random;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;


public class MathTester {
    public static void main(String[] args) {


        // quiz the user on a addition problem
        mathQuiz( "+", (x, y) -> x + y);

        // quiz the user on a multiplication problem
        mathQuiz("*", (x, y) -> x * y);

        // quiz the user on a bitwise & problem
        mathQuiz("&", (x, y) -> x & y);

        // quiz the user on a bitwise | problem
        mathQuiz("|", (x,y) -> x | y);
    }

    /**
     *
     * @param op represents the operator being used on two integers as a String
     * @param operator a reference to an interface IntBinaryOperator
     *
     * The IntBinaryOperator interface contains one abstract method
     * public interface IntBinaryOperator {
     *       int applyAsInt(int left, int right)
     * }
     */
    public static void mathQuiz(String op, IntBinaryOperator operator) {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();
        final int MAX = 12;

        // Generate two random numbers for math problems range 1 - 12
        int x = r.nextInt(MAX) + 1;
        int y = r.nextInt(MAX) + 1;

        System.out.print(x + " " + op + " " + y + " = ");
        // calculate answer using the lambda expression passed in
        int answer = operator.applyAsInt(x, y);

        // get user's answer
        int response = kb.nextInt();

        String status = (response == answer ) ? "you are brilliant!!!" :
                "incorrect...the answer was "+answer;
        System.out.println(status);

    }
}
