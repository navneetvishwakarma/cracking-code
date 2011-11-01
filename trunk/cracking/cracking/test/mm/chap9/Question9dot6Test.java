/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package mm.chap9;

import junit.framework.TestCase;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question9dot6Test extends TestCase {
    
    
    public void testFind(){
        Question9dot6 obj = new Question9dot6();
        int[][] input1 = input1();
        
        boolean doesExists = obj.find(input1,5,5,10);
        assertTrue("item not found", doesExists);
        
        doesExists = obj.find(input1,5,5,15);
        assertFalse("item not found", doesExists);
        
    }
    
    
    private int[][] input1(){
        return new int[][]{
                { 0,  2,  5,  6,  8},
                { 1,  3,  7,  8,  9},
                { 4,  5,  8,  9, 11},
                { 8,  9, 10, 12, 14},
                {10, 11, 13, 14, 17},
        };
    }
}
