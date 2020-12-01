package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MathClient {
	public static void main(String[] args) {
		// create a socket for the client
		// having our client end with ; allows us to enter an additional thing to automatically close
		try (Socket client = new Socket("localhost",MathServer.MATH_PORT);
				Scanner kb = new Scanner(System.in)) {

			// prompt for two numbers
			System.out.println("Enter 2 integers separated by a space: ");

			// read in our numbers
			String nums = kb.nextLine();

			// setup our text transfer objects
			// the true is for autoFlush, so the information is always sent without us calling out.flush
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			Scanner in = new Scanner(client.getInputStream());

			// send the numbers to the MathServer
			out.println(nums);

			// get the result from MathServer
			while (in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
		} catch (UnknownHostException e) { // this is for the localhost possibly being unknown
			e.printStackTrace();
		} catch (IOException e) { // this is for the MATH_PORT possible being wrong
			e.printStackTrace();
		}

		System.out.println("Math client is exiting...");
	}
}
