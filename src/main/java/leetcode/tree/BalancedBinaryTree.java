package leetcode.tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 */
public class BalancedBinaryTree {

    /**
     * Return the height of the current node in DFS recursion. When the sub tree of the current node (inclusive) is
     * balanced, the function dfsHeight() returns a non-negative value as the height. Otherwise -1 is returned.
     * According to the leftHeight and rightHeight of the two children, the parent node could check if the sub tree is
     * balanced, and decides its return value.
     */
    public boolean isBalanced(TreeNode root) {

        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeigth = height(node.left);
        if (leftHeigth == -1)
            return -1;
        int rightHeight = height(node.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeigth - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeigth, rightHeight) + 1;

    }

}
