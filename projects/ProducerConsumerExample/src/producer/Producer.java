package producer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	private BlockingQueue<String> queue;
	private int id;

	public Producer(BlockingQueue<String> queue, int id) {
		this.queue = queue;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 50; i++) {
				String item = "Item: " + i + " from Producer: " + id;
				System.out.println("Adding: " + item);
				queue.put(item);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted: " + e);
			e.printStackTrace();
		}
	}
}
