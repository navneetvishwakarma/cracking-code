package mm.ds;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class TreeNode {
    public int data;
    public TreeNode leftChild;
    public TreeNode rightChild;
    public TreeNode parent; //for qn4.5
    
    public TreeNode(int data){
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public int getData() {
        return data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
