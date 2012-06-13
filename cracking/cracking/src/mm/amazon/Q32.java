package mm.amazon;


/**
 * Given an array having positive integers, find a continous subarray which adds to a given number
 */
public class Q32 {

    /**
     * Idea is to have a runningSum and 2 pointers, i and j, that mark the start and end of the subarray. 
     * while the runningSum is <= givenNum, keep adding the next number to the sum (by incrementing j)
     * if runningSum is > givenNum, keep subtracting the numbers from the start (by incrementing i)
     * @param data
     * @param num
     */
    public static void continuousSubArray(int[] data, int num){
        int i = 0;
        int j = 0;
        int sum = 0;
        
        while (j < data.length){
            sum += data[j++];
            
            while (sum > num){
                sum -= data[i++];
            }
            
            if(sum == num){
                break;
            }
        }
        
        if(sum != num){
            System.out.println("no subarray found = " + num);
            return;
        }
        printResult(i, j-1, data, num);
    }
    

    public static void main(String[] args) {
        continuousSubArray(new int[]{2,4,1,3,7,5,6},11);
        continuousSubArray(new int[]{2,4,1,3,7,5,6},16);
        continuousSubArray(new int[]{2,4,1,3,7,5,6},13);
        continuousSubArray(new int[]{2,4,1,3,7,5,6},28);
        continuousSubArray(new int[]{1},2);
        continuousSubArray(new int[]{2},2);
        continuousSubArray(new int[]{3},2);
        continuousSubArray(new int[]{12,14,3,2,10},5);
    }


    private static void printResult(int i, int j, int[] data, int num){
        StringBuilder buf = new StringBuilder();
        while(i <= j){
            buf.append(data[i]);
            if(i < j){
                buf.append(" + ");
            }
            i++;
        }
        buf.append(" = ").append(num);
        System.out.println(buf.toString());
    }
}
