package hackerrank.tree;

public class LowestCommonAnchestorBST {

    static Node lca(Node root, int v1, int v2) {
        if (v1 < root.data && v2 < root.data)
            return lca(root.left, v1, v2);
        else if (v1 > root.data && v2 > root.data)
            return lca(root.right, v1, v2);
        else
            return root;
    }

    static Node lca2(Node root, int v1, int v2) {
        if (root == null)
            return null;

        while (root != null) {
            if (v1 < root.data && v2 < root.data)
                root = root.left;
            else if (v1 > root.data && v2 > root.data)
                root = root.right;
            else
                return root;
        }

        return null;
    }

    class Node {

        int data;
        Node left;
        Node right;

    }
}
