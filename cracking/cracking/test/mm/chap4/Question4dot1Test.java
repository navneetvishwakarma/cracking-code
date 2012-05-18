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

import junit.framework.TestCase;
import mm.ds.BinaryTree;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question4dot1Test extends TestCase {
    
    public void test1(){
        Question4dot1 obj = new Question4dot1();
        assertFalse("Tree is not unbalanced",obj.isBalanced(unbalancedTree()));
        assertTrue("Tree is not balanced",obj.isBalanced(balancedTree()));

        try {
            obj.isBalanced(nullTree());
            fail("Null input should throw exception");
        } catch (Exception e) {
            //empty
        }

        assertTrue("Tree is not balanced", obj.isBalanced(rootOnlyTree()));
    }
    
    private BinaryTree unbalancedTree(){
        int[] data = {12,24,8,14,22,32,6,10,26,40,9,11};
        
        BinaryTree tree = new BinaryTree(16);
        
        for(int i : data){
            tree.insert(i);
        }
        
        return tree;
    }

    private BinaryTree balancedTree(){
        int[] data = {12,24,8,14,22,32,6,10,26,40};
        
        BinaryTree tree = new BinaryTree(16);
        
        for(int i : data){
            tree.insert(i);
        }
        
        return tree;
    }
    
    private BinaryTree nullTree(){
        return null;
    }
    
    private BinaryTree rootOnlyTree(){
        return new BinaryTree(16);
    }
}
