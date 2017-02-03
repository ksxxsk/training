package gayle.treegraph.questions;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import gayle.treegraph.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class MinimalSearchTreeTest {

    private Integer[] inOrder(TreeNode<Integer> tree) {
        List<Integer> nodes = new ArrayList<>();

        inOrder(tree, nodes);
        return nodes.toArray(new Integer[0]);
    }

    private TreeNode<Integer> inOrder(TreeNode<Integer> node, List<Integer> nodes) {
        if (node != null) {
            inOrder(node.getLeft(), nodes);
            nodes.add(node.getElement());
            node.visit(n -> System.out.println(n.getElement()));
            inOrder(node.getRight(), nodes);
        }
        return node;
    }

    private void assertMinimalBST(int[] array) {
        assertThat(inOrder(MinimalSearchTree.minimalTree(array)), is(array));
    }

    @Test
    public void oneElementArray() {
        int[] array = { 1 };
        assertMinimalBST(array);
    }

    @Test
    public void bigSortedArray() {
        int[] array = { 1, 4, 5, 6, 12, 43, 145, 190, 214, 233, 235, 341, 450 };

        assertMinimalBST(array);
    }

}