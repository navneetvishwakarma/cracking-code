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

import java.util.ArrayList;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question9dot7Test extends TestCase {
    
    public void test1(){
        Question9dot7 obj = new Question9dot7();

        ArrayList<HtWt> result = obj.findMaxSequence(input1()); 
        assertEquals("seq is of the same size",5,result.size());

    }
    
    
    private ArrayList<HtWt> input1(){
        ArrayList<HtWt> list = new ArrayList<HtWt>();
        list.add(new HtWt(56,90));
        list.add(new HtWt(60,95));
        list.add(new HtWt(60,100));
        list.add(new HtWt(68,110));
        list.add(new HtWt(70,150));
        list.add(new HtWt(75,190));
        return list;
    }
}
