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
public class Question3dot1aTest extends TestCase {
    
    
    public void testOverflow(){
        Question3dot1a obj = new Question3dot1a();

        _testOverflow(obj, 0);
        _testOverflow(obj, 1);
        _testOverflow(obj, 2);

        System.out.println(obj.toString());
    }

    private void _testOverflow(Question3dot1a stack, int snum) {
        stack.push(snum,18);
        stack.push(snum,9);
        stack.push(snum,16);

        try {
            stack.push(snum,14);
            fail("Stack " + snum + " did not overflow");
        } catch (Exception e) {
            //intentional 
        }
    }
    
    public void testUnderflow(){
        Question3dot1a obj = new Question3dot1a();
        
        _testUnderflow(obj, 0);
        _testUnderflow(obj, 1);
        _testUnderflow(obj, 2);

        System.out.println(obj.toString());
        
    }

    private void _testUnderflow(Question3dot1a stack, int snum) {
        stack.push(snum, 18);
        stack.push(snum, 9);
        stack.push(snum, 16);
        
        while(!stack.isEmpty(snum)){
            stack.pop(snum);
        }

        try {
            stack.pop(snum);
            fail("Stack " + snum + " did not underflow");
        } catch (Exception e) {
            //intentional 
        }

    }
}
