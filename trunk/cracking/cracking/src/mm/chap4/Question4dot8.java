package mm.chap4;


import mm.ds.BinaryTree;
import mm.ds.TreeNode;

import java.util.ArrayList;

/**
 * Q13.java also solves this problem with a different (inefficient and complicated) approach
 * 
 * You are given a binary tree in which each node contains a value Design an algorithm to print all paths which sum up 
 * to that value Note that it can be any path in the tree - it does not have to start at the root
 *
 * @author mmathuria
 */
public class Question4dot8 {
    public void findPath(TreeNode node, int x, ArrayList<Integer> list){
        if(node == null){
            return;
        }
        
        int sum = 0;
        list.add(node.data);
        for(int i=list.size()-1;i>=0;i--){
            sum += list.get(i);
            if(sum == x){
                print(list,i);
            }
        }

        //noinspection unchecked
        findPath(node.leftChild,x,(ArrayList<Integer>) list.clone());
        //noinspection unchecked
        findPath(node.rightChild,x, (ArrayList<Integer>) list.clone());
    }
    
    
    private void print(ArrayList<Integer> list, int i){
        StringBuilder buf = new StringBuilder();
        for(int i2 = list.size()-1; ; i2--){
            buf.append(list.get(i2));
            if(i2 <= i){
                break;
            }
            buf.append("-->");
        }
        System.out.println(buf);
    }

    public static void main(String[] args) {
        int[] a = {2,8,24,12,6,8,10,4,16,18,14};
        BinaryTree tree = new Question4dot3().createMinimalBT(a);

        new Question4dot8().findPath(tree.getRoot(),16,new ArrayList<Integer>());
    }
}
