package gayle.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created on 1/31/2017.
 */
public class PalindromeTest {

    LinkedList<Integer> list1;
    LinkedList<Integer> list2;
    LinkedList<Integer> list3;

    @Before
    public void setUp() {
        list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(1);

        list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(2);
        list2.add(1);

        list3 = new LinkedList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
    }

    @Test
    public void isPalindromeInternal() throws Exception {
        assertThat(list1.isPalindrome(), is(true));
        assertThat(list2.isPalindrome(), is(true));
        assertThat(list3.isPalindrome(), is(false));
    }

}