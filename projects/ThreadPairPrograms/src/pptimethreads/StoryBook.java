package pptimethreads;

/**
 * StoryBook is a class that uses run() to print parts of a story while using .sleep() and .join() to demonstrate what
 * they can do
 * @author Ryan H.
 * date: November 17th, 2020.
 * @version 1.0
 */

public class StoryBook extends Thread {

	@Override
	public void run() {
		// print welcome
		System.out.println("Well howdy y'all, welcome to the story book!");
		try {
			// pause for 2 seconds
			Thread.sleep(2000);
			System.out.print("The story began long, long ago");
			// display 10 . separated by 1/2 second.
			for (int i = 0; i < 10; i++) {
				System.out.print(".");
				Thread.sleep(500);
			}
			System.out.println();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		StoryBook story = new StoryBook();
		story.start();
		// make main method pause until the story book run method is over
		story.join();
		System.out.println("And they lived happily ever after.");
	}
}
