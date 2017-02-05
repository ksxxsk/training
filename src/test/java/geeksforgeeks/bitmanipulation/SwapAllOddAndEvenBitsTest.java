package geeksforgeeks.bitmanipulation;

import geeksforgeeks.bitmanipulation.SwapAllOddAndEvenBits;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SwapAllOddAndEvenBitsTest {

    @Test
    public void swap() {
        assertThat(SwapAllOddAndEvenBits.swapOddAndEven(23), is(43));
    }

}