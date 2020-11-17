package examples;

public class CounterLambda {
    int low;
    int high;

    public CounterLambda(int l, int h){
        low = l;
        high = h;
    }

    public static void main(String[] args) {
        // create a lambda expression for the task the "run" should complete
        Runnable r = () ->{
            CounterLambda counter = new CounterLambda(67, 102);
            for (int i = counter.low; i <= counter.high ; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        };

        Thread thread = new Thread(r);
        thread.start();
    }
}
