package mm.amazon;


import mm.ds.TreeNode;

/**
 * Return true if two trees are same
 */
public class Q21 {
    
    public boolean isSame(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        
        if(node1.data != node2.data) return false;
        
        return isSame(node1.leftChild,node2.leftChild) && isSame(node1.rightChild, node2.rightChild);
    }
}
