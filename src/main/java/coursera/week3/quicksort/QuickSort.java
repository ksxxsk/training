package coursera.week3.quicksort;


import java.util.Random;

/**
 * Best case - quicksort will divide array exactly in half, in this case number of compares ~N lg N
 * <p>
 * Worst case - when random shuffle puts items exactly in order partition doesn't do anything apart from finding
 * smallest item - discovers that everything on the right is greater. In this case number of compares is ~1/2N^2. With
 * random shuffle it's extremely unlikely to happen.
 * <p>
 * Average case - number of compares to quicksort an array of N distinct keys is ~2N ln N - 1.39N lg N: 39% more
 * compares than mergesort, but faster than mergesort in practice because of less data movement (sorting in place)
 *
 * Quicksort goes quadratic unless partitioning stops on equal keys; 1990s C user found this defect in qsort()
 */
public class QuickSort {

    private static final int CUTOFF = 8;

    public static void quickSort(Comparable[] array) {
        shuffle(array);
        quickSort(array, 0, array.length - 1);
    }

    public static void shuffle(Object[] array) {
        Random r = new Random();

        for (int i = 1; i < array.length; i++)
            swap(array, i, r.nextInt(i));

    }

    private static void quickSort(Comparable[] array, int lo, int hi) {
        if (hi <= lo + CUTOFF - 1) {
            insertionSort(array, lo, hi);
            return;
        }
        int m = median3(array, lo, lo + (hi - lo) / 2, hi);
        swap(array, lo, m);

        int p = partition(array, lo, hi);
        quickSort(array, lo, p - 1);
        quickSort(array, p + 1, hi);
    }

    private static int median3(Comparable[] array, int i, int j, int k) {
        return less(array[i], array[j]) ?
                (less(array[j], array[k]) ? j : less(array[i], array[k]) ? k : i) :
                (less(array[k], array[j]) ? j : less(array[k], array[i]) ? k : i);
    }

    private static void insertionSort(Comparable[] array, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(array[j], array[j - 1]); j--)
                swap(array, j, j - 1);
    }

    public static int partition(Comparable[] array, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(array[i++], array[lo]))
                if (i == hi)
                    break;
            while (less(array[lo], array[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;

            swap(array, i, j);
        }

        swap(array, lo, j);

        return j;
    }

    public static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static boolean less(Comparable first, Comparable second) {
        return first.compareTo(second) < 0;
    }


}
