package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        paths(root, list, "");
        return list;
    }

    private void paths(TreeNode root, List<String> list, String path) {
        if (root == null)
            return;
        //we are in leaf
        if (root.left == null && root.right == null)
            list.add(path + root.val);

        if (root.left != null)
            paths(root.left, list, path + root.val + "->");
        if (root.right != null)
            paths(root.right, list, path + root.val + "->");

    }

    private List<String> binaryTreePathsIterative(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if(root == null)
            return paths;

        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<String> pathStack = new LinkedList<>();

        nodeStack.push(root);
        pathStack.push(root.val+"");

        while(!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            String currentPath = pathStack.pop();

            if(currentNode.left == null && currentNode.right == null)
                paths.add(currentPath);
            else {
                if(currentNode.left != null) {
                    nodeStack.push(currentNode.left);
                    pathStack.push(currentPath + "->" + currentNode.left.val);
                }

                if(currentNode.right != null) {
                    nodeStack.push(currentNode.right);
                    pathStack.push(currentPath + "->" + currentNode.right.val);
                }
            }
        }

        return paths;
    }

}
