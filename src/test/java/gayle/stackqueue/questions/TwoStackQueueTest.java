package gayle.stackqueue.questions;

import gayle.stackqueue.Queue;
import gayle.stackqueue.questions.TwoStackQueue;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class TwoStackQueueTest {

    private final Queue<Integer> queue = new TwoStackQueue<>();

    @Test
    public void whenNewStack_IsEmptyTrue() {
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void whenAddElement_StackIsNotEmpty() {
        queue.add(1);
        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    public void whenAddAndRemoveOnce_StackIsEmpty() {
        queue.add(1);
        queue.remove();
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void whenAddTwoRemoveOne_StackIsNotEmpty() {
        queue.add(1);
        queue.add(1);
        queue.remove();
        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    public void whenAddOne_RemoveReturnsOne() {
        queue.add(1);
        assertThat(queue.remove(), is(1));
    }

    @Test
    public void whenAddTwo_RemoveReturnsTwo() {
        queue.add(2);
        assertThat(queue.remove(), is(2));
    }

    @Test
    public void whenAddOneTwo_RemoveReturnsInTheSameOrder() {
        queue.add(1);
        queue.add(2);
        assertThat(queue.remove(), is(1));
        assertThat(queue.remove(), is(2));
    }

    @Test
    public void whenAddOne_PeekReturnsOne() {
        queue.add(1);
        assertThat(queue.peek(), is(1));
    }

    @Test
    public void whenAddTwoElements_PeekReturnsFirst() {
        queue.add(1);
        queue.add(2);
        assertThat(queue.peek(), is(1));
    }
}
