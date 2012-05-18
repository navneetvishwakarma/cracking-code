package mm.amazon;
 
import mm.ds.BinaryTree;
import mm.ds.TreeNode;


/**
 * Reconstruct a BST given its preorder traversal. No extra space is allowed and accomplish this in O(n)
 *
 * @author mmathuria
 */
public class Q03_BST {
    public static BinaryTree createFromInorder(int[] preOrderedArray) {
        int middle = (preOrderedArray.length - 1) / 2;
        BinaryTree bTree = new BinaryTree(preOrderedArray[middle]);
        _createFromInorder(0, middle - 1, preOrderedArray, bTree.getRoot());
        _createFromInorder(middle + 1, preOrderedArray.length - 1, preOrderedArray, bTree.getRoot());
        return bTree;
    }

    private static void _createFromInorder(int lower, int upper, int[] preOrderedArray, TreeNode current) {
        if (lower > upper) return;

        int middle = (lower + upper) / 2;
        int middleValue = preOrderedArray[middle];
        TreeNode treeNode = new TreeNode(middleValue);

        if (middleValue < current.getData()) {
            current.leftChild = treeNode;
        } else {
            current.rightChild = treeNode;
        }

        _createFromInorder(lower, middle - 1, preOrderedArray, treeNode);
        _createFromInorder(middle + 1, upper, preOrderedArray, treeNode);
    }
    
    
    
    public static BinaryTree createFromPreorder(int[] data){
        if(data == null || data.length == 0){
            return null;
        }
        
        BinaryTree bTree = new BinaryTree();
        bTree.setRoot(new TreeNode(data[0]));
        
        int middle = (data.length-1) / 2;
        _createFromPreOrder(1,middle,bTree.getRoot(),data);
        _createFromPreOrder(middle+1,(data.length-1),bTree.getRoot(),data);
        
        return bTree;
    }
    
    private static void _createFromPreOrder(int lower, int upper, TreeNode current, int[] data){
        if(lower > upper){
            return;
        }
        
        TreeNode child = new TreeNode(data[lower]);
        if(current.getData() > child.getData()){
            current.leftChild = child;
            current = current.leftChild;
        }else{
            current.rightChild = child;
            current = current.rightChild;
        }
        
        int middle = (lower + upper) / 2;
        
        _createFromPreOrder(lower+1, middle, current, data);
        _createFromPreOrder(middle+1, upper,current, data);
    }
    
    
    
    public static BinaryTree cpo(int[] data){
        BinaryTree bTree = new BinaryTree();
        TreeNode root = _cpo(0,data.length-1,data);
        bTree.setRoot(root);
        return bTree;
    }
    
    
    public static TreeNode _cpo(int lower, int upper, int[] data){
        if(lower > upper){
            return null;
        }
        
        TreeNode node = new TreeNode(data[lower]);
        int middle = (lower + upper) / 2;
        TreeNode leftChild = _cpo(lower+1, middle,data);
        TreeNode rightChild = _cpo(middle+1,upper,data);
        node.leftChild = leftChild;
        node.rightChild = rightChild;
        return node;
    }

    public static BinaryTree createFromPostorder(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        int upper = data.length - 1;
        BinaryTree bTree = new BinaryTree();
        bTree.setRoot(new TreeNode(data[upper]));

        
        int middle = upper / 2;
        _createFromPostOrder(0, middle-1, bTree.getRoot(), data);
        _createFromPostOrder(middle, upper-1, bTree.getRoot(), data);

        return bTree;
    }

    private static void _createFromPostOrder(int lower, int upper, TreeNode current, int[] data) {
        if (lower > upper) {
            return;
        }

        TreeNode child = new TreeNode(data[upper]);
        if (current.getData() > child.getData()) {
            current.leftChild = child;
            current = current.leftChild;
        } else {
            current.rightChild = child;
            current = current.rightChild;
        }

        int middle = (lower + upper) / 2;

        _createFromPostOrder(lower, middle-1, current, data);
        _createFromPostOrder(middle, upper-1, current, data);
    }
}
