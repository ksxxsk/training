package geeksforgeeks;

/**
 * Given an integer array of n integers, find sum of bit differences in all pairs that can be formed from array
 * elements. Bit difference of a pair (x, y) is count of different bits at same positions in binary representations of x
 * and y. For example, bit difference for 2 and 7 is 2. Binary representation of 2 is 010 and 7 is 111 ( first and last
 * bits differ in two numbers).
 */
public class SumOfBitDifferencesAmongAllPairs {

    public static int naive(int[] array) {
        int sum = 0;
        for (int n : array)
            for (int m : array)
                sum += Integer.bitCount(n ^ m);

        return sum;
    }

    public static int bitCount(int[] array) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int number : array)
                if ((number & (1 << i)) != 0)
                    count++;

            result += count * (array.length - count) * 2;
        }

        return result;
    }
}
