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
import mm.ds.TreeNode;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question4dot6Test extends TestCase {
    
    public void test1(){
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(12);
        TreeNode ancestor = Question4dot6.findCommonAncestor(binaryTree1(), node1, node2);
        assertEquals("ancestor does not match",8,ancestor.getData());
        System.out.println("ancestor=" + ancestor.getData());
        
        node1 = new TreeNode(2);
        node2 = new TreeNode(5);
        ancestor = Question4dot6.findCommonAncestor(binaryTree1(), node1, node2);
        assertEquals("ancestor does not match",4,ancestor.getData());
        System.out.println("ancestor=" + ancestor.getData());
        
        node1 = new TreeNode(9);
        node2 = new TreeNode(28);
        ancestor = Question4dot6.findCommonAncestor(binaryTree1(), node1, node2);
        assertEquals("ancestor does not match",16,ancestor.getData());
        System.out.println("ancestor=" + ancestor.getData());
        

        //both none existing nodes
        node1 = new TreeNode(1);
        node2 = new TreeNode(11);
        ancestor = Question4dot6.findCommonAncestor(binaryTree1(), node1, node2);
        assertNull("ancestor does not match",ancestor);
        System.out.println("ancestor=null");
        
        //one node doesnt exists
        node1 = new TreeNode(1);
        node2 = new TreeNode(2);
        ancestor = Question4dot6.findCommonAncestor(binaryTree1(), node1, node2);
        assertNull("ancestor does not match",ancestor);
        System.out.println("ancestor=null");
        
    }


    private BinaryTree binaryTree1(){
        BinaryTree btree = new BinaryTree();

        int[] data = {16,8,24,4,10,18,28,2,5,9,12};
        //int[] data = {2,8,24,12,6,8,10,4,16,18,14};
        btree = new Question4dot3().createMinimalBT(data);
        return btree;
    }
}
