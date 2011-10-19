package mm;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;
    
    public TreeNode(int data){
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }
}
