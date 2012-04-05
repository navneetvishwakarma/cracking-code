package tarang.datastructures;


/**
 * Ordinary tree node object
 *
 * @author tdesai
 */
public class TreeNode {
    private TreeNode parent;
    private int value;
    private TreeNode left;
    private TreeNode right;
    private TreeNode pred;  // for "find path in the tree" question
    private TreeNode succ;  // for "find path in the tree" question

    public TreeNode() {
    }

    public TreeNode(String str) {
        // use string representation to recreate the tree
        if(str == null || str.length() == 0) {
            throw new IllegalArgumentException("cannot create a tree from null or empty string");
        }
        str = str.trim();
        // create tree
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
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
        if (this.left != null) {
            this.left.setParent(this);
        }
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
        if(this.right != null) {
            this.right.setParent(this);
        }
    }

    public TreeNode getPred() {
        return pred;
    }

    public void setPred(TreeNode pred) {
        this.pred = pred;
    }

    public TreeNode getSucc() {
        return succ;
    }

    public void setSucc(TreeNode succ) {
        this.succ = succ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TreeNode treeNode = (TreeNode) o;

        if (value != treeNode.value) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        // create a string structure of this subtree
        return str(this);
    }

    private String str(TreeNode node) {
        if(node == null) {
            return "";
        }
        return " (" + node.getValue() + str(node.getLeft()) + str(node.getRight()) + ")";
    }
}
