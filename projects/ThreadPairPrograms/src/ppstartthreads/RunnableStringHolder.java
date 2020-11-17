package ppstartthreads;

/**
 * RunnableStringHolder is a class that holds a string and prints it back out on demand using run()
 * @author Ryan R. and Ryan H.
 * date: November 17th, 2020.
 * @version 1.0
 */

public class RunnableStringHolder implements Runnable {
	// fields
	private String data;

	public RunnableStringHolder(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public void run() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Printed from RunnableStringHolder: " + data;
	}
}