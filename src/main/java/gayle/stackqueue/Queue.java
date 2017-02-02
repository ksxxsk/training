package gayle.stackqueue;

/**
 * Created on 31.01.2017.
 */
public interface Queue<E> {

    void add(E element);

    boolean isEmpty();

    E remove();

    E peek();
}
