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
public class Question3dot5Test extends TestCase {
    
    public void test1(){
        Question3dot5 obj = new Question3dot5();

        try {
            obj.remove();
            fail("queue did not undeflow");
        } catch (Exception e) {
            
        }
        
        
        obj.insert(18);
        obj.insert(8);
        obj.insert(10);
        obj.insert(6);
        
        int item = obj.remove();
        assertEquals("items dont match",18,item);
        //System.out.println(obj.getStackA().toString());
        //System.out.println(obj.getStackB().toString());
        
        obj.remove();
        obj.remove();
        //System.out.println(obj.getStackA().toString());
        //System.out.println(obj.getStackB().toString());
        
        obj.remove();
        obj.insert(12);
        obj.insert(14);
        
        item = obj.remove();
        assertEquals("items dont match", 12, item);
        //System.out.println(obj.getStackA().toString());
        //System.out.println(obj.getStackB().toString());
    }
}
