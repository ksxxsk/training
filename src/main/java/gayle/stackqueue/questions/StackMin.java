package gayle.stackqueue.questions;

import gayle.stackqueue.Stack;

/**
 * How would you design a stack which, in addition to push and pop, has a function min
 which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 Hints: #27, #59, #78
 */
public class StackMin<E extends Comparable> extends Stack<E> {

    private Stack<E> minValues = new Stack<E>();

    @Override
    public void push(E element) {
        if(minValues.isEmpty() || minValues.peek().compareTo(element) >= 0)
            minValues.push(element);

        super.push(element);
    }

    @Override
    public E pop() {
        E element = super.pop();
        if(minValues.peek() == element)
            minValues.pop();

        return element;
    }

    public E min() {
        return minValues.peek();
    }
}
