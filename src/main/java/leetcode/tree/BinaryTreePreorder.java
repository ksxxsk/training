package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePreorder {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null)
            return result;
        preorderTraversal(root, result);

        return result;
    }

    private void preorderTraversal(TreeNode root, List<Integer> result) {
        result.add(root.val);
        if(root.left != null)
            preorderTraversal(root.left, result);
        if(root.right != null)
            preorderTraversal(root.right, result);
    }

    public List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if(root != null)
            stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }

        return result;
    }
}
