package gayle.treegraph;

/**
 * Created on 2/2/2017.
 */
public interface TreeVisitor<E> {

    void visit(TreeNode<E> node);
}
