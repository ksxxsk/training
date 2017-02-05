package gayle.linkedlist.questions;

import gayle.linkedlist.LinkedList;

import java.util.Iterator;


/**
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in
 * reverse order, such that the 1 's digit is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list. EXAMPLE Input: (7 -> 1 -> 6) + (5 -> 9 -> 2) .Thatis,617 + 295. Output: 2 -> 1 ->
 * 9. That is, 912. FOLLOW UP Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE Input:
 * (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295. Output: 9 -> 1 -> 2. That is, 912. Hints: #7, #30, #71, #95, #109
 */
public class SumLists {

    public static LinkedList<Integer> sumListsConvertToInt(LinkedList<Integer> list1, LinkedList<Integer> list2) {

        int first = calculateNumberFromList(list1);
        int second = calculateNumberFromList(list2);

        String sum = String.valueOf(first + second);
        LinkedList<Integer> sumList = new LinkedList<>();

        for (int i = sum.length() - 1; i >= 0; i--)
            sumList.add(Character.digit(sum.charAt(i), 10));

        return sumList;
    }

    private static int calculateNumberFromList(LinkedList<Integer> list1) {
        Iterator<Integer> iterator = list1.iterator();
        int first = 0;
        for (int i = 1; iterator.hasNext(); i *= 10)
            first += iterator.next() * i;
        return first;
    }

    public static LinkedList<Integer> sumListsRecursive(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        return sumListRecursive(list1.getHead(), list2.getHead(), 0);
    }

    private static LinkedList<Integer> sumListRecursive(LinkedList<Integer>.Node<Integer> node1, LinkedList<Integer>.Node<Integer> node2, int carry) {

        int sum = node1.element + node2.element;
        if (sum > 10) {

        }

        return null;
    }
}
