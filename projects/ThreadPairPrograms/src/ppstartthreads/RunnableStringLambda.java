package ppstartthreads;

/**
 * RunnableStringLambda is a class that holds a string and prints it back out on demand using lambda expressions
 * in the Driver class
 * @author Ryan R. and Ryan H.
 * date: November 17th, 2020.
 * @version 1.0
 */

public class RunnableStringLambda {
	// fields
	private String data;

	public RunnableStringLambda(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Printed from RunnableStringLambda: " + data;
	}

}
