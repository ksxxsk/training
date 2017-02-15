package coursera.week2.stackqueue;

/**
 * Implement a queue with two stacks so that each queue operations takes a constant amortized number of stack
 * operations.
 *
 * @param <E>
 */
public class QueueWithStacks<E> implements Queue<E> {

    private final Stack<E> in;
    private final Stack<E> out;


    public QueueWithStacks() {
        in = new ArrayStack<>();
        out = new ArrayStack<>();
    }

    @Override
    public void enqueue(E element) {
        in.push(element);
    }

    @Override
    public E dequeue() {
        if(out.isEmpty()) {
            while(!in.isEmpty())
                out.push(in.pop());
        }
        return out.pop();
    }
}
