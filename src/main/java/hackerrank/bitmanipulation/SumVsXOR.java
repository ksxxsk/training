package hackerrank.bitmanipulation;

import java.util.Scanner;

/**
 * 5     ->   SUM |  XOR If you look for two operands A, B where A ^ B = A + B, you need that you never have a carry
 * when summing them. This happens if it never happens that the i-th bit of A and the i-th bit of B are both 1. So given
 * the operand A, all the bits in A which are 1 must be 0 in B. They are fixed bits and you have no choice for them. But
 * all other bits in B are free and you can set them to 1 or 0 and the equation will keep being true. To count all
 * possible values of B, you must then count the 0's in A (i.e. the number of free bits in B) and calculate 2 to the
 * power of the free bits.
 */
public class SumVsXOR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(sumVsXor2(n));

    }

    private static long sumVsXor2(long n) {
        if (n == 0)
            return 0;

        String binary = Long.toBinaryString(n);
        long num = 1;
        for (int i = 0; i < binary.length(); i++)
            if (binary.charAt(i) == '0')
                num <<= 1;

        return num;
    }

    private static int sumVsXor1(long n) {
        int count = 0;
        for (int i = 0; i <= n; i++)
            if ((i + n) == (i ^ n))
                count++;

        return count;
    }
}
