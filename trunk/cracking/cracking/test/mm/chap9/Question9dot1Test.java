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
public class Question9dot1Test extends TestCase {
    
    public void test1Merge(){
        Question9dot1 obj = new Question9dot1();
        
        int[] a = {1,4,6,-1,-1,-1};
        int[] b = {2,3,5};
        int m = 2;
        a = obj.merge(a,b,m);

        p(a);
        assertTrue("array not sorted",isSorted(a));
    }
    
    
    public void test2Merge(){
        Question9dot1 obj = new Question9dot1();
        
        int[] a = {1,2,3,-1,-1,-1};
        int[] b = {4,5,6};
        int m = 2;
        a = obj.merge(a,b,m);

        p(a);
        assertTrue("array not sorted",isSorted(a));
    }
    
    
    public void test3Merge(){
        Question9dot1 obj = new Question9dot1();
        
        int[] a = {4,5,6,-1,-1,-1};
        int[] b = {1,2,3};
        int m = 2;
        a = obj.merge(a,b,m);

        p(a);
        assertTrue("array not sorted",isSorted(a));
    }
    
    
    private boolean isSorted(int[] a){
        for(int i=1; i<a.length; i++){
            if(a[i] < a[i-1]){
                return false;
            }
        }
        return true;
    }
    
    private void p(int[] a){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i : a){
            builder.append(i).append(",");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
