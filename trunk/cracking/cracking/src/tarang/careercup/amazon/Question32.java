package tarang.careercup.amazon;

/**
 * Given an array having positive integers, find a continuous sub array which adds to a given number
 *
 * @author tdesai
 */
public class Question32 {

    public static int[] findSubarray(int[] A, int X) {
        int sum = 0;
        int i, j;
        for(i = j = 0; i < A.length; i++) {
            sum += A[i];
            if(sum == X) {
                return new int[]{j, i};
            } else if (sum > X) {
                // subtract until its less than or equal to
                while(sum > X) {
                    sum -= A[j];
                    j++;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] A = new int[]{20, -9, 3, 1, 5, 0, -6, 9};
        int[] solution = findSubarray(A, 0);
        for(int i = solution[0]; i <= solution[1]; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

}
