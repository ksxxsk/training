package coursera.week2.stackqueue;

public class ArrayStack<E> implements Stack<E> {

    private E[] array;
    private int size = 0;


    public ArrayStack() {
        array = (E[]) new Object[1];
    }

    @Override
    public void push(E element) {
        if (size == array.length)
            increaseArray();
        array[size++] = element;
    }

    private void increaseArray() {
        E[] resized = (E[]) new Object[array.length * 2];
        System.arraycopy(array, 0, resized, 0, array.length);
        array = resized;
    }

    @Override
    public E pop() {
        if (size == array.length / 4)
            decreaseSize();
        return array[--size];
    }

    @Override
    public E peek() {
        return array[size];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void decreaseSize() {
        E[] resized = (E[]) new Object[array.length / 2];
        System.arraycopy(array, 0, resized, 0, array.length);
        array = resized;
    }
}
