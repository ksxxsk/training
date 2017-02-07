package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>(queue.size());
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(levelList);
        }

        return result;
    }

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        helper(root, 0, result);

        return result;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> result) {
        if(root == null)
            return;

        if(result.size() == level)
            result.add(new LinkedList<>());

        result.get(level).add(root.val);
        helper(root.left, level+1, result);
        helper(root.right, level+1, result);
    }

}
