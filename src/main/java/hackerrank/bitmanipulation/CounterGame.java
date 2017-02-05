package hackerrank.bitmanipulation;

import java.math.BigInteger;
import java.util.Scanner;

public class CounterGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
            System.out.println(counterGame(in.nextBigInteger()));
    }

    private static String counterGame(BigInteger n) {
        int counter = 0;
        while (isNotOne(n)) {
            counter++;
            if (isPowerOfTwo(n))
                n = reduceByHalf(n);
            else
                n = reduceByTheLargerPowOf2(n);
        }
        return counter % 2 == 0 ? "Richard" : "Louise";
    }

    private static boolean isNotOne(BigInteger n) {
        return !n.equals(BigInteger.ONE);
    }

    private static boolean isPowerOfTwo(BigInteger n) {
        return (!n.equals(BigInteger.ZERO)) && (n.and(n.subtract(BigInteger.ONE))).equals(BigInteger.ZERO);
    }

    private static BigInteger reduceByHalf(BigInteger n) {
        return n.shiftRight(1);
    }

    private static BigInteger reduceByTheLargerPowOf2(BigInteger n) {
        int bits = n.bitLength();
        BigInteger pow = n.add(BigInteger.ZERO);
        for (int i = 0; i < bits - 1; i++)
            pow = pow.clearBit(i);
        pow = pow.setBit(bits - 1);
        n = n.subtract(pow);
        return n;
    }
}
