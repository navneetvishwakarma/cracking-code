package tarang.careercup.amazon;


/**
 * Given an unsorted Array find maximum value of A[j] - A[i] where j>i..in O(n) time
 *
 * @author tdesai
 */
public class Question18 {

    public static int maxDiff(int[] A) {
        int minSoFar = A[0];
        int res = -1;
        for(int i = 1; i < A.length; i++) {
            res = Math.max(res, A[i] -  minSoFar);
            minSoFar = Math.min(minSoFar, A[i]);
        }
        return res;
    }

    public static int maxDiff2(int[] A) {
        int minSoFar = A[0];
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < A.length; i++) {
            if(res < A[i] - minSoFar) {
                res = A[i] - minSoFar;
            }
            if(minSoFar > A[i]) {
                minSoFar = A[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff2(new int[]{1, 9, 14, 5, 23, 34, 40}));
    }
}
