package mm.chap4;


import mm.ds.TreeNode;

/**
 * Write an algorithm to find the ‘next’ node (e g , in-order successor) of a given node in a binary search tree where
 * each node has a link to its parent
 *
 * @author mmathuria
 */
public class Question4dot5 {
    
    public TreeNode findInorderSuccessor(TreeNode node){
        if(node == null) return null;
        
        if(node.rightChild != null){
            return leftMostNode(node.rightChild);
        }else{
            if(node.parent == null) return null;
            else if(node.parent.leftChild.data == node.data) return node.parent;    //the node is the leftchild of a non-visited parent. return the parent
            else{
                TreeNode current = node;    //keep traversing up till we find a non-visited parent
                while(current != null && current.data <= node.data) current = current.parent;
                return current;
            }
        }
    }
    
    private TreeNode leftMostNode(TreeNode root){
        TreeNode current = root;
        while(current.leftChild != null) current = current.leftChild;
        return current;
    }
}
