/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package mm.chap4;

import mm.ds.BinaryTree;
import mm.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height
 *
 * @author mmathuria
 */
public class Question4dot3 {
    
    public BinaryTree createMinimalBST(int[] data){
        TreeNode rootNode = _createMinimalBST(data,0,data.length-1);
        BinaryTree bTree = new BinaryTree();
        bTree.setRoot(rootNode);
        return bTree;
    }
    
    
    private TreeNode _createMinimalBST(int[] data, int start, int end){
        if (end < start) return null;
        
        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(data[middle]);
        
        node.leftChild = _createMinimalBST(data, start,middle-1);
        node.rightChild = _createMinimalBST(data,middle+1, end);
        return node;
    }
    
    
    //the function remembers the last node with a null child. and inserts the newest node as its child. 
    //it uses a queue to remember the last node with null child.
    //this is similar to BST.
    public BinaryTree createMinimalBT(int[] data){
        BinaryTree bTree = new BinaryTree();
        TreeNode rootNode = new TreeNode(data[0]);
        bTree.setRoot(rootNode);
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(rootNode);
        
        for(int i=1; i<data.length;i++){
            while(!q.isEmpty()){
                TreeNode n = q.peek();
                if(n.getLeftChild() == null){
                    n.leftChild = new TreeNode(data[i]);
                    q.add(n.leftChild);
                    break;
                }
                if(n.rightChild == null){
                    n.rightChild = new TreeNode(data[i]);
                    q.add(n.rightChild);
                    break;
                }
                if(n.leftChild != null && n.rightChild != null){
                    q.remove();
                }
            }
        }
        return bTree;
    }
}
