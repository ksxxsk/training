package geeksforgeeks;


/**
 * A number is Sparse if there are no two adjacent 1s in its binary representation. For example 5 (binary representation: 101) is sparse, but 6 (binary representation: 110) is not sparse.
 Given a number x, find the smallest Sparse number which greater than or equal to x.
 */
public class NextSparseNumber {

    public static int naive(int number) {
        for(int i=number; ;i++)
            if(isSparse(i))
                return i;

    }

    private static boolean isSparse(int number) {
        while (number > 1) {
            if ((number & 3) == 3)
                return false;

            number >>= 1;
        }

        return true;
    }
}
