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
 * Given a matrix in which each row and each column is sorted, write a method to find an element in it
 *
 * @author mmathuria
 */
public class Question9dot6 {
    
    public boolean find(int[][] a, int numRows, int numCols, int item){
        
        int currentRow = 0;
        int currentCol = numCols - 1;
        
        while(currentRow < numRows && currentCol >= 0){
            int currentItem = a[currentRow][currentCol];
            if(currentItem == item){
                return true;
            }else if(currentItem > item){
                currentCol--;
            }else{
                currentRow++;
            }
        }
        return false;
    }
}
