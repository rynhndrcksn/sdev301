

public class NumberRepresent {
    public static void main(String[] args) {
        int a = 8;
        // 0b allows you to assign a binary to an int
        int b = 0b0101111;
        // 0x allows you to assign a hex to an int
        int c = 0x4C;
        // 0 allows you to assign an octal to an int
        int d = 045;

        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(b);
        System.out.println(Integer.toBinaryString(b));
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        System.out.println(d);
        System.out.println(Integer.toBinaryString(d));

        integralDataTypes();
    }

    // demo the integral data types = byte, short, int, long
    public static void integralDataTypes() {
        System.out.println("Below are the minimum values for byte, short, int, and long:");
        // 8 bits, but 1 is reserved for the sign (MSB) so you only have
        // 7 bits to create numerical values with. -128 -> 127
        byte a = Byte.MIN_VALUE;
        System.out.println("Byte minimum value: " + a);
        short b = Short.MIN_VALUE;
        System.out.println("Short minimum value: " + b);
        int c = Integer.MIN_VALUE;
        System.out.println("Int minimum value: " + c);
        long d = Long.MIN_VALUE;
        System.out.println("Long minimum value: " + d);

        System.out.println("Below are the maximum values for byte, short, int, and long:");
        byte e = Byte.MAX_VALUE;
        System.out.println("Byte maximum value: " + e);
        short f = Short.MAX_VALUE;
        System.out.println("Short maximum value: " + f);
        int g = Integer.MAX_VALUE;
        System.out.println("Int maximum value: " + g);
        long h = Long.MAX_VALUE;
        System.out.println("Long maximum value: " + h);
    }
}
