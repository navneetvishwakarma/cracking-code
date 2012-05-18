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
import junit.framework.TestCase;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question3dot6Test extends TestCase {
    
    
    public void testSortMyWay(){
        Stack s = createStack2();
        
        Question3dot6 qn = new Question3dot6();
        Stack outputStk = qn.sortMyWay2(s);
        
        assertNotNull("result is null",outputStk);
        
        int upper = outputStk.pop();
        for(int i=0;i<outputStk.count()-1;i++){
            int lower = outputStk.pop();
            assertTrue("upper is not smaller than lower", (upper <= lower));
            upper = lower;
        }
        System.out.println(outputStk.toString());
        
    }
    
    private Stack createStack1(){
        Stack s = new Stack(3);
        s.push(1);
        s.push(2);
        s.push(3);
        return s;
    }
    
    private Stack createStack2(){
        Stack s = new Stack(10);
        s.push(80);
        s.push(75);
        s.push(12);
        s.push(68);
        s.push(98);
        s.push(76);
        s.push(45);
        s.push(7);
        s.push(33);
        s.push(91);
        return s;
    }
}
