package coursera.week4.priorityqueue;


/**
 * Heap construction uses <= 2N compares and exchanges Heapsort uses <= 2N lg N compares and exchanges.
 * <p>
 * In-place sorting algorithm with N log N worst case.
 * <p>
 * Not often used in practice because of:
 * <li>inner loop longer than quicksort's -
 * there is more things to do in inner loop, need to compare two childrens + made index artithmetics</li>
 * <li>makes poor use of cache memory - it doesn't have local memory references like quicksort. Quicksort always refer
 * ring to something that's nearby something else that it just referred to. So if big block comes into memory there is
 * no extra cost, where is heapsort going to look far away from a current place as it goes down the tree and this makes it slower in a lot of situations.</li>
 * <li>not stable</li>
 */
public class Heapsort {

    public static void sort(Comparable[] array) {
        int N = array.length;
        for(int k = N / 2; k >=1; k--)
            sink(array, k, N);

        while (N > 1) {
            swap(array, 1, N);
            sink(array, 1, -N);
        }
    }

    private static void swap(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void sink(Comparable[] array, int i, int i1) {
    }
}
