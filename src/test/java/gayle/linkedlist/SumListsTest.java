package gayle.linkedlist;

import gayle.linkedlist.questions.SumLists;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created on 1/31/2017.
 */
public class SumListsTest {

    LinkedList<Integer> list1;
    LinkedList<Integer> list2;
    LinkedList<Integer> expected;

    @Before
    public void setUp() {
        list1 = new LinkedList<>();
        list1.add(7);
        list1.add(1);
        list1.add(6);

        list2 = new LinkedList<>();
        list2.add(5);
        list2.add(9);
        list2.add(2);

        expected = new LinkedList<>();
        expected.add(2);
        expected.add(1);
        expected.add(9);
    }

    private void assertListEquals(LinkedList<Integer> input, LinkedList<Integer> expected) {
        assertThat(input.size(), equalTo(expected.size()));

        for (int i = 0; i < input.size(); i++)
            assertThat(input.get(i), equalTo(expected.get(i)));
    }

    @Test
    public void sumListConvertToInteger() {
        assertListEquals(SumLists.sumListsConvertToInt(list1, list2), expected);
    }

}