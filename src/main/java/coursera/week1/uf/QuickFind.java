package coursera.week1.uf;

import java.util.stream.IntStream;

/**
 * Initialize: N, find: 1, union: N
 */
public class QuickFind implements UF {

    private final int[] id;

    public QuickFind(int size) {
        this.id = new int[size];

        IntStream.range(0, size - 1).forEach(i -> id[i] = i);
    }

    @Override
    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];

        for (int i=0; i<id.length; i++)
            if(id[i] == pId)
                id[i] = qId;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}
