package mm.amazon;
 
import mm.ds.BinaryTree;
import mm.ds.TreeNode;


/**
 * Reconstruct a BT given its preorder traversal. No extra space is allowed and accomplish this in O(n)
 *
 * @author mmathuria
 */
public class Q03_BT {
    public static BinaryTree createFromPreOrder(int[] data){
        BinaryTree bTree = new BinaryTree();
        TreeNode root = _createFromPreOrder(0,data.length-1,data);
        bTree.setRoot(root);
        return bTree;
    }
    
    
    public static TreeNode _createFromPreOrder(int lower, int upper, int[] data){
        if(lower > upper){
            return null;
        }
        
        TreeNode node = new TreeNode(data[lower]);
        int middle = (lower + upper) / 2;
        TreeNode leftChild = _createFromPreOrder(lower+1, middle,data);
        TreeNode rightChild = _createFromPreOrder(middle+1,upper,data);
        node.leftChild = leftChild;
        node.rightChild = rightChild;
        return node;
    }




    public static BinaryTree createFromPostOrder(int[] data){
        BinaryTree bTree = new BinaryTree();
        TreeNode root = _createFromPostOrder(0,data.length-1,data);
        bTree.setRoot(root);
        return bTree;
    }
    
    
    public static TreeNode _createFromPostOrder(int lower, int upper, int[] data){
        if(lower > upper){
            return null;
        }
        
        TreeNode node = new TreeNode(data[upper]);
        int middle = (lower + upper) / 2;
        TreeNode leftChild = _createFromPostOrder(lower, middle-1,data);
        TreeNode rightChild = _createFromPostOrder(middle,upper-1,data);
        node.leftChild = leftChild;
        node.rightChild = rightChild;
        return node;
    }





    public static BinaryTree createFromInOrder(int[] data){
        BinaryTree bTree = new BinaryTree();
        TreeNode root = _createFromInOrder(0,data.length-1,data);
        bTree.setRoot(root);
        return bTree;
    }
    
    
    public static TreeNode _createFromInOrder(int lower, int upper, int[] data){
        if(lower > upper){
            return null;
        }

        int middle = (lower + upper) / 2;
        TreeNode node = new TreeNode(data[middle]);
        TreeNode leftChild = _createFromInOrder(lower, middle-1,data);
        TreeNode rightChild = _createFromInOrder(middle+1,upper,data);
        node.leftChild = leftChild;
        node.rightChild = rightChild;
        return node;
    }

}
