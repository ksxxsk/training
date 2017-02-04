package gayle.bitmanipulation;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FlipBitToWinTest {

    @Test
    public void countOnes() {
        assertThat(FlipBitToWin.countOnes2(1775), is(8));
    }

}