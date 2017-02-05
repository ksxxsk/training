package gayle.stackqueue.questions;

import gayle.stackqueue.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 * Hints: #15, #32, #43
 */
public class SortStack {

    public static <E extends Comparable> void sort(Stack<E> stack) {
        Stack<E> temp = new Stack<E>();

        temp.push(stack.pop());
        E element = stack.pop();

        while (!stack.isEmpty()) {
            int counter = 0;
            while (!temp.isEmpty() && element.compareTo(temp.peek()) < 0) {
                stack.push(temp.pop());
                counter++;
            }

            temp.push(element);
            while (counter > 0) {
                temp.push(stack.pop());
                counter--;
            }

            element = stack.pop();
        }

        while (!temp.isEmpty())
            stack.push(temp.pop());

    }

    public static <E extends Comparable> void sort2(Stack<E> stack) {
        Stack<E> temp = new Stack<E>();
        while (!stack.isEmpty()) {
            E element = stack.pop();
            while (!temp.isEmpty() && element.compareTo(temp.peek()) < 0)
                stack.push(temp.pop());

            temp.push(element);
        }

        while (!temp.isEmpty())
            stack.push(temp.pop());
    }
}
