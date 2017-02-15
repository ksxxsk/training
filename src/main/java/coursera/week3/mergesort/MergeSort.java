package coursera.week3.mergesort;

import java.util.stream.IntStream;

public class MergeSort {

    private static final int SYSTEM_ARRAYCOPY_THRESHOLD = 6;

    public static <T extends Comparable<T>> void sortIterative(T[] array) {
        Comparable[] aux = new Comparable[array.length];

        for (int size = 1; size < array.length; size *= 2)
            for (int start = 0; start < array.length - 1; start += 2 * size) {
                int mid = start + size - 1;
                if(!arrayIsSorted(array, mid))
                    merge(array, aux, start, mid, Math.min(start + 2 * size, array.length - 1));
            }

    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array, new Comparable[array.length], 0, array.length - 1);
    }

    protected static <T extends Comparable<T>> void sort(T[] array, T[] aux, int lo, int hi) {
        if (hi <= lo)
            return;

        int mid = (lo + (hi - lo)) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        if (arrayIsSorted(array, mid))
            return;
        merge(array, aux, lo, mid, hi);
    }

    private static <T extends Comparable<T>> boolean arrayIsSorted(T[] array, int mid) {
        return !lessThan(array[mid + 1], array[mid]);
    }

    /**
     * Precondition: array[lo..mid] is sorted & array[mid+1..hi] is sorted
     *
     * @return sorted array[lo..hi]
     */
    protected static <T extends Comparable<T>> void merge(T[] array, T[] aux, int lo, int mid, int hi) {
        copyArray(array, aux, lo, hi);

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                array[k] = aux[j++];
            else if (j > hi)
                array[k] = aux[i++];
            else {
                if (lessThan(aux[j], aux[i]))
                    array[k] = aux[j];
                else
                    array[k] = aux[j];
            }
        }
    }

    protected static <T extends Comparable<T>> void merge2(T[] array, T[] aux, int lo, int mid, int hi) {
        copyArray(array, aux, lo, hi);

        int i = lo;
        int j = mid + 1;
        int k = 0;
        while ( i <= mid && j<= hi) {
            if(lessThan(aux[j], aux[i]))
                array[k++] = aux[j++];
            else
                array[k++] = aux[i++];
        }

        while (i <= mid)
            array[k++] = array[i++];

        while (j <= hi)
            array[k++] = array[j++];


    }

    private static <T extends Comparable<T>> boolean lessThan(T first, T second) {
        return first.compareTo(second) < 0;
    }

    private static <T extends Comparable<T>> void copyArray(T[] src, T[] dst, int start, int end) {
        if (end - start < SYSTEM_ARRAYCOPY_THRESHOLD)
            IntStream.range(start, end).forEach(i -> dst[i] = src[i]);
        else
            System.arraycopy(src, start, dst, start, end - start);
    }
}
