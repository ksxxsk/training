package gayle.treegraph.questions;

import gayle.treegraph.TreeNode;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 Hints: #35, #57, #86, # 113, # 128
  */
public class ValidateBST {

    public static <E extends Comparable> boolean validateBST(TreeNode<E> root) {
        return validateBST(root, null, null);
    }

    private static <E extends Comparable> boolean validateBST(TreeNode<E> node, E min, E max) {
        if(node == null)
            return true;
        if(elementGreaterThan(node, min)
            && elementLessThan(node, max)
            && validateBST(node.getLeft(), min, node.getElement())
            && validateBST(node.getRight(), node.getElement(), max))
            return true;
        else
            return false;
    }

    private static <E extends Comparable> boolean elementGreaterThan(TreeNode<E> node, E min) {
        return min !=  null && node.getElement().compareTo(min) > 0;
    }

    private static <E extends Comparable> boolean elementLessThan(TreeNode<E> node, E max) {
        return max != null && node.getElement().compareTo(max) <= 0;
    }

    public static <E extends Comparable> boolean validateBSTIterative(TreeNode<E> root) {

        return false;
    }
}
