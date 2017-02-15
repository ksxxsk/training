package hackerrank.heap;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * The median of a set of integers is the midpoint value of the data set for which an equal number of integers are less
 * than and greater than the value.
 * <p>
 * After each new integer is added to the list, print the list's updated median on a new line as a single
 * double-precision number scaled to  decimal place (i.e.,  format).
 */
public class FindTheRunningMedian {

    public static void main(String[] args) {
        String[] s = {"1", "2", "3"};
        reverse(s);
        Arrays.stream(s).forEach(System.out::println);

        System.out.println(3/2);
    }

    public static <T> void reverse(T[] array) {
        if( array == null || array.length < 2 )
            return;
        IntStream.range(0, array.length / 2).forEach(i -> {
            T tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        });
    }
}
