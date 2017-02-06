package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new LinkedList<>();
        List<Integer> currentList = new LinkedList<>();

        helper(root, sum, currentList, paths);

        return paths;
    }

    private void helper(TreeNode root, int sum, List<Integer> currentList, List<List<Integer>> paths) {
        if(root == null)
            return;

        currentList.add(root.val);
        //we are in leaf
        if(root.left == null && root.right == null && root.val == sum) {
            paths.add(new LinkedList<Integer>(currentList));
        } else {
            helper(root.left, sum - root.val, currentList, paths);
            helper(root.right, sum - root.val, currentList, paths);
        }

        currentList.remove(currentList.size()-1);
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

        new PathSumII().pathSum(root, 22);
    }
}
