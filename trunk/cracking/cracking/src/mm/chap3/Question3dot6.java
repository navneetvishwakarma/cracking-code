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


/**
 * Write a program to sort a stack in ascending order You should not make any assump- tions about how the stack is 
 * implemented The following are the only functions that should be used to write this program: push | pop | peek | isEmpty
 *
 * @author mmathuria
 */
public class Question3dot6 {
    
    
    //O(n-square) algo
    public Stack sortMyWay(Stack a){
        Stack b = new Stack(a.count());
        
        //for each element of stackA
        for(int i=0; i<a.count(); i++){
            int max = a.pop();
            
            //move everything from stackA to stackB, except the max 
            while(!a.isEmpty()){
                int item = a.pop();
                if(max < item){
                    b.push(max);
                    max = item;
                }else{
                    b.push(item);
                }
            }
            
            //now push the max, then empty stackB into stackA 
            a.push(max);
            while(!b.isEmpty()){
                a.push(b.pop());
            }
        }

        return a;
    }

    //pop an element (tmp) from stackA. if tmp < stackB.peek() then stackB.push(tmp)
    //else start poping from stackB and pushing into stackA until tmp < stackB.pop()
    //in that case push tmp to stackA and assign stackB.pop() to tmp. 
    public Stack sortMyWay2(Stack stack){
        Stack _stack = new Stack(stack.count());

        while(!stack.isEmpty()){
            int tmp = stack.pop();
            if(_stack.isEmpty() || tmp < _stack.peek()){
                _stack.push(tmp);
            }
            else {
                while(!_stack.isEmpty()){
                    int j = _stack.pop();
                    if( j < tmp){
                        stack.push(j);
                    }else{
                        stack.push(tmp);
                        tmp = j;
                    }
                }
                stack.push(tmp);
            }
        }

        return _stack;
    }
}
