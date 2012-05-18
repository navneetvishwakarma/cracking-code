package mm.amazon;

import mm.ds.BinaryTree;
import mm.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a binary tree and an integer X, find if the a path exists in the tree such that its sum equals X
 *
 * @author mmathuria
 */
public class Q13 {
    
    public List<String> findPath(BinaryTree tree, int x){
        if(tree == null){
            throw new IllegalArgumentException("Tree cannot be null");
        }
        
        List<String> paths = new ArrayList<String>();
        _findPath(tree.getRoot(),x,paths);
        return paths;
    }
    
    
    /*Do regular left-right traversal. Maintain a list of nodes while traversing back up. On return, at each node
        go through the list (in order) adding up values to see if it matches X 
    */
    private List<List<Integer>> _findPath(TreeNode current, int x, List<String> paths){
        if(current == null){
            return null;
        }
        
        Integer value = current.getData();
        if(value == x){
            paths.add(value.toString());
        }
        
        List<List<Integer>> leftSubTree = _findPath(current.leftChild,x,paths);
        List<List<Integer>> rightSubTree = _findPath(current.rightChild,x,paths);
        
        if(leftSubTree == null && rightSubTree == null){
            return createInitialListOfList(value);
        }

        List<List<Integer>> mergedList = new ArrayList<List<Integer>>();
        if(leftSubTree != null){
            checkSubtreeForX(x, paths, value, leftSubTree);
            mergedList.addAll(leftSubTree);
        }
        if(rightSubTree != null){
            checkSubtreeForX(x, paths, value, rightSubTree);
            mergedList.addAll(rightSubTree);
        }
        return mergedList;
    }

    private List<List<Integer>> createInitialListOfList(int value) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(value);
        List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
        listOfList.add(list);
        return listOfList;
    }

    private void checkSubtreeForX(int x, List<String> paths, Integer value, List<List<Integer>> leftSubTree) {
        for (List<Integer> list : leftSubTree) {
            checkPath(x, paths, value, list);
        }
    }

    private void checkPath(int x, List<String> paths, Integer value, List<Integer> list) {
        String tmpPath = value.toString();
        int tmpVal = value;
        for(int i=list.size()-1;i>=0;i--){
            int thisE = list.get(i);
            
            tmpVal += thisE;
            tmpPath = tmpPath + "-->" + thisE;
            
            if(tmpVal == x){
                paths.add(tmpPath);
                break;
            }
            if(tmpVal > x){
                break;
            }
        }
        list.add(value);
    }

    public static void main(String[] args) {
        Q13 q13 = new Q13();
        
        int[] a = {1,2,3,4,5,6,7,8,9};
        BinaryTree tree = Q03_BT.createFromInOrder(a);
        List<String> paths = null;
        for (int i=1;i<10;i++) {
            paths = q13.findPath(tree, i);
            System.out.println("\n" + i + "\n" + paths);
        }
    }
    
}
