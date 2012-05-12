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


/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B Write a method to 
 * merge B into A in sorted order
 *
 * @author mmathuria
 */
public class Question9dot1 {
    
    //m is the index of the last non-null element in A
    public int[] merge(int[] a, int[] b, int m){
        int i = a.length -1;
        int j = b.length -1;
        
        while(m >= 0 && j >= 0){
            if(a[m] >= b[j]){
                a[i--] = a[m--];
            }else{
                a[i--] = b[j--];
            }
        }
        
        if(m < 0){
            while(j >= 0){
                a[i--] = b[j--];
            }
        }
        
       return a;
    }
}
