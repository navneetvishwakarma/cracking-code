package tarang.careercup.amazon;


/**
 * Given an array find 3 elements such that a[i] < a[j] < a[k] and i < j < k in O(n) time.
 *
 * @author tdesai
 */
public class Question55 {

    public static void findMin3InOrder(int[] A) {
        int _s1 = A[0];
        Integer s1 = null, s2 = null;
        for(int i = 1; i < A.length; i++) {
            if(A[i] < _s1) {
                _s1 = A[i];
            } else {
                if(s2 == null || s2 > A[i]) {
                    // s2 null check for first time around, s2 > A[i] is resetting the s1 and s2
                    s1 = _s1;
                    s2 = A[i];
                } else if(A[i] > s2) {
                    // here A[i] > s2 which means we have found the third element
                    System.out.print(s1 + " " + s2 + " " + A[i]);
                    return;
                }
            }
        }
    }


    public static void main(String[] args) {
        findMin3InOrder(new int[]{5, 9, 1, 3, 3, 8});
    }
}
