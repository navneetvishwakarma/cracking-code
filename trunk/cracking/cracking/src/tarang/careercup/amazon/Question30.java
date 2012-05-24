package tarang.careercup.amazon;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * How do you check a Sudoku game to make sure all the rules have been respected?
 *
 * @author tdesai
 */
public class Question30 {

    public static boolean sudokuChecker(int[][] state, int size) {
        Map<Integer, List<Boolean[]>> valid = new HashMap<Integer, List<Boolean[]>>();
        for(int i = 1; i <= size; i++) {
            valid.put(i, Arrays.asList(new Boolean[size], new Boolean[size]));  // row and column
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                List<Boolean[]> numval = valid.get(state[i][j]);
                Boolean[] row = numval.get(0);
                Boolean[] column  = numval.get(1);
                if(row[i] == null) {
                    row[i] = true;
                } else {
                    return false;
                }
                if(column[j] == null) {
                    column[j] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int size = 9;
        int[][] arr = new int[][]{
                {8, 3, 5,  4, 1, 6,  9, 2, 7},
                {2, 9, 6,  8, 5, 7,  4, 3, 1},
                {4, 1, 7,  2, 9, 3,  6, 5, 8},

                {5, 6, 9,  1, 3, 4,  7, 8, 2},
                {1, 2, 3,  6, 7, 8,  5, 4, 9},
                {7, 4, 8,  5, 2, 9,  1, 6, 3},

                {6, 5, 2,  7, 8, 1,  3, 9, 4},
                {9, 8, 1,  3, 4, 5,  2, 7, 6},
                {3, 7, 4,  9, 6, 2,  8, 1, 5}
        };
        System.out.println(sudokuChecker(arr, size));
    }
}
