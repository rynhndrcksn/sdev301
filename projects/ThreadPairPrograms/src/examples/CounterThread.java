package examples;

public class CounterThread extends Thread{
	private int low;
	private int high;

	public CounterThread(int low, int high){
		this.low = low;
		this.high = high;
	}

	public void run() {
		for (int i = low; i <= high; i++){
			System.out.println(Thread.currentThread().getName()+" count: "+i);

		}
	}

	public static void main(String[] args) {
		Thread[] threads =     {
				new CounterThread(1,10),
				new CounterThread(11,20),
				new CounterThread(21,30),
				new CounterThread(31,40),
				new CounterThread(41,50)
		};

		for (int i = 0; i < threads.length; i++){
			threads[i].start();
		}

		for (int i = 51; i <= 60; i++){
			System.out.println(Thread.currentThread().getName()+" count: "+i);
		}
	}
}
