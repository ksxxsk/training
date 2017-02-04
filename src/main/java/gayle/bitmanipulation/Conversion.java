package gayle.bitmanipulation;

/**
 * Conversion: Write a function to determine the number of bits you would need to flip to convert
 * integer A to integer B.
 * EXAMPLE
 * Input:
 * Output:
 * 29 (or: 111101), 15 (or: 101111)
 * 2
 * Hints: #336, #369
 */
public class Conversion {

    public static int conversion(int num1, int num2) {
        return Integer.bitCount((num1 ^ num2));
    }

    public static int conversion2(int num1, int num2) {
        int count = 0;
        for (int c = num1 ^ num2; c != 0; c >>= 1)
            count += c & 1;

        return count;
    }

    public static int conversion3(int num1, int num2) {
        int count = 0;
        for (int c = num1 ^ num2; c != 0; c = c & (c - 1))
            count++;

        return count;
    }
}
