package examples;

public class WorkerThread extends Thread {
    private static final int MAX = 10000;
    private int sum;

    @Override
    public void run(){
        // add the first 10000 integers together
        for (int i = 0; i < MAX; i++) {
            sum += i;
        }
    }

    public int getSum() {
        return sum;
    }
}
