package leetcode.tree;

/**
 * Created on 2/6/2017.
 */
public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

}
