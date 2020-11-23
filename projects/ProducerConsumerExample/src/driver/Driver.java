package driver;

import consumer.Consumer;
import producer.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Driver {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(50);

		for (int i = 0; i < 10; i++) {
			// create 10 producers (threads)
			new Thread(new Producer(queue, i)).start();
		}

		for (int i = 0; i < 10; i++) {
			// create 10 consumers (threads)
			new Thread(new Consumer(queue, i)).start();
		}
	}
}
