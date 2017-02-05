package gayle.linkedlist.questions;

import gayle.linkedlist.LinkedList;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e.,any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only
 * access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a ->b->c ->d->e->f
 * Result: nothing is returned, but the new linked list looks like a - >b->d- >e- >f
 * Hints: #l2
 */
public class DeleteMiddleNode {

    /**
     * The basic idea is to replace current node with next node and update pointers, to omit next node.
     * Node<E> next = n.next;
     * n.element = n.next
     * n.next = next.next;
     */
    public static <E> void deleteMiddleNode(LinkedList<E> list) {

    }
}
