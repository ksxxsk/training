package gayle.treegraph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created on 2/2/2017.
 */
public class TreeTraversal {
    public static <E> void inOrder(TreeNode<E> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getElement());
            inOrder(node.getRight());
        }
    }

    public static <E> void inOrderIterative(TreeNode<E> root) {
        Deque<TreeNode<E>> stack = new LinkedList<>();

        TreeNode<E> node = root;
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }

        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println(node.getElement());
            while (node.getRight() != null) {
                node = node.getRight();

                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
            }
        }
    }

    public static <E> void inOrderIterative2(TreeNode<E> root) {

    }

    public static <E> void preOrder(TreeNode<E> node) {
        if (node != null) {
            System.out.println(node.getElement());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public static <E> void postOrder(TreeNode<E> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.getElement());
        }
    }
}
