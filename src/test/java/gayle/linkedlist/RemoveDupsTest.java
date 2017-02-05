package gayle.linkedlist;

import gayle.linkedlist.questions.RemoveDups;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 1/30/2017.
 */
public class RemoveDupsTest {

    LinkedList<Integer> list;
    LinkedList<Integer> expected;

    @Before
    public void setUp() {
        initList();
        initExpected();
    }

    private void initExpected() {
        expected = new LinkedList<>();
        expected.add(1);
        expected.add(3);
        expected.add(2);
        expected.add(4);
    }

    private void initList() {
        list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(3);
    }

    @Test
    public void removeDupsSuperUneffiecient() throws Exception {
        RemoveDups.removeDupsSuperUneffiecient(list);
        assertListsAreEqual(list, expected);
    }

    @Test
    public void removeDupsWithIterator() throws Exception {
        RemoveDups.removeDupsWithIterator(list);
        assertListsAreEqual(list, expected);
    }

    @Test
    public void removeDupsListMethod() throws Exception {
        list.removeDups();
        assertListsAreEqual(list, expected);
    }

    @Test
    public void removeDupsListMethodNoAdditionalSpace() throws Exception {
        list.removeDupsWithoutExtraSpace();
        assertListsAreEqual(list, expected);
    }

    @Test
    public void removeDupsListMethodNoAdditionalSpace2() throws Exception {
        list.removeDupsWithoutExtraSpace2();
        assertListsAreEqual(list, expected);
    }


    private <T> void assertListsAreEqual(LinkedList<T> list, LinkedList<T> expected) {
        assertThat(list.size(), is(expected.size()));

        for (int i = 0; i < list.size(); i++)
            assertThat(list.get(i), equalTo(expected.get(i)));
    }

}