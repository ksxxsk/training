package gayle.stackqueue.questions;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StackMinTest {

    @Test
    public void testMins() {
        StackMin<Integer> stack = new StackMin<>();
        stack.push(7);
        stack.push(4);
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        assertThat(stack.min(), is(1));

        stack.pop();
        assertThat(stack.peek(), is(2));
        assertThat(stack.min(), is(1));

        stack.pop();
        stack.pop();
        stack.pop();
        assertThat(stack.peek(), is(5));
        assertThat(stack.min(), is(4));
    }

}