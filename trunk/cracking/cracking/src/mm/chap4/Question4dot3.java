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

import mm.BinaryTree;


/**
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height
 *
 * @author mmathuria
 */
public class Question4dot3 {
    
    public BinaryTree createBinaryTree(int[] input){
        
        if(input == null) throw new IllegalArgumentException("Input array cannot be null");
        
        BinaryTree tree = new BinaryTree();
        doMagic(input, tree, 0, input.length-1);
        return tree;
    }
    
 
    private void doMagic(int[] input, BinaryTree tree, int start, int end){
     
        if(end < start) return;
        
        int middle = (start + end) / 2;
        
        tree.insert(input[middle]);
        
        doMagic(input, tree, start, middle-1);
        doMagic(input, tree, middle+1, end);
    }
}
