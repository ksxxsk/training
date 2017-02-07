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

    public List<Integer> inorderTraversalIterative3(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if(root != null)
            stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.right != null)
                stack.push(node.right);
            result.add(node.val);
            if(node.left != null)
                stack.push(node.left);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<Integer> list = new BinaryTreeInorder().inorderTraversalIterative3(root);
        list.forEach(System.out::println);
    }
}
