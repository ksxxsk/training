package hackerrank.bitmanipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maximizing-xor
 */
public class MaximumXOR {

    private static int maximumXOR1(int l, int r) {
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++)
            for (int j = l; j < r; j++) {
                int xor = i ^ j;
                if (xor > max)
                    max = xor;
            }
        return max;
    }

    private static int maximumXOR2(int l, int r) {
        int q = l ^ r;
        int c = 1;
        while (q > 0) {
            q >>= 1;
            c <<= 1;
        }
        return c - 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();

        System.out.println(maximumXOR1(l, r));
    }
}
