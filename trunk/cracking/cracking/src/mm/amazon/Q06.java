package mm.amazon;


import mm.ds.TreeNode;

import java.util.ArrayList;

/**
 * Given a binary tree count the number of nodes at each level in the tree. Follow up: count the number of nodes below 
 * each node
 */
public class Q06 {
    
    public void countNodesAtEachLevel(TreeNode node, int depth, ArrayList<Integer> list){
        if(node == null) return;

        try {
            Integer currentCount = list.get(depth);
            list.add(depth,currentCount+1);
        } catch (Exception e) {
            list.add(depth,1);
        }
 
        countNodesAtEachLevel(node.leftChild,depth+1,list);
        countNodesAtEachLevel(node.rightChild,depth+1,list);
    }
    
    public int countNodesBelowGiven(TreeNode node){
        if(node == null) return 0;
        
        return 1 + countNodesBelowGiven(node.leftChild) + countNodesBelowGiven(node.rightChild);
    }
    
}
