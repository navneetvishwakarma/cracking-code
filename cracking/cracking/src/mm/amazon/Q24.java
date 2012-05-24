package mm.amazon;


import mm.ds.BinaryTree;
import mm.ds.TreeNode;

/**
 Given a BST, convert it so that each node has value equal to sum of all the nodes (including itself) which are
 greater than that node in the whole tree.
 */
public class Q24 {
    public int updateNodeWithGreaterSum(TreeNode node, int val){
        if(node == null) return val;
        
        node.data += updateNodeWithGreaterSum(node.rightChild,val);
        return updateNodeWithGreaterSum(node.leftChild,node.data);
    }

    public static void main(String[] args) {
        Q24 obj = new Q24();

        BinaryTree tree = Q03_BT.createFromInOrder(new int[]{8,9,10});
        tree.displayInorder();
        obj.updateNodeWithGreaterSum(tree.getRoot(),0);
        tree.displayInorder();
        
        tree = new BinaryTree();
        tree.insertPreorder(new int[]{9, 4, 3, 6, 5, 7, 17, 22, 20});
        tree.displayInorder();
        obj.updateNodeWithGreaterSum(tree.getRoot(),0);
        tree.displayInorder();
        
    }
}
