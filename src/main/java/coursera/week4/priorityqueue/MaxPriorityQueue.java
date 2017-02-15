package coursera.week4.priorityqueue;


public class MaxPriorityQueue<E extends Comparable<E>> extends PriorityQueue<E> {


    public MaxPriorityQueue(int capacity) {
        super(capacity);
    }

    public E delMax() {
        return delTop();
    }

    @Override
    protected boolean cmp(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
}
