package hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    void levelOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data);

    }

    void LevelOrder2(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.print(current.data + " ");
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
