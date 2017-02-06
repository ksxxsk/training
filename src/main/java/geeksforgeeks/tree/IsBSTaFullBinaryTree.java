package geeksforgeeks.tree;

/**
 * A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. Conversely,
 * there is no node in a full binary tree, which has one child node
 */
public class IsBSTaFullBinaryTree {

    public static boolean isAFullBST(Node root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;

        if(root.left != null && root.right != null)
            return isAFullBST(root.left) && isAFullBST(root.right);

        //one child is null second is not null
        return false;
    }


    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

}
