package gayle.stackqueue.questions;


import gayle.stackqueue.Queue;
import gayle.stackqueue.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 Hints: #98, #114
 */
public class TwoStackQueue<E> implements Queue<E> {

    private final Stack<E> in;
    private final Stack<E> out;


    public TwoStackQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    @Override
    public void add(E element) {
        in.push(element);
    }

    @Override
    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    @Override
    public E remove() {
        popFromInPushToOut();

        return out.pop();
    }

    private void popFromInPushToOut() {
        if(out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());
    }

    @Override
    public E peek() {
        popFromInPushToOut();

        return out.peek();
    }
}
