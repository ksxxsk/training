package coursera.week1.uf;

import java.util.stream.IntStream;

/**
 * Initialize: N, find: lg N, union: lg N
 * Starting from empty data structure any sequence of  M union find ops make N + M log N array accesses
 * (N + M lg * N with path compression)
 */
public class WeightedQuickUnion implements UF {

    private final int[] id;
    private final int[] size;

    public WeightedQuickUnion(int size) {
        this.id = new int[size];
        this.size = new int[size];

        IntStream.range(0, size - 1).forEach(i -> id[i] = i);
    }

    @Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if(rootP == rootQ)
            return;
        if(size[rootP] < size[rootQ]) {
            id[rootP] = id[rootQ];
            size[rootQ] += size[rootP];
        } else {
            id[rootQ] = id[rootP];
            size[rootP] += size[rootQ];
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; //path compression
            i = id[i];
        }
        return i;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
}
