package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Find the sum of all left leaves in a given binary tree.
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.left != null)
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else
                sum += sumOfLeftLeaves(root.left);

        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    public int sumOfLeftLeavesIterative(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if(node.left != null)
                if(node.left.left == null && node.left.right == null)
                    sum += node.left.val;
                else
                    stack.push(node.left);

            if(node.right != null)
                stack.push(node.right);
        }

        return sum;
    }

}
