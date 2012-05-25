package tarang.careercup.amazon;

import java.util.Arrays;


/**
 * Find the two numbers among a set of numbers whose difference is minimum. Follow up: what if the difference is an
 * absolute value, then find the two numbers with minimum difference
 *
 * @author tdesai
 */
public class Question04 {

    // min difference when not considering the absolute value - O(n)
    public static int[] mindiff1(int[] A) {
        if(A == null || A.length == 0) {
            throw new IllegalArgumentException("input array null or empty");
        }
        // find the min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int a : A) {
            if(a < min) {
                min = a;
            }
            if(a > max) {
                max = a;
            }
        }

        return new int[]{min, max, min - max};
    }

    // O(n log n)
    public static int[] mindiff2(int[] A) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("input array null or empty");
        }
        Arrays.sort(A); // sorting
        int[] nums = new int[3];
        nums[2] = Integer.MAX_VALUE;
        int diff;
        for(int i = 1; i < A.length; i++) {
            diff = Math.abs(A[i] - A[i - 1]);
            if(diff < nums[2]) {
                nums[0] = A[i - 1];
                nums[1] = A[i];
                nums[2] = diff;
            }
            if(nums[2] == 0) {
                break;
            }
        }
        return nums;
    }

    // print the array
    public static String print(int[] A) {
        String str = "";
        for (int a : A) {
            str += a + " ";
        }
        return str;
    }

    public static void main(String[] args) {
        int[] A = {13, 18, 0, -10, 52, 55, -7};
        int[] nums = mindiff1(A);
        System.out.println(print(nums));
        nums = mindiff2(A);
        System.out.println(print(nums));
    }
}
