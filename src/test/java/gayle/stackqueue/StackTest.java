package gayle.stackqueue;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 30.01.2017.
 */
public class StackTest {

    private final Stack<Integer> stack = new Stack<>();

    @Test
    public void emptyStack_SizeIsZero() {
        assertThat(stack.size(), is(0));
    }

    @Test
    public void whenPushOneElement_SizeIsOne() {
        stack.push(1);
        assertThat(stack.size(), is(1));
    }

    @Test
    public void whenPushElements_SizeIncreases() {
        stack.push(1);
        stack.push(1);
        stack.push(1);
        assertThat(stack.size(), is(3));
    }

    @Test
    public void whenPushOne_PopReturnsOne() {
        stack.push(1);
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenPushTwo_PopReturnsTwo() {
        stack.push(2);
        assertThat(stack.pop(), is(2));
    }

    @Test
    public void whenPushAndPop_SizeisZero() {
        stack.push(1);
        stack.pop();
        assertThat(stack.size(), is(0));
    }

    @Test
    public void whenPushTwoElemementsPopOnce_SizeIsOne() {
        stack.push(1);
        stack.push(1);
        stack.pop();
        assertThat(stack.size(), is(1));
    }

    @Test
    public void whenSizeIsZero_IsEmptyReturnTrue() {
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void whenPushElement_IsEmptyReturnsFalse() {
        stack.push(1);
        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void whenPushTwoElementsPopOnce_IsEmptyReturnsFalse() {
        stack.push(1);
        stack.push(1);
        stack.pop();
        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void whenPushOncePopOnce_IsEmptyReturnsTrue() {
        stack.push(1);
        stack.pop();
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void whenPushOneTwo_PopReturnsInReverseOrder() {
        stack.push(1);
        stack.push(2);
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenPushOne_PeekReturnsOne() {
        stack.push(1);
        assertThat(stack.peek(), is(1));
    }

    @Test
    public void whenPushTwoElements_PeekReturnsLast() {
        stack.push(1);
        stack.push(2);
        assertThat(stack.peek(), is(2));
    }
}
