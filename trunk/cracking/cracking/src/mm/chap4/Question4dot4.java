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
import mm.ds.LinkedList;
import mm.ds.Node;
import mm.ds.TreeNode;

import java.util.ArrayList;


/**
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth 
 * (i e , if you have a tree with depth D, you’ll have D linked lists)
 *
 * @author mmathuria
 */
public class Question4dot4 {

    ArrayList<LinkedList> arrayList;
    
    public ArrayList<LinkedList> algorithm(BinaryTree tree){
        arrayList = new ArrayList<LinkedList>();
        move(tree.getRoot(),0);
        return arrayList;
    }
    
    
    private void move(TreeNode node, int level){
        if(node == null){
            return;
        }

        LinkedList linkedList;
        if(level == arrayList.size()){
            linkedList = new LinkedList();
            arrayList.add(linkedList);
        }
        linkedList = arrayList.get(level);
        
        Node n = new Node(node.getData());
        linkedList.append(n);
        
        move(node.getLeftChild(),level + 1);
        move(node.getRightChild(),level + 1);
    }
}
