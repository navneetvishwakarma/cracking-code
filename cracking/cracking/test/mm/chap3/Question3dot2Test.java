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

import junit.framework.TestCase;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question3dot2Test extends TestCase {
    
    public void test1(){
        Question3dot2 stack = new Question3dot2();
        int min;


        try {
            stack.pop();
            fail("Stack did not underflow");
        } catch (Exception e) {
            
        }
        
        
        stack.push(18);
        stack.push(12);
        stack.push(8);
        stack.push(21);
        
        min = stack.min();
        assertEquals("incorrect min returned",8,min);
        
        
        stack.pop();
        stack.pop();
        min = stack.min();
        assertEquals("incorrect min returned",12,min);
        
        stack.push(16);
        stack.push(12);
        stack.push(4);
        stack.push(8);
        
        min = stack.min();
        assertEquals("incorrect min returned", 4, min);
    }
    
    public void testMultipleCopiesOfMinEl(){
        Question3dot2 stack = new Question3dot2();
        
        stack.push(9);
        stack.push(3);
        stack.push(3);
        
        stack.pop();
        assertEquals("incorrect min returned",3,stack.min());
    }
}
