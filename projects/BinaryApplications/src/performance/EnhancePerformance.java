package performance;

public class EnhancePerformance {

    private static int TIMES = 15;

    public static void main(String[] args) {
        long start = System.nanoTime();
        slowPerformance();
        System.out.println("Slow Elasped Time: "+(System.nanoTime()-start)+ " nanoseconds ");

        start = System.nanoTime();
        fasterPerformance();
        System.out.println("Faster Elasped Time: "+(System.nanoTime()-start)+ " nanoseconds ");

    }

    public static void slowPerformance() {

        int result = 1;
        for (int i=1; i <= TIMES; i++){
            // multiply by 2
            result *= 2;
        }
        System.out.println("Result is "+result);

    }

    public static void fasterPerformance() {
        int result = 1;
        for (int i = 1; i <= TIMES; i++){
            // multiply by 2
            result = result << 1;
        }
        System.out.println("Result is "+result);

    }

}

