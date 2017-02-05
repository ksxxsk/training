package geeksforgeeks;

/**
 * Write a program to print Binary representation of a given number.
 */
public class BinaryRepresentation {

    public static void binary(int number) {

        for (int i = 1 << 31; i > 0; i >>= 1)
            System.out.println((number & i) != 0 ? 1 : 0);
    }
}
