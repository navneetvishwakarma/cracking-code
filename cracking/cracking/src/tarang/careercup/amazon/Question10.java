package tarang.careercup.amazon;


/**
 * Compose a sorted array from two already sorted arrays. Merge two sorted arrays
 *
 * @author tdesai
 */
public class Question10 {

    // O(n). where n = A.length + B.length
    public static int[] merge(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int iA = 0, iB = 0, iC = 0;

        while(iA < A.length && iB < B.length) {
            if(A[iA] < B[iB]) {
                C[iC++] = A[iA++];
            } else {
                C[iC++] = B[iB++];
            }
        }
        // finish off A if any left
        while (iA < A.length) {
            C[iC++] = A[iA++];
        }
        // finish off B if any left
        while (iB < B.length) {
            C[iC++] = B[iB++];
        }
        return C;
    }

    public static void main(String[] args) {
        int[] C = Question10.merge(new int[]{3, 14, 21, 22, 25, 51, 76, 81, 92}, new int[]{12, 25, 50, 89, 102, 110, 118});
        for(int c : C) {
            System.out.print(c + " ");
        }
    }
}
