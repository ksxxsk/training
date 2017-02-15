package coursera.week1.uf;

public interface UF {

    void union(int p, int q);

    boolean isConnected(int p, int q);
}
