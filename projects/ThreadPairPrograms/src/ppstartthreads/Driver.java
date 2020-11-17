package ppstartthreads;

/**
 * Driver is a class that creates objects for StringHolder, RunnableStringHolder, and RunnableStringLambda.
 * Driver then calls start(), run() or uses lambda expressions to print the same sentence stored in 'string' field
 * @author Ryan R. and Ryan H.
 * date: November 17th, 2020.
 * @version 1.0
 */

public class Driver {
	public static void main(String[] args) {
		// field
		String string = "As I expected. \"Mary Poppins, practically perfect in every way.\"";

		// test StringHolder
		StringHolder s1 = new StringHolder(string);
		s1.start();

		// test RunnableStringHolder
		RunnableStringHolder s2 = new RunnableStringHolder(string);
		s2.run();

		// test RunnableStringLambda
		Runnable r = () -> {
			RunnableStringLambda s3 = new RunnableStringLambda(string);
			System.out.println(s3.toString());
			System.out.println("String length: " + s3.getData().length());
			int digits = 0;
			int alpha = 0;
			int special = 0;
			for (int i = 0; i < s3.getData().length(); i++) {
				char c = s3.getData().charAt(i);

				if (Character.isDigit(c)) {
					digits++;
				} else if (Character.isAlphabetic(c)) {
					alpha++;
				}
			}
			System.out.println("Number of digits: " + digits);
			System.out.println("Number of alphabetic characters: " + alpha);
			System.out.println("Number of special characters: " + (s3.getData().length() - (digits + alpha)));
		};
		Thread thread = new Thread(r);
		thread.start();
	}
}
