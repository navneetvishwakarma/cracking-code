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

import java.util.NoSuchElementException;


/**
 * Given a sorted array of n integers that has been rotated an unknown number of times,give an O(logn) algorithm that 
 * finds an element in th earray You may assume that the array was originally sorted in increasing order
 EXAMPLE:
 Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 Output: 8 (the index of 5 in the array)
 *
 * @author mmathuria
 */
public class Question9dot3 {
    
    public int findIndex(int[] a, int item){
        return binarySearch(a, 0, a.length-1, item);        
    }
    
    
    private int binarySearch(int[] a, int lower, int upper, int item){
        if(lower > upper){
            return -1;
        }
        
        int middle = (lower + upper) / 2;
        
        if(a[middle] == item){
            return middle;
        }
                
        
        boolean isLeftSorted = a[lower] < a[middle-1];
        
        if(isLeftSorted){
            if(a[lower] <= item && item <= a[middle-1]){
                return binarySearch(a, lower, middle-1, item);
            }else{
                return binarySearch(a, middle+1, upper, item);
            }
        }else{
            if(a[middle+1] <= item && item <= a[upper]){
                return binarySearch(a, middle+1, upper, item);
            }else{
                return binarySearch(a, lower, middle-1, item);
            }
        }
    }
}
