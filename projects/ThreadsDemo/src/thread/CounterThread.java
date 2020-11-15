package thread;

public class CounterThread extends Thread{
	private int low; // start counting here
	private int high; // stop counting here

	public CounterThread(int low, int high) {
		this.low = low;
		this.high = high;
	}

	@Override
	public void run() {
		for (int i = low; i <= high; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		CounterThread thread = new CounterThread(1, 10);
		thread.start(); // invokes the run() method | starts a thread. Just doing .run() runs the thread in the main thread
		System.out.println(thread.getName()); // get the name of the thread, obviously
		System.out.println("Priority: " + thread.getPriority()); // get priority of the thread (max of 10)
	}
}
