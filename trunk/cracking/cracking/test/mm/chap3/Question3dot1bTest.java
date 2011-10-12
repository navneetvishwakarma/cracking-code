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
public class Question3dot1bTest extends TestCase {
    
    public void test1(){
        Question3dot1b obj = new Question3dot1b();

        obj.push(0, 21);
        obj.push(1, 5);
        obj.push(1, 4);
        obj.push(0, 18);
        System.out.println(obj.toString());

        obj.pop(1);
        System.out.println(obj.toString());
        
        obj.pop(1);
        System.out.println(obj.toString());

        try {
            obj.pop(1);
            fail("Stack 1 did not underflow");
        } catch (Exception e) {
            System.out.println(obj.toString());
        }

        obj.pop(0);
        System.out.println(obj.toString());

        obj.pop(0);
        System.out.println(obj.toString());

        try {
            obj.pop(0);
            fail("Stack 0 did not underflow");
        } catch (Exception e) {
            System.out.println(obj.toString());
        }
        
        obj.push(1,31);
        obj.push(1,32);
        System.out.println(obj.toString());
    }
}