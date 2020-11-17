package examples;

public class WorkerThreadTester {
    public static void main(String[] args) throws InterruptedException {
        WorkerThread worker = new WorkerThread();
        worker.start();

        // main method will wait until worker thread is done
        worker.join();

        // get result
        int result = worker.getSum();
        System.out.println(result);
    }
}
