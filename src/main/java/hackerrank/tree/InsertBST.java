package hackerrank.tree;

public class InsertBST {

    static Node Insert(Node root, int value) {
        if (root == null) {
            root = new Node();
            root.data = value;
            return root;
        }

        if (value < root.data)
            root.left = Insert(root.left, value);
        else if (value > root.data)
            root.right = Insert(root.right, value);
        else {
            root.data = value;
        }
        return root;
    }

    static Node Insert2(Node root, int value) {
        if (root == null) {
            root = new Node();
            root.data = value;
            return root;
        }
        Node current = root;

        while (current != null) {
            if (value < current.data)
                if (current.left != null)
                    current = current.left;
                else {
                    current.left = new Node();
                    current.left.data = value;
                    return root;
                }
            else if (value > current.data)
                if (current.right != null)
                    current = current.right;
                else {
                    current.right = new Node();
                    current.right.data = value;
                    return root;
                }
            else {
                current.data = value;
                return root;
            }

        }
        return root;
    }


    static class Node {
        int data;
        Node left;
        Node right;
    }
}
