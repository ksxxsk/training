package coursera.week3.quicksort;

/**
 * Duplicate keys
 *
 * Mistake: Put all items equal to the partitioning item on one side.
 * Consequence: ~1/2 N^2 compares when all keys are equal.
 *
 * Recommended: Stop scans on items equal to partitioning item.
 * Consequence: ~N lg N compares when all keys are equal - it will divide exactly in the middle
 *
 * Desirable: Put all items equal to the partitioning item in place - 3 way partitioning
 */
public class ThreeWayQuickSort {

    public void threeWayQuickSort(Comparable[] array, int lo, int hi) {
        if (hi <= lo)
            return;

        int lt = lo;
        int gt = hi;
        int i = lo;

        Comparable p = array[lo];
        while (i <= gt) {
            int cmp = array[i].compareTo(p);
            if (cmp < 0)
                QuickSort.swap(array, lt++, i++);
            else if (cmp > 0)
                QuickSort.swap(array, i, gt--);
            else
                i++;
        }

        threeWayQuickSort(array, lo, lt - 1);
        threeWayQuickSort(array, gt + 1, hi);
    }
}
