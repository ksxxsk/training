package gayle.treegraph.questions;

import gayle.treegraph.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SuccessorTest {


    TreeNode<Integer> n15;
    TreeNode<Integer> n13;
    private TreeNode<Integer> n4;
    private TreeNode<Integer> n2;
    private TreeNode<Integer> n7;
    private TreeNode<Integer> n3;
    private TreeNode<Integer> n6;
    private TreeNode<Integer> n9;
    private TreeNode<Integer> n18;
    private TreeNode<Integer> n17;
    private TreeNode<Integer> n20;

    /**
     * 15
     * /   \
     * 6     18
     * / \   /  \
     * 3  7  17  20
     * /  \  \
     * 2   4   13
     * /
     * 9
     */
    @Before
    public void setUp() {
        n15 = new TreeNode<>(15);

        n6 = new TreeNode<>(n15, 6);
        n15.setLeft(n6);

        n3 = new TreeNode<>(n6, 3);
        n6.setLeft(n3);
        n7 = new TreeNode<>(n6, 7);
        n6.setRight(n7);

        n2 = new TreeNode<>(n3, 2);
        n3.setLeft(n2);
        n4 = new TreeNode<>(n3, 3);
        n3.setRight(n4);

        n13 = new TreeNode<>(n7, 13);
        n7.setRight(n13);

        n9 = new TreeNode<>(n13, 9);
        n13.setLeft(n9);

        n18 = new TreeNode<>(n15, 18);
        n15.setRight(n18);

        n17 = new TreeNode<>(n18, 17);
        n18.setLeft(n17);

        n20 = new TreeNode<>(n18, 20);
        n18.setRight(n20);
    }

    @Test
    public void successorIsRightChild() {
        assertSuccessor(n18, n20);
        assertSuccessor(n3, n4);
        assertSuccessor(n6, n7);
    }

    @Test
    public void successorIsLeftMostNodeInRightChildSubtree() {
        assertSuccessor(n15, n17);
    }

    @Test
    public void noRightChild_successorIsLowestAncestorWhoseLeftChildIsAlsoAnchestorOfNode() {
        assertSuccessor(n9, n13);
        assertSuccessor(n13, n15);
    }

    private void assertSuccessor(TreeNode<Integer> node, TreeNode<Integer> successor) {
        assertThat(Successor.successor(node).getElement(), is(successor.getElement()));
    }
}