package examples;

public class CounterRunnable implements Runnable {
    private int low;
    private int high;

    public CounterRunnable(int low, int high){
        this.low = low;
        this.high = high;
    }

    @Override
    public void run(){
        // HAVE to put a try/catch in the run method if you overwrite it
        try {
            for (int i = low; i <= high; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            System.out.println(Thread.currentThread().getState());
            Thread.sleep(3000);
        } catch (InterruptedException e){
            // clean up resources/close resources
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new CounterRunnable(98,105));
        thread.start();
        System.out.println(thread.getState());
    }
}
