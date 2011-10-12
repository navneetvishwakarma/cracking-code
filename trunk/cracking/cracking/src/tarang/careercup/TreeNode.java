package tarang.careercup;


/**
 * Ordinary tree node object
 *
 * @author tdesai
 */
public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;
    private TreeNode pred;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getPred() {
        return pred;
    }

    public void setPred(TreeNode pred) {
        this.pred = pred;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
