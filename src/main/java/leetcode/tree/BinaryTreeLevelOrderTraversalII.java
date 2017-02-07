package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level
 * by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>(queue.size());
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.peek();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);

                }
                levelList.add(queue.poll().val);
            }
            result.add(0, levelList);
        }

        return result;
    }

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        helper(root, 0, result);

        return result;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;

        if (result.size() == level)
            result.add(new LinkedList<>());

        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);
        result.get(result.size() - level - 1).add(root.val);
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

        List<List<Integer>> list = new BinaryTreeLevelOrderTraversalII().levelOrderRecursive(root);
        list.stream().forEach(System.out::println);
    }
}
