package gayle.bitmanipulation;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConversionTest {

    @Test
    public void conversion() {
        assertThat(Conversion.conversion(29, 15), is(2));
    }

}