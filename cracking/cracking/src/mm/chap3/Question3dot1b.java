/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package mm.chap3;

import java.util.ArrayList;
import java.util.EmptyStackException;


/**
 * Describe how you could use a single array to implement three stacks
 *
 * @author mmathuria
 */
public class Question3dot1b {
    final static int NO_OF_STACKS = 3;
    private Node[] store = new Node[10];
    
    private int[] tops = new int[NO_OF_STACKS];
    private int top = -1;

    public Question3dot1b() {
        for(int i=0;i<tops.length;i++){
            tops[i] = -1;
        }
    }

    public void push(int snum, int value){
        Node node = new Node(value, tops[snum]);
        store[++top] = node;
        tops[snum] = top;
    }
    
    
    public int pop(int snum){
        if(isEmpty(snum))   throw new EmptyStackException();
        
        Node n = store[tops[snum]];
        store[tops[snum]] = null;
        tops[snum] = n.lastIndex;
        return n.data;
    }
    
    
    public boolean isEmpty(int snum){
        return (store.length==0 || (tops[snum] == -1));
    }

    @Override
    public String toString() {
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("[");
        for (Node i : store) {
            if(i == null)   sbuilder.append("null, ");
            else sbuilder.append(i).append(" ,");
        }
        sbuilder.append("]");
        return sbuilder.toString();
    }
}



class Node{
    int data;
    int lastIndex;

    Node(int data, int lastIndex) {
        this.data = data;
        this.lastIndex = lastIndex;
    }
    
    @Override
    public String toString(){
        return "(" + Integer.toString(data) + "," + Integer.toString(lastIndex) + ")";
    }
}