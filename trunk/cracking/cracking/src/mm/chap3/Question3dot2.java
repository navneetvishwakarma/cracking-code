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
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum 
 * element? Push, pop and min should all operate in O(1) time
 *
 * @author mmathuria
 */
public class Question3dot2 {
    private Stack stackA;
    private Stack stackMin;

    public Question3dot2() {
        stackA = new Stack(10);
        stackMin = new Stack(10);
    }
    
    public void push(int value){
        if(stackA.isFull()) throw new IllegalStateException("Stack overflow");
        
        stackA.push(value);
        
        if(stackMin.isEmpty() || stackMin.peek() >= value){
            stackMin.push(value);
        }
    }
    
    public int pop(){
        if(stackA.isEmpty()) throw new EmptyStackException();
        
        int item = stackA.pop();
        if(stackMin.peek() == item){
            stackMin.pop();
        }
        return item;
    }
    
    public int min(){
        if(stackA.isEmpty()) throw new EmptyStackException();
        return stackMin.peek();
    }
    
}
