package geeksforgeeks;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ElementThatAppearsOnceTest {

    int[] oneThree = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
    int[] oneFour = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3, 12, 1, 3};
    int[] oneElement = {2};

    @Test
    public void appearsOnceAmongThoseWhichAppearsThreeTimes() {
        assertThat(ElementThatAppearsOnce.appearsOnceAmongThreeTimes(oneThree), is(2));
    }

    @Test
    public void appearsOnceSumBits() {
        assertThat(ElementThatAppearsOnce.appearsOnceSumBits(oneElement,3), is(2));
        assertThat(ElementThatAppearsOnce.appearsOnceSumBits(oneFour,4), is(2));
    }

}