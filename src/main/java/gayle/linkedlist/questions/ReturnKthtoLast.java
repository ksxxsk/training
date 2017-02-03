package gayle.linkedlist.questions;

import gayle.linkedlist.LinkedList;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 Hints: #8, #25, #47, #67, # 726
 */
public class ReturnKthtoLast {

    public static <T> T withSize(LinkedList<T> list, int k) {
        return list.get(list.size() - k);
    }

    public static int withRecursion(LinkedList<Integer> list, int k) {
        return list.kThToLastRecursive(k);
    }

    public static <T> T iterative(LinkedList<T> list, int k) {
        return list.kThToLastIterative(k);
    }

}
