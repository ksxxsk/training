package geeksforgeeks.bitmanipulation;

import geeksforgeeks.bitmanipulation.SumOfBitDifferencesAmongAllPairs;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SumOfBitDifferencesAmongAllPairsTest {

    int[] arr1 = {1, 2};
    int[] arr2 = {1, 3, 5};

    @Test
    public void naiveTest() {
        assertThat(SumOfBitDifferencesAmongAllPairs.naive(arr1), is(4));
        assertThat(SumOfBitDifferencesAmongAllPairs.naive(arr2), is(8));
    }

    @Test
    public void bitCount() {
        assertThat(SumOfBitDifferencesAmongAllPairs.bitCount(arr1), is(4));
        assertThat(SumOfBitDifferencesAmongAllPairs.bitCount(arr2), is(8));
    }

}