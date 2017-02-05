package geeksforgeeks.bitmanipulation;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NextSparseNumberTest {

    @Test
    public void naive() {
        assertThat(NextSparseNumber.naive(6), is(8));
        assertThat(NextSparseNumber.naive(4), is(4));
        assertThat(NextSparseNumber.naive(38), is(40));
        assertThat(NextSparseNumber.naive(44), is(64));
    }

}