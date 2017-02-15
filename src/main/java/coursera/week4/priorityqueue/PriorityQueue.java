package coursera.week4.priorityqueue;

/**
 * implementation   |insert |del max| max   |
 * ------------------------------------------
 * Unordered array  |   1   |   N   |   N   |
 * Ordered array    |   N   |   1   |   1   |
 * Binary heap      | log N | log N |   1   |
 * D-ary heap       |log_d_N|dlog_dN|   1   |
 * Fibonacci        |   1   | log N |   1   |
 */
public abstract class PriorityQueue<E extends Comparable<E>> {

    protected final E[] pq;
    private int size;

    public PriorityQueue(int capacity) {
        pq = (E[]) new Object[capacity + 1];
    }

    public void insert(E element) {
        pq[++size] = element;
        swim(size);
    }

    protected E delTop() {
        E max = pq[1];
        swap(1, size--);
        sink(1);
        pq[size + 1] = null;
        return max;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swim(int index) {
        while (index > 1 && cmp(index / 2, index)) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    private void sink(int index) {

        while (2 * index <= size) {
            int child = 2 * index;
            if (secondChildInHeap(child) && shouldTakeSecondChild(child, child + 1))
                child++;
            if (!cmp(index, child))
                break;
            swap(index, child);
            index = child;
        }
    }

    private boolean shouldTakeSecondChild(int child, int j) {
        return cmp(child, j);
    }

    private boolean secondChildInHeap(int child) {
        return child < size;
    }

    private void swap(int i, int j) {
        E temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    protected abstract boolean cmp(int i, int j);

}
