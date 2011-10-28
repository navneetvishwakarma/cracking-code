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
public class Question9dot2Test extends TestCase {
    
    public void test1(){
        Question9dot2 obj = new Question9dot2();
        String[] input = {"bat", "cat", "atb", "tab", "tac", "der", "act", "red"};

        String[] expected = obj.orderAnagrams(input);
        p(expected);        

        expected = obj._orderAnagrams(input);
        p(expected);        

    }

    private void p(String[] a) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (String i : a) {
            builder.append(i).append(",");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
