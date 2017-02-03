package gayle.treegraph.questions;

import gayle.treegraph.TreeNode;

/**
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 to create a binary search tree with minimal height.
 Hints: #19, #73, #116
 */
public class MinimalSearchTree {

    public static TreeNode<Integer> minimalTree(int[] input) {
        return createMinimalBST(input, 0, input.length-1);
    }

    private static TreeNode<Integer> createMinimalBST(int[] input, int start, int end) {
        if( end < start )
            return null;

        int mid = (start + end) / 2;
        TreeNode<Integer> node = new TreeNode<>(input[mid]);
        node.setLeft(createMinimalBST(input, start, mid -1));
        node.setRight(createMinimalBST(input, mid + 1, end));
        return node;
    }

}
