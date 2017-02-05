package gayle.linkedlist;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 1/30/2017.
 */
public class LinkedListTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private LinkedList list;


    @Before
    public void setUp() throws Exception {
        list = new LinkedList();
    }

    @Test
    public void whenListIsEmpty_SizeIsZero() {
        assertThat(list.size(), is(0));
    }

    @Test
    public void whenAddOneElement_SizeIsOne() {
        list.add(1);
        assertThat(list.size(), is(1));
    }

    @Test
    public void whenAddTwoElements_SizeIsTwo() {
        list.add(1);
        list.add(2);
        assertThat(list.size(), is(2));
    }

    @Test
    public void whenAddOne_GetFirstReturnOne() {
        list.add(1);
        assertThat(list.get(0), is(1));
    }

    @Test
    public void whenAddTwo_GetFirstReturnTwo() {
        list.add(2);
        assertThat(list.get(0), is(2));
    }

    @Test
    public void whenAddOneTwo_GetReturnsOneTwo() {
        list.add(1);
        list.add(2);
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenGetElementGreaterThanSize_ThrowException() {
        exception.expect(IndexOutOfBoundsException.class);
        list.add(1);
        list.get(1);
    }

    @Test
    public void whenRemoveOneElement_SizeDecreases() {
        list.add(1);
        list.add(1);
        list.remove(1);
        assertThat(list.size(), is(1));
    }

    @Test
    public void whenRemoveOneElement_NextElementTakesItsPlace() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertThat(list.get(1), is(3));
    }

    @Test
    public void whenRemoveElementWithIndexGreaterThanSize_ThrowException() {
        exception.expect(IndexOutOfBoundsException.class);
        list.add(1);
        list.remove(2);
    }
}
