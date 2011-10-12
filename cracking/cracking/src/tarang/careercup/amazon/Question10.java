package tarang.careercup.amazon;


/**
 * Compose a sorted array from two already sorted arrays
 *
 * @author tdesai
 */
public class Question10 {

    // O(n). where n = A.length + B.length
    public static int[] merge(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int index1 = A.length - 1;
        int index2 = B.length - 1;
        int index3 = C.length - 1;
        while(index1 >= 0 && index2 >= 0) {
            if(A[index1] > B[index2]) {
                C[index3] = A[index1];
                index1--;
            } else {
                C[index3] = B[index2];
                index2--;
            }
            index3--;
        }
        // finish off A if any left
        while (index1 >= 0) {
            C[index3--] = A[index1--];
        }
        // finish off B if any left
        while (index2 >= 0) {
            C[index3--] = B[index1--];
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
