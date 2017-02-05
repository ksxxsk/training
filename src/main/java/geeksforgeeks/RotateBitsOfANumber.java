package geeksforgeeks;

/**
 * Bit Rotation: A rotation (or circular shift) is an operation similar to shift except that the bits that fall off at
 * one end are put back to the other end.
 * <p>
 * In left rotation, the bits that fall off at left end are put back at right end.
 * <p>
 * In right rotation, the bits that fall off at right end are put back at left end.
 */
public class RotateBitsOfANumber {

    public static int rotateLeft(int number, int n) {
        return (number << n) | (n >> (32 - n));
    }

    public static int rotateRigth(int number, int n) {
        return (number >> n) | (n << (32 - n));
    }
}
