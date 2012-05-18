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
public class Question4dot3Test extends TestCase {
    
    public void test1(){
        Question4dot3 obj = new Question4dot3();
        
        int[] data = {0, 3, 5, 7, 8, 9, 11, 21, 29};
        BinaryTree tree= obj.createMinimalBST(data);
        tree.displayInorder();

        //empty tree
        data = new int[0];
        tree = obj.createMinimalBST(data);
        tree.displayInorder();
    }
}
