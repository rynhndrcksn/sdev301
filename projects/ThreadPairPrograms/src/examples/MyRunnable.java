package examples;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRunnable implements Runnable {

    private static Thread[] threads = {new Thread(new MyRunnable()),
            new Thread(new MyRunnable()),
            new Thread(new MyRunnable())
    };

    @Override
    public void run() {

        try {
            // run for 120 seconds or 2 minutes
            for (int i = 1; i <= 120; i++) {
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName());
                // sleep for 1000 milliseconds (1 second)
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted "+e);
        }

    }

    public static void main(String[] args) {

        startThreads();
        //createThreadPool();

        try {
            // run for 10 seconds
            for (int i = 1; i <= 10; i++) {
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted "+e);
        }

        // Have main thread interrupt Thread 0
        threads[0].interrupt();


    }

    public static void startThreads(){

        for (Thread t : threads) {
            t.start();
        }
    }

    public static void createThreadPool(){
        final int MAX_THREADS = 2;
        Runnable[] runnables = { new MyRunnable(),
                new MyRunnable(),
                new MyRunnable()
        };
        ExecutorService pool = Executors.newFixedThreadPool(MAX_THREADS);
        for(Runnable r : runnables){
            pool.execute(r);
        }

    }
}

