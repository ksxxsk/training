package gayle.linkedlist.questions;

import gayle.linkedlist.LinkedList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list. FOLLOW UP How would you solve this problem
 * if a temporary buffer is not allowed? Hints: #9, #40
 */
public class RemoveDups {

    public static <T> void removeDupsSuperUneffiecient(LinkedList<T> list) {
        Set<T> set = new HashSet<T>();
        for (int i = 0; i < list.size(); i++) {
            T current = list.get(i);
            if (set.contains(current))
                list.remove(i--);
            else
                set.add(current);
        }
    }

    public static <T> void removeDupsWithIterator(LinkedList<T> list) {
        Set<T> set = new HashSet<T>();
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (set.contains(element))
                iterator.remove();
            else
                set.add(element);
        }
    }

}
