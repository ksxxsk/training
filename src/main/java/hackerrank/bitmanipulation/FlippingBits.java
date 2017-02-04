package hackerrank.bitmanipulation;

import java.util.Scanner;


public class FlippingBits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
            System.out.println(flippingBits(in.nextLong()));
    }

    private static long flippingBits(long i) {
        return i ^ 0xffffffffL;
    }
}
