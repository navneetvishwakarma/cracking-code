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

import java.util.EmptyStackException;


/**
 * Describe how you could use a single array to implement three stacks
 *
 * @author mmathuria
 */
public class Question3dot1a {
    private final static int NO_OF_STACKS = 3;
    private final static int STACK_SIZE = 3;

    int[] store = new int[NO_OF_STACKS * STACK_SIZE];
    int[] tops = new int[NO_OF_STACKS];

    public void push(int snum, int value){
        if(isFull(snum)){
            throw new IllegalStateException("Stack overflow");
        }
        
        int index = (snum * STACK_SIZE) + tops[snum];
        store[index] = value;
        tops[snum]++;
    }
    
    
    public int pop(int snum){
        if(isEmpty(snum)){
            throw new EmptyStackException();
        }

        tops[snum]--;
        int index = (snum * STACK_SIZE) + tops[snum];
        int tmp = store[index];
        store[index] = -1;
        return tmp; 
    }
    
    public boolean isFull(int snum){
        return tops[snum] >= STACK_SIZE;
    }
    
    
    public boolean isEmpty(int snum){
        return tops[snum] <= 0;
    }

    
    @Override
    public String toString(){
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("[");
        for(int i : store){
            sbuilder.append(i).append(" ,");
        }
        sbuilder.append("]");
        return sbuilder.toString();
    }
}
