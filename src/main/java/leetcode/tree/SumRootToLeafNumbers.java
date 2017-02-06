package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        new SumRootToLeafNumbers().sumNumbersLintcode(root);
    }

    public int sumNumbers(TreeNode root) {
        int[] result = new int[1];
        helper(root, new StringBuilder(), result);

        return result[0];
    }

    private void helper(TreeNode root, StringBuilder num, int[] result) {
        if (root == null)
            return;

        num.append(root.val);
        //we are in leaf
        if (root.left == null && root.right == null) {
            result[0] += Integer.valueOf(num.toString());
        } else {
            helper(root.left, num, result);
            helper(root.right, num, result);
        }

        num.deleteCharAt(num.length()-1);
    }

    public int sumNumbersLintcode(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        int currentSum = 10 * sum + root.val;
        if(root.left == null && root.right == null)
            return currentSum;
        return sum(root.left, currentSum) + sum(root.right, currentSum);
    }


}
