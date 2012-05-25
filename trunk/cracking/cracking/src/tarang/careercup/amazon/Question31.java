package tarang.careercup.amazon;


import java.util.Arrays;
import java.util.List;

/**
 * Find maximum subsequence from a list of numbers containing negative numbers.
 Eg. Max subseq in: {-10, 4, 14, -20, 23, 12, 11, -100} is 46 : {23, 12, 11}
 *
 * @author tdesai
 */
public class Question31 {

    public static Integer maxSubSequence(List<Integer> nbrs){
        Integer largestSofar = null;
        Integer sum = null;
        for(Integer num : nbrs) {
            if(sum == null) {
                sum = num;
            } else if(sum < sum + num) {
                // sum can further increase
                sum = sum + num;
            } else {
                // sum is going down with this num so check with largestsofar and reset
                if(largestSofar == null || sum > largestSofar) {
                    largestSofar = sum;
                }
                sum = null;
            }
        }
        if(largestSofar == null || (sum != null && sum > largestSofar)) {
            largestSofar = sum;
        }
        return largestSofar;
    }

    public static void main(String[] args) {
        System.out.println(maxSubSequence(Arrays.asList(-10, 4, 14, -20, 23, 12, 11, -100)));
        System.out.println(maxSubSequence(Arrays.asList(5, 10, -10, 6, 10)));
    }
}
