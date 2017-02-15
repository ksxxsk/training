package coursera.week3.quicksort;

/**
 * Given an array of N items, find the kth largest.
 * <p>
 * Quick - select:
 * takes linear time on average.
 * 1/2 N^2 compares in the worst case, but similar to quicksort the random shuffle provides a probabilistic guarantee.
 */
public class Selection {

    public static <T extends Comparable<T>> T selection(T[] array, int k) {
        QuickSort.shuffle(array);
        int lo = 0;
        int hi = array.length - 1;

        while (hi > lo) {
            int p = QuickSort.partition(array, lo, hi);
            if (p < k)
                lo = p + 1;
            else if (p > k)
                hi = p - 1;
            else
                return array[k];
        }

        return array[k];
    }
}
