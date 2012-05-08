package mm.chap4;


import mm.BinaryTree;
import mm.TreeNode;

/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question4dot7 {
    
    public boolean isSubtree(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 != null)    return false;
        if(n2 == null)    return true;
        
        if(n1.data == n2.data){
            boolean left = isSubtree(n1.leftChild, n2.leftChild);
            boolean right = isSubtree(n1.rightChild, n2.rightChild);
            return left && right;
        }else{
            boolean left = isSubtree(n1.leftChild,n2);
            boolean right = isSubtree(n1.rightChild,n2);
            return left || right;
        }
    }
}
