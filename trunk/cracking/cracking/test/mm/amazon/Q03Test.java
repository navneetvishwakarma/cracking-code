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
import mm.BinaryTree;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Q03Test extends TestCase {
    public void testCreateFromInorder() {
        int[] a = {5, 15, 20, 25, 30, 35};
        BinaryTree bTree = Q03.createFromInorder(a);
        bTree.display();
    }

    public void testCreateFromPreorder() {
        int[] a = {25,15,5,20,35,30,45};
        int[] A = {3, 6, 0, 2, 3, 1, 4, 0, 4, 5, 9, 0, 1, 11, 10};
        BinaryTree bTree = Q03.createFromPreorder(a);
        bTree.display();
    }

    public void testCreateFromPostorder() {
        int[] a = {5,20,15,30,45,35,25};
        BinaryTree bTree = Q03.createFromPostorder(a);
        bTree.display();
    }
}
