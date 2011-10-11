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

import mm.Stack;

import java.util.EmptyStackException;


/**
 * Write a program to sort a stack in ascending order You should not make any assump- tions about how the stack is 
 * implemented The following are the only functions that should be used to write this program: push | pop | peek | isEmpty
 *
 * @author mmathuria
 */
public class Question3dot6 {
    
    public Stack sortMyWay(Stack a){
        Stack b = new Stack(a.count());
        
        for(int i=0; i<a.count(); i++){
            int max = a.pop();
            
            
            while(!a.isEmpty()){
                int item = a.pop();
                if(max < item){
                    b.push(max);
                    max = item;
                }else{
                    b.push(item);
                }
            }
            
            a.push(max);
            while(!b.isEmpty()){
                a.push(b.pop());
            }
            //System.out.println(a.toString2());
        }

        return a;
    }
}
