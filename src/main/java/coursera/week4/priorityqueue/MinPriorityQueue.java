package coursera.week4.priorityqueue;


public class MinPriorityQueue<E extends Comparable<E>> extends PriorityQueue<E> {

    public MinPriorityQueue(int capacity) {
        super(capacity);
    }

    public E delMin() {
        return delTop();
    }

    @Override
    protected boolean cmp(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }
}
