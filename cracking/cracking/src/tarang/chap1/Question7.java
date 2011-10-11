package tarang.chap1;


/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0
 *
 * @author tdesai
 */
public class Question7 {

    public static void zeroOut(int[][] A) {
        int m, n;
        if(A != null && A.length > 0) {
            m = A.length;
            n = A[0].length;
        } else {
            return; // throw an error
        }
        boolean[] m_arr = new boolean[m];
        boolean[] n_arr = new boolean[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 0) {
                    m_arr[i] = true;
                    n_arr[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(m_arr[i]) {
                    A[i][j] = 0;
                }
                if(n_arr[j]) {
                    A[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 8, 1, 2, 0, 9},
                {6, 2, 1, 6, 7, 0},
                {9, 2, 4, 8, 0, 0},
                {7, 2, 1, 5, 5, 5}};
        Question7.zeroOut(matrix);
    }
}
