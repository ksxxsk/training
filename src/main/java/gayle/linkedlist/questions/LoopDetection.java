package gayle.linkedlist.questions;

import gayle.linkedlist.LinkedList;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
 * as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C[thesameCasearlierl
 * Output: C
 * Hints: #50, #69, #83, #90
 */
public class LoopDetection {

    /**
     * <a href="https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare">Floyd's cycle-finding algorithm</a>
     */
    public static <E> boolean hasACycle(LinkedList<E> linkedList) {
        LinkedList<E>.Node<E> tortoise = linkedList.getHead();
        LinkedList<E>.Node<E> hare = linkedList.getHead();

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare)
                return true;
        }

        return false;
    }
}
