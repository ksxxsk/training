package gayle.linkedlist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LinkedList<E> implements Iterable<E> {


    private int size;
    private Node head;
    private Node tail;

    public int size() {
        return size;
    }

    public void add(E element) {
        Node oldLast = tail;
        Node node = new Node(null, element);
        tail = node;
        if( head == null )
            head = node;
        else
            oldLast.next = node;
        size++;
    }

    public E get(int index) {
        checkIndex(index);

        Node<E> node = head;
        for(int i=0; i<index; i++)
            node = node.next;

        return node.element;
    }

    private void checkIndex(int index) {
        if(index > size - 1)
            throw new IndexOutOfBoundsException();
    }

    public void remove(int index) {
        checkIndex(index);

        Node parent = head;
        for(int i=0; i<index-1; i++)
            parent = parent.next;

        Node toRemove = parent.next;
        Node newChild = toRemove.next;
        toRemove.element = null;
        if( newChild != null) {
            parent.next = newChild;
        }

        size--;
    }

    public void removeDups() {
        Set<E> set = new HashSet<>();

        Node<E> previous = null;
        Node<E> node = head;
        while(node != null) {
            if(set.contains(node.element)) {
                previous.next = node.next;
                size--;
            }
            else {
                set.add(node.element);
                previous = node;
            }
            node = node.next;
        }
    }


    public void removeDupsWithoutExtraSpace() {
        Node node = head;
        while (node != null) {
            Node previous = node;
            Node next = node.next;

            while (next != null) {
                if(node.element.equals(next.element)) {
                    previous.next = next.next;
                    size--;
                } else {
                    previous = next;
                }
                next = next.next;
            }

            node = node.next;
        }
    }

    public void removeDupsWithoutExtraSpace2() {
        Node node = head;
        while (node != null) {
            Node runner = node;
            while (runner.next != null) {
                if(runner.next.element.equals(node.element)) {
                    runner.next = runner.next.next;
                    size--;
                } else
                    runner = runner.next;
            }
            node = node.next;
        }
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator<E>();
    }

    public E kThToLastRecursive(int k) {
        int[] index = new int[1];
        Node<E> result = kThToLastRecursive(head, k, index);
        return result.element;
    }

    private Node<E> kThToLastRecursive(Node<E> head, int k, int[] index) {
        if (head == null)
            return null;

        Node<E> node = kThToLastRecursive(head.next, k, index);
        index[0] = index[0] + 1;
        if(index[0] == k)
            return head;

        return node;
    }

    public E kThToLastIterative(int k) {
        Node<E> kIndex = head;
        Node<E> index = head;

        for(int i=0; i<k; i++)
            kIndex = kIndex.next;

        while(kIndex != null) {
            kIndex = kIndex.next;
            index = index.next;
        }

        return index.element;
    }

    public Node<E> getHead() {
        return head;
    }

    public boolean isPalindrome() {
        Node<E> first = head;
        Node<E> second = head;


        return false;
    }

    public class Node<T> {

        public Node<T> next;
        public T element;

        Node(Node<T> next, T element) {

            this.next = next;
            this.element = element;
        }
    }

    class LinkedListIterator<T> implements Iterator<T> {

        private int index;
        private Node<T> lastReturned = null;
        private Node<T> current = null;
        private Node<T> previous = null;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if(index == 0)
                lastReturned = head;
            else {
                previous = lastReturned;
                lastReturned = current;
            }

            current = lastReturned.next;
            index++;

            return lastReturned.element;
        }

        @Override
        public void remove() {
            if(hasNext())
                if(index == 1)
                    head = current;
                else
                    previous.next = current;

            size--;
            index--;

        }
    }
}
