package coursera.week3.mergesort.quiz;

/**
 * Suppose that the subarray a[0] to a[n−1] is sorted and the subarray a[n] to a[2∗n−1] is sorted. How can you merge the
 * two subarrays so that a[0] to a[2∗n−1] is sorted using an auxiliary array of length n (instead of 2n)?
 */
public class MergingWithSmallerAuxiliaryArray {

    public static <T extends Comparable<T>> void merge(T[] a, T[] aux, int n) {
        System.arraycopy(a, 0, aux, 0, n);

        for (int i = 0; i < n; i++) {
            if (lessThan(a[n+i],aux[i]))
                a[i] = a[n+1];
            else
                a[i] = aux[n+i];
        }
    }

    private static <T extends Comparable<T>> boolean lessThan(T first, T second) {
        return first.compareTo(second) < 0;
    }
}
