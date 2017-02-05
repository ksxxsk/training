package geeksforgeeks;

/**
 * You are given two numbers A and B. Write a program to count number of bits needed to be flipped to convert A to B.
 */
public class BitsToFlip {

    public static int bitsToFlip(int a, int b) {
        return Integer.bitCount(a ^ b);
    }
}
