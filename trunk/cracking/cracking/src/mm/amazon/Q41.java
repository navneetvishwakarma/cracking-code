package mm.amazon;


import java.util.Arrays;

/**
 * Find next higher number with same digits.
 * Ex: given - 61543, output - 63145
 * 
 * The idea is 
 * Scan the number from right to left till we find a number smaller than the number on its right. (here 1)
 * Replace this number with the next higher number on its right (exchange 1 and 3)
 * Sort the remaining numbers (541 sorts to 145)
 * The final number becomes 63145
 */
public class Q41 {
    
    int nextHigher(int num){
        if(num < 10) return num;

        char[] nums  = Integer.toString(num).toCharArray();
        int j = findPivot(nums);
        
        //already the highest number
        if(j == 0) return num;

        int nextHigherIdx = nextHigherOnRight(nums, j);
        exchangePivotWithNextHigher(nums, j-1, nextHigherIdx); 
        Arrays.sort(nums, j, nums.length);
        return charToInt(nums);
    }

    private void exchangePivotWithNextHigher(char[] nums, int pivotIdx, int nextHigherIdx) {
        char tmp = nums[pivotIdx];
        nums[pivotIdx] = nums[nextHigherIdx];
        nums[nextHigherIdx] = tmp;
    }

    private int charToInt(char[] nums) {
        int sum = 0;
        for (char num1 : nums) {
            sum = sum * 10 + (num1 - '0');
        }
        return sum;
    }

    private int nextHigherOnRight(char[] nums, int j) {
        int nextHigher = Integer.MAX_VALUE;
        int nextHigherIdx = -1;
        for(int k=nums.length-1;k>=j;k--){
            if(nums[k] > nums[j-1] && nums[k] < nextHigher){
                nextHigher = nums[k];
                nextHigherIdx = k;
            }
        }
        return nextHigherIdx;
    }

    private int findPivot(char[] nums) {
        int j = nums.length-1;
        while((j-1) >= 0 && nums[j-1] > nums[j]){
            j--;
        }
        return j;
    }

    public static void main(String[] args) {
        Q41 obj = new Q41();
        System.out.println("1234-->" + obj.nextHigher(1234));
        System.out.println("61543-->" + obj.nextHigher(61543));
        System.out.println("7-->" + obj.nextHigher(7));
        System.out.println("1004-->" + obj.nextHigher(1004));
        System.out.println("4321-->" + obj.nextHigher(4321));
    }
    
}
