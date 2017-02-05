package gayle.treegraph;

public class TreeNode<E> {

    private TreeNode<E> parent;
    private TreeNode<E> left;
    private TreeNode<E> right;
    private E element;

    public TreeNode(TreeNode<E> parent, E element) {
        this.parent = parent;
        this.element = element;
    }

    public TreeNode(E element) {
        this(null, element);
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    public E getElement() {
        return element;
    }

    public void visit(TreeVisitor<E> visitor) {
        visitor.visit(this);
    }
}
