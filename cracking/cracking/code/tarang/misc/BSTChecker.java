package cracking.code.tarang.misc;


/**
 * Find if a binary tree is bst
 *
 * @author tdesai
 */
public class BSTChecker {

    public boolean check(TreeNode node) {
        if (node == null) {
            return true;
        } else {
            int value = node.getValue();
            if (node.getLeft() != null && value < node.getLeft().getValue()) {
                return false;
            }
            if (node.getRight() != null && value > node.getRight().getValue()) {
                return false;
            }
            return check(node.getLeft()) && check(node.getRight());
        }
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(3, new TreeNode(0), new TreeNode(5));
        TreeNode right = new TreeNode(9, new TreeNode(8), new TreeNode(11));
        TreeNode root = new TreeNode(7, left, right);
        System.out.println(new BSTChecker().check(root));
    }
}

class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }

    TreeNode(int value, TreeNode left, TreeNode right) {
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
}
