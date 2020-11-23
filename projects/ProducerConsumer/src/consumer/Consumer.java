package consumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private final int DELAY = 1;
	private BlockingQueue<String> queue;
	private int id;

	public Consumer(BlockingQueue<String> queue, int id) {
		this.queue = queue;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 50; i++) {
				String item = queue.take();
				System.out.println("Consumer " + id + " is removing: " + item);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted: " + e);
			e.printStackTrace();
		}
	}
}
