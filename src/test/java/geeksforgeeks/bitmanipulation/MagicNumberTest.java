package geeksforgeeks.bitmanipulation;

import geeksforgeeks.bitmanipulation.MagicNumber;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MagicNumberTest {

    @Test
    public void magicNumbers() {
        assertThat(MagicNumber.findNthMagicNumber(0), is(0));
        assertThat(MagicNumber.findNthMagicNumber(1), is(5));
        assertThat(MagicNumber.findNthMagicNumber(3), is(30));
        assertThat(MagicNumber.findNthMagicNumber(5), is(130));
    }
}