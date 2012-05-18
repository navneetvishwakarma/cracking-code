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
import mm.ds.LinkedList;

import java.util.ArrayList;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question4dot4Test extends TestCase {
    
    public void test1(){
        Question4dot4 obj = new Question4dot4();
        
        BinaryTree tree = createBinaryTree();

        ArrayList<LinkedList> arrayList = obj.algorithm(tree);
        for(LinkedList list : arrayList){
            System.out.println(list);
        }
    }
    
    
    private BinaryTree createBinaryTree(){
        BinaryTree btree = new BinaryTree();
        
        int[] data = {12,8,17,6,9,15,21};
        for(int i : data){
            btree.insert(i);
        }
        return btree;
    }
    
}
