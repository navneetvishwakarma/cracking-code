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


/**
 * Implement a function to check if a tree is balanced	For the purposes of this question, a balanced tree is defined to
 *  be a tree such that no two leaf nodes differ in distance from the root by more than one
 *
 * @author mmathuria
 */
public class Question4dot1 {


    public Question4dot1() {
    }
    
    
    public boolean isBalanced(BinaryTree tree){
        if(tree == null){
            throw new IllegalArgumentException("Tree is null");
        }
        
        int minDepth = minDepth(tree.getRoot());
        int maxDepth = maxDepth(tree.getRoot());
        
        return (maxDepth - minDepth <= 1);
    }
    
    
    
    private int maxDepth(TreeNode node){
        int lDepth = 0;
        int rDepth = 0;
        
        if(node.getLeftChild() != null){
            lDepth = maxDepth(node.getLeftChild());
        }
        
        if(node.getRightChild() != null){
            rDepth = maxDepth(node.getRightChild());
        }
        
        int depth = (lDepth >= rDepth) ? lDepth : rDepth;
        return depth + 1;
    }

    private int minDepth(TreeNode node){
        int lDepth = 0;
        int rDepth = 0;

        if (node.getLeftChild() != null) {
            lDepth = minDepth(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            rDepth = minDepth(node.getRightChild());
        }

        int depth = (lDepth >= rDepth) ? rDepth : lDepth;
        return depth + 1;
    }
}
