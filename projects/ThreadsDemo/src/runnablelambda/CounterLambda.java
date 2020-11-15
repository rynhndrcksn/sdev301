package runnablelambda;

public class CounterLambda {
	public static void main(String[] args) {
		int low = 45;
		int high = 55;

		Runnable r = () -> {
			for (int i = low; i <= high; i++) {
				System.out.println(i);
			}
		};

		Thread thread = new Thread(r);
		thread.start();
	}
}
