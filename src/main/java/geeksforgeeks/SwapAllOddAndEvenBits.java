package geeksforgeeks;

/**
 * Given an unsigned integer, swap all odd bits with even bits. For example, if the given number is 23 (00010111), it
 * should be converted to 43 (00101011). Every even position bit is swapped with adjacent bit on right side (even
 * position bits are highlighted in binary representation of 23), and every odd position bit is swapped with adjacent on
 * left side.
 */
public class SwapAllOddAndEvenBits {

    public static int swapOddAndEven(int number) {
        int oddMask = 0x55555555;
        int evenMask = 0xaaaaaaaa;

        return ((number & oddMask) << 1) | ((number & evenMask) >> 1);
    }
}
