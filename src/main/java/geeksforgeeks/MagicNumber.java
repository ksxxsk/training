package geeksforgeeks;

/**
 * A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5. First few
 * magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 * <p>
 * Write a function to find the nth Magic number.
 * <p>
 * Example:
 * <p>
 * Input: n = 2 Output: 25
 * <p>
 * Input: n = 5 Output: 130
 */
public class MagicNumber {

    public static int findNthMagicNumber(int n) {
        int pow = 5;
        int answer = 0;
        while (n != 0) {
            answer += (n & 1) * pow;
            pow *= 5;
            n >>= 1;
        }

        return answer;
    }


}
