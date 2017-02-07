package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestElementInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
//        root.right = new TreeNode(2);
        root.left = new TreeNode(1);
        new KthSmallestElementInBST().kthSmallestRecursive(root, 1);
    }

    public int kthSmallest(TreeNode root, int k) {

        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (--k == 0)
                return node.val;

            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

        }

        return Integer.MAX_VALUE;
    }

    public int kthSmallestRecursive(TreeNode root, int k) {
        int[] result = new int[1];
        int[] refK = {k};
        kthSmallestRecursive(root, refK, result);
        return result[0];
    }

    private void kthSmallestRecursive(TreeNode root, int[] k, int[] result) {
        if (root.left != null)
            kthSmallestRecursive(root.left, k, result);

        if (--k[0] == 0) {
            result[0] = root.val;
            return;
        }
        if (root.right != null)
            kthSmallestRecursive(root.right, k, result);



    }
}
