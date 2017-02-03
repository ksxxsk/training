package gayle.treegraph.questions;

import gayle.treegraph.TreeNode;

/**
 * Write an algorithm to find the "next" node (i .e., in-order successor) of a given node in a
 binary search tree. You may assume that each node has a link to its parent.
 Hints: #79, #91

 CLRS: If all keys are distinct, the successor of a node x is the node with the smallest key greater than x.key.
 */
public class Successor {

    public static <E> TreeNode<E> successor(TreeNode<E> node) {
        if(nodeHasRightChild(node)) {
            return leftmostElement(node.getRight());
        } else {
            return lowestAncestorWhoseLeftChildIsAnchestorOfNode(node);
        }
    }

    private static <E> TreeNode<E> lowestAncestorWhoseLeftChildIsAnchestorOfNode(TreeNode<E> node) {
        TreeNode<E> parent = node.getParent();
        TreeNode<E> successor = node;
        while ( parent != null && parent.getRight() == successor ) {
            successor = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    private static <E> boolean nodeHasRightChild(TreeNode<E> node) {
        return node.getRight() != null;
    }

    private static <E> TreeNode<E> leftmostElement(TreeNode<E> successor) {
        while (successor.getLeft() != null)
            successor = successor.getLeft();

        return successor;
    }
}
