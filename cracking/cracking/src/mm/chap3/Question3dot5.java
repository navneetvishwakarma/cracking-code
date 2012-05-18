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

import mm.ds.Stack;

import java.util.EmptyStackException;


/**
 * Implement a MyQueue class which implements a queue using two stacks
 *
 * @author mmathuria
 */
public class Question3dot5 {
    
    private Stack stackA = new Stack(5);
    private Stack stackB = new Stack(5);
    
    public void insert(int value){
        stackA.push(value);
    }
    
    public int remove() {
        if(stackB.isEmpty()){
            if(stackA.isEmpty()){
                throw new EmptyStackException();
            }
            emptyAIntoB();
        }
        return stackB.pop();
    }

    private void emptyAIntoB() {
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    public Stack getStackA() {
        return stackA;
    }

    public Stack getStackB() {
        return stackB;
    }
}
