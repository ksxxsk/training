package hackerrank.tree;

import java.util.Scanner;

public class HeightOfABinaryTree {

    static int height(Node root) {

        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    static int height2(Node root) {

        return height(root, -1);
    }

    private static int height(Node root, int height) {
        if (root == null)
            return height;

        return Math.max( height(root.left, height+1), height(root.right, height+1));
    }

    public static Node insert(Node root, int data) {
        if(root == null){
            return new Node(data);
        }
        else {
            Node cur;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else{
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0){
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }


    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}
