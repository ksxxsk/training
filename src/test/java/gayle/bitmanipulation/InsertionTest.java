package gayle.bitmanipulation;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InsertionTest {

    @Test
    public void insertion() {
        assertThat(Insertion.insert(10100, 100, 8, 14), is(25716));
    }

    @Test
    public void insertionNegativeNumber() {
        assertThat(Insertion.insert(-521,0,31,31), is(2147483127));
    }

}