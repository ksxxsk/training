package gayle.stackqueue;


public interface Queue<E> {

    void add(E element);

    boolean isEmpty();

    E remove();

    E peek();
}
