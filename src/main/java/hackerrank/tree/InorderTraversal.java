package hackerrank.tree;

public class InorderTraversal {
    void inOrder(PreorderTraversal.Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    class Node {
        int data;
        PreorderTraversal.Node left;
        PreorderTraversal.Node right;
    }
}
