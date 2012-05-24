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

    public static Integer maxSubSequence(List<Integer> nbrs)
    {
        Integer largestSofar = null;
        Integer sum = null;
        for(Integer num : nbrs) {
            if(sum == null) {
                sum = num;
            } else if(sum < sum + num) {
                sum = sum + num;
            } else {
                if(largestSofar == null || sum > largestSofar) {
                    largestSofar = sum;
                }
                sum = null;
            }
        }
        return largestSofar;
    }

    public static void main(String[] args) {
        System.out.print(maxSubSequence(Arrays.asList(-10, 4, 14, -20, 23, 12, 11, -100)));
    }
}
