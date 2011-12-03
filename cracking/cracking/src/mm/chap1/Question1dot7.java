package mm.chap1;

import java.util.HashSet;
import java.util.Set;


/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0
 *
 * @author mmathuria
 */
public class Question1dot7 {
    
    public static int[][] setRowColToZero(int[][] a){
        Set<Integer> rowSet = new HashSet<Integer>();
        Set<Integer> colSet = new HashSet<Integer>();
        
        for(int i=0; i<a.length;i++){
            for(int j=0; j<a[0].length;j++){
                if(a[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        
        
        for(int row : rowSet){
            for(int j=0; j<a[0].length;j++){
                a[row][j] = 0;
            }
        }

        for(int col : colSet){
            for(int i=0; i<a.length;i++){
                a[i][col] = 0;
            }
        }
        
        return a;
    }


    public static void main(String[] args) {
        int[][] a = {
                {0,2,3},
                {4,0,6},
                {7,2,8}
        };
        
        setRowColToZero(a);
        print2DArray(a);
    }
    
    
    private static void print2DArray(int[][] a){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            builder.append("{");
            for (int j = 0; j < a[0].length; j++) {
                builder.append(a[i][j]).append(",");
            }
            builder.append("}\n");
        }
        System.out.println(builder.toString());
    }
}
