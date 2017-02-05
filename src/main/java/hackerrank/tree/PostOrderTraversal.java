package hackerrank.tree;

public class PostOrderTraversal {


    void postOrder(PreorderTraversal.Node root) {
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    class Node {
        int data;
        PreorderTraversal.Node left;
        PreorderTraversal.Node right;
    }
}
