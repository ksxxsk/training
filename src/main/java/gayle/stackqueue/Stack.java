package gayle.stackqueue;


public class Stack<E> {

    private Node head;
    private int size = 0;

    public int size() {
        return size;
    }

    public void push(E element) {
        if(head == null)
            head = new Node(null, element);
        else
            head = new Node(head, element);

        size++ ;
    }

    public E pop() {
        size--;
        E element = head.element;
        head.element = null;
        head = head.next;

        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        return head.element;
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }

    private class Node {

        private Node next;
        private E element;

        Node(Node next, E element) {

            this.next = next;
            this.element = element;
        }
    }
}
