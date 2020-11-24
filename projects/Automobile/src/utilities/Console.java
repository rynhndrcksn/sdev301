package utilities;

import java.util.Scanner;


public final class Console {
    private static Scanner console = new Scanner(System.in);


    /**
     * Prompts the user and retrieves a String value from the Java console.
     *
     * @param prompt a prompt for the user to read before
     *               entering input
     * @return a String value
     */
    public static String readText(String prompt) {
        System.out.print(prompt+" ");
        return console.nextLine();
    }

    /**
     * Prompts the user and retrieves an int value from the Java console.
     *
     * @param prompt a prompt for the user to read before
     *               entering input
     * @return an int value
     */
    public static int readInt(String prompt) {
		System.out.print(prompt+" ");
         while (!console.hasNextInt()) {
            System.out.println("Please enter a valid integer: ");

            //clear the scanner buffer
            console.nextLine();
        }
         int num = console.nextInt();

         // clear newline
		console.nextLine();

        return num;
    }


    /**
     * Prompts the user and retrieves a double value from the Java console.
     *
     * @param prompt a prompt for the user to read before
     *               entering input
     * @return a double value
     */
    public static double readDecimal(String prompt) {
		System.out.print(prompt+" ");

		while (!console.hasNextDouble()) {
			System.out.println("Please enter a valid decimal: ");

			//clear the scanner buffer
			console.nextLine();
		}

		double decimal = console.nextDouble();

		//clear the scanner buffer
		console.nextLine();

		return decimal;
    }



    /**
     * Prompts the user and retrieves a boolean value from the Java console.
     *
     * @param prompt a prompt for the user to read before
     *               entering input
     * @return a boolean value
     */
    public static boolean readBoolean(String prompt) {
		System.out.print(prompt+" ");

		while (!console.hasNextBoolean()) {
			System.out.println("Please enter true/false: ");

			//clear the scanner buffer
			console.nextLine();
		}

		boolean result = console.nextBoolean();

		//clear the scanner buffer
		console.nextLine();

		return result;

    }

    /**
     * Prompts the user and retrieves a char value from the Java console.
     *
     * @param prompt a prompt for the user to read before
     *               entering input
     * @return a char value
     */
    public static char readChar(String prompt) {

		System.out.print(prompt+" ");

		while (true) {
			String input = console.nextLine();

			if (input.length() == 1) {
				return input.charAt(0);
			} else {
				System.out.println("Please enter a single character: ");
			}
		}


    }


}
