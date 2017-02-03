package gayle.linkedlist;

import gayle.linkedlist.questions.ReturnKthtoLast;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created on 1/30/2017.
 */
public class ReturnKthtoLastTest {

    LinkedList<Integer> list;

    @Before
    public void setUp() {
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
    public void withSize() {
        assertThat(ReturnKthtoLast.withSize(list, 1), is(3));
        assertThat(ReturnKthtoLast.withSize(list, 2), is(1));
        assertThat(ReturnKthtoLast.withSize(list, 4), is(2));
    }

    @Test
    public void withRecursion() {
//        assertThat(ReturnKthtoLast.withRecursion(list1, 1), is(3));
//        assertThat(ReturnKthtoLast.withRecursion(list1, 2), is(1));
        assertThat(ReturnKthtoLast.withRecursion(list, 4), is(2));
    }

    @Test
    public void iterative() {
        assertThat(ReturnKthtoLast.iterative(list, 1), is(3));
        assertThat(ReturnKthtoLast.iterative(list, 2), is(1));
        assertThat(ReturnKthtoLast.iterative(list, 4), is(2));
    }
}