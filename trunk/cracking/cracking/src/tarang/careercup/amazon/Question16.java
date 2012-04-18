package tarang.careercup.amazon;


/**
 * Given an array find 3 elements such that a[i] < a[j] < a[k] and i < j < k in O(n) time.
 *
 * @author tdesai
 */
public class Question16 {

    public static void findMin3InOrder2(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        int i = 0;
        while(i < A.length) {
            left[i] = -1;
            right[i] = -1;
            i++;
        }

        int min = Integer.MAX_VALUE;
        int min_idx = -1;
        for(i = 0; i < A.length; i++) {
            if(min < A[i]) {
                left[i] = min_idx;
            } else {
                min = A[i];
                min_idx = i;
            }
        }

        int max = Integer.MIN_VALUE;
        int max_idx = -1;
        for(i = A.length - 1; i >= 0; i--) {
            if(max > A[i]) {
                right[i] = max_idx;
            } else {
                max = A[i];
                max_idx = i;
            }
        }

        i = 0;
        while(i < A.length) {
            if(left[i] != -1 && right[i] != -1) {
                System.out.print("[" + left[i] +  " " + i + " " + right[i] + "]");
                System.out.print("[" + A[left[i]] +  " " + A[i] + " " + A[right[i]] + "]");
                System.out.println();
            }
            i++;
        }
    }

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
        System.out.println();
        findMin3InOrder2(new int[]{5, 9, 1, 3, 3, 8});
    }
}
