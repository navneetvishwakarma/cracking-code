package mm.amazon;


import mm.ds.Node;
import mm.ds.TreeNode;

import java.util.ArrayList;

/**
 * Given an integer n , you have to print all the ways in which n can be represented as sum of positive integers.
 * 3 = 
 2 1
 1 1 1
 */
public class Q36 {

    public void printAllCombinations(int n, ArrayList<Integer> output){
        if(n == 1){
            output.add(n);
            System.out.println(output);
            return;
        }
        
        if(n == 0){
            System.out.println(output);
            return;
        }
        
        for(int i  = 1; i<=n; i++){
            if(!output.isEmpty() && i > output.get(output.size()-1)){
                break;
            }
            ArrayList<Integer> clonedList = (ArrayList<Integer>) output.clone();
            clonedList.add(i);
            printAllCombinations(n-i,clonedList);
        }
    }

    public static void main(String[] args) {
        new Q36().printAllCombinations(5,new ArrayList<Integer>());
    }
}
