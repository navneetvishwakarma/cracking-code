/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package mm.amazon;

import junit.framework.TestCase;
import mm.ds.BinaryTree;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Q03Test extends TestCase {
    
    //binary search tree
    public void testCreateFromInorder() {
        int[] a = {5, 15, 20, 25, 30, 35};
        BinaryTree bTree = Q03_BST.createFromInorder(a);
        bTree.displayInorder();
    }

    public void testCreateFromPreorder() {
        int[] a = {25,15,5,20,35,30,45};
        BinaryTree bTree = Q03_BST.createFromPreorder(a);
        bTree.displayInorder();
    }

    public void testCreateFromPostorder() {
        int[] a = {5,20,15,30,45,35,25};
        BinaryTree bTree = Q03_BST.createFromPostorder(a);
        bTree.displayInorder();
    }


    //binary tree
    public void testCreateFromPreorder2() {
        int[] a = {3, 6, 0, 2, 3, 1, 4, 0, 4, 5, 9, 0, 1, 11, 10};
        BinaryTree bTree = Q03_BT.createFromPreOrder(a);
        bTree.displayInorder();
    }

    public void testCreateFromPostorder2() {
        int[] a = {2,3,0,4,0,1,6,9,0,5,11,10,1,4,3};
        BinaryTree bTree = Q03_BT.createFromPostOrder(a);
        bTree.displayInorder();
    }

    public void testCreateFromInorder2() {
        int[] a = {2,0,3,6,4,1,0,3,9,5,0,4,11,1,10};
        BinaryTree bTree = Q03_BT.createFromInOrder(a);
        bTree.displayInorder();
    }


}
