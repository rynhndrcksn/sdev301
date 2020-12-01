package sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

// must be started before MathClient so it has something to connect to
public class MathServer {
	// public field so client can access MATH_PORT
	public static final int MATH_PORT = 42069;

	public static void main(String[] args) {
		// create a server socket using a try-with so the ServerSocket automatically closes
		try (ServerSocket server = new ServerSocket(MATH_PORT)) {
			System.out.println("Math server is starting...");

			// wait for a client to connect before proceeding
			Socket client = server.accept();
			System.out.println("Client has connected...");

			// set up the pipeline or streams (input/output) | input = from client, output = to client
			InputStream inStream = client.getInputStream();
			OutputStream outStream = client.getOutputStream();

			// create text objects: PrintWrite = out, Scanner = in
			// you can also pass in client.getInputStream and client.getOutputStream for conciseness
			Scanner in = new Scanner(inStream);
			PrintWriter out = new PrintWriter(outStream);

			// try to read in our 2 numbers
			try {
				int num1 = in.nextInt();
				int num2 = in.nextInt();
				calculate(num1, num2, out);
			} catch (InputMismatchException e) {
				// send a message to client that math protocol wasn't followed
				out.println("Math protocol expects <num1> <num2>");
				// force the MathServer to send the string now
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Math server is exiting...");
	}

	public static void calculate(int num1, int num2, PrintWriter out) {
		out.println(num1+" + "+num2+" = "+(num1+num2));
		out.println(num1+" - "+num2+" = "+(num1-num2));
		out.println(num1+" * "+num2+" = "+(num1*num2));
		if (num2 != 0) {
			out.println(num1+" / "+num2+" = "+(num1/num2));
		} else {
			out.println("You can't divide by 0");
		}
		out.println(num1+" % "+num2+" = "+(num1%num2));
		out.flush();
	}
}
