package geeksforgeeks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TotalSetBitsInAllNumbersFrom1ToNTest {

    @Test
    public void naive() {
        assertThat(TotalSetBitsInAllNumbersFrom1ToN.naive(3), is(4));
        assertThat(TotalSetBitsInAllNumbersFrom1ToN.naive(6), is(9));
        assertThat(TotalSetBitsInAllNumbersFrom1ToN.naive(7), is(12));
        assertThat(TotalSetBitsInAllNumbersFrom1ToN.naive(8), is(13));
    }

}