package xor;

public class Test {
    public static void main(String[] args) {
        int x = 8888889;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(x & (~0 << 6)));
        System.out.println(Integer.toBinaryString((x >> 5) & 1));
        System.out.println(Integer.toBinaryString(x & (1 << 6)));
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(x | (1 << 6)));
        System.out.println(Integer.toBinaryString(x));
    }
}
