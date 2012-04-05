package tarang.careercup.amazon;


/**
 * Given an unsorted Array find maximum value of A[j] - A[i] where j>i..in O(n) time
 *
 * @author tdesai
 */
public class Question57 {

    public static int maxDiff(int[] A) {
        int minSoFar = A[0];
        int res = -1;
        for(int i = 1; i < A.length; i++) {
            res = Math.max(res, A[i] -  minSoFar);
            minSoFar = Math.min(minSoFar, A[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[]{1, 9, 14, 5, 23, 34, 40}));
    }
}
