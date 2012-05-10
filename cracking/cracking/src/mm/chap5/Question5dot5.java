package mm.chap5;


/**
 * Write a function to determine the number of bits required to convert integer A to integer B
 * Input: 31, 14 Output: 2
 *
 * @author mmathuria
 */
public class Question5dot5 {
    
    public static int bitSwapReqd(int i, int j){
        int k = i ^ j;  //xor
        
        //now count the number of 1s in k
        int count = 0;
        while (k > 0){  //in each iteration: & the last bit of k; shift k to right by one
            count = count + (k & 1);
            k = k >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Question5dot5.bitSwapReqd(31,14));   //2
        System.out.println(Question5dot5.bitSwapReqd(8,7));   //4
        System.out.println(Question5dot5.bitSwapReqd(8,8));   //0
    }
}
