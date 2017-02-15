package coursera.week1.uf;

import java.util.stream.IntStream;

/**
 * Initialize: N, find: N, union: N
 * Depends on the structure of tree, trees can be tall, find could be N array accesses
 * Starting from empty data structure any sequence of  M union find ops make NM array accesses
 * (N + M log N with path compression)
 */
public class QuickUnion implements UF {

    private final int[] id;

    public QuickUnion(int size) {
        this.id = new int[size];

        IntStream.range(0, size - 1).forEach(i -> id[i] = i);
    }

    @Override
    public void union(int p, int q) {
        id[root(p)] = root(q);
    }

    private int root(int i) {
        while (i != id[i])
            i = id[i];

        return i;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
}
