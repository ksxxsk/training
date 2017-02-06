package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorder {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root.left != null)
            postorderTraversal(root.left, result);


        if (root.right != null) {
            postorderTraversal(root.right, result);
        }

        result.add(root.val);
    }
}
