/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package cracking.src.mm.chap3;


/**
 * Describe how you could use a single array to implement three stacks
 *
 * @author mmathuria
 */
public class Question3dot1 {
    private final static int NO_OF_STACKS = 3;
    private final static int STACK_SIZE = 100;

    int[] store = new int[NO_OF_STACKS * STACK_SIZE];
    int[] stackPtrs = new int[NO_OF_STACKS];
    
    private int top;
    
    public void push(int stacknum, int value){
        //create NodeWithLastIndex
        
        //node.lastIndex = stackPtr[stackNum];
        
        //store[++top] = node
        
        //stackPtr[stackNum] = top;
    }
    
    
}
