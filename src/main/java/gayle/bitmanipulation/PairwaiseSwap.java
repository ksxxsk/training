package gayle.bitmanipulation;

/**
 * Write a program to swap odd and even bits in an integer with as few instructions as
 * possible (e.g., bit 13 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 * Hints: #145, #248, #328, #355
 */
public class PairwaiseSwap {

    public static int swapOddWithEven(int number) {
        return (((number & 0xaaaaaaaa) >> 1) | ((number & 0x55555555) >> 1));
    }
}
