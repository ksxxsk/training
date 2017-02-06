package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null)
            return result;
        inorderTraversal(root, result);

        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root.left != null)
            inorderTraversal(root.left, result);

        result.add(root.val);

        if (root.right != null)
            inorderTraversal(root.right, result);

    }

    private List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return result;
    }

    public List<Integer> inorderTraversalIterative2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;
    }
}
