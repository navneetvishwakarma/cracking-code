package tarang.careercup.amazon;


/**
 * Find the maximum subarray in an array with negative numbers. A better linear time algorithm in Question31. EFF this impl.
 *
 * @author tdesai
 */
public class Question15 {


    private int[] maxCrosssingSubarray(int nums[], int low, int mid, int high) {
        // find max sum and indexes on the left half
        int sum = 0;
        int left_idx = mid;
        int left_sum = 0;
        for(int i = mid; i >= low; i--) {
            // go from middle to lower and find the highest sum and its index
            sum += nums[i];
            if(sum > left_sum) {
                left_sum = sum;
                left_idx = i;
            }
        }

        // find max sum and indexes on the right half
        sum = 0;
        int right_idx = mid;
        int right_sum = 0;
        for(int i = mid+1; i <= high; i++) {
            // go from mid+1 to high and find the highest sum and its index
            sum += nums[i];
            if(sum > right_sum) {
                right_sum = sum;
                right_idx = i;
            }
        }

        return new int[] {left_idx, right_idx, left_sum + right_sum};
    }

    public int[] maxSubarray(int nums[], int low, int high) {
        if(low == high) {
            return new int[]{low, high, nums[low]};
        } else {
            int mid = (high + low) / 2;
            int[] left = maxSubarray(nums, low, mid);
            int[] right = maxSubarray(nums, mid+1, high);
            int[] crossing = maxCrosssingSubarray(nums, low, mid, high);

            if(left[2] >= right[2] && left[2] >= crossing[2]) {
                return left;
            } else if (right[2] >= left[2] && right[2] >= crossing[2]) {
                return right;
            } else {
                return crossing;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] maxsubarray = new Question15().maxSubarray(nums, 0, nums.length-1);
        for(int num : maxsubarray) {
            System.out.print(num + " ");
        }
    }
}
