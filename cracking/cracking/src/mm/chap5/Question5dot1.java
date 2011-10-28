/*
 * $Id$
 *
 * Copyright (c) 2001-2008 Bridge Entertainment, Inc. (dba E-Poll Market Research)
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information
 * of Bridge Entertainment, Inc. ("Confidential Information").
 */


package mm.chap5;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question5dot1 {

    public static void main(String[] args) {
        int n = Integer.parseInt("10000000000",2);
        int m = Integer.parseInt("10101",2);
        
        int i = 2;
        int j = 6;
        
        //int result = updateBits(n,m,i,j);
        //System.out.println(Integer.toBinaryString(result));
        
        
        for(int ii = 0; ii<=31;ii++){
            System.out.println(ii + "\t" + Integer.toBinaryString(ii));
        }
    }
    
    public static int updateBits(int n, int m, int i, int j) {
        int max = ~0; 
        pb("  max", max);

        int oneShiftedj = 1 << j;
        pb("onesj", oneShiftedj);
        pb("onesj-1", oneShiftedj-1);
        
        
        int left = max - (oneShiftedj - 1);
        pb("left", left);
        
        int right = ((1 << j) - 1);
        pb("right", right);
        
        int mask = left | right;
        pb("mask", mask);
        
        return ( n & mask) | (m << i);
    }
    
    private static void pb(String s, int i){
        System.out.println(s + "\t\t\t" + Integer.toBinaryString(i));
    }
}
