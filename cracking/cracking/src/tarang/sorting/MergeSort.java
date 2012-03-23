package tarang.sorting;


/**
 * Merge sort implementation
 *
 * @author tdesai
 */
public class MergeSort {

    public void merge_sort(int[] nums, int p, int r) {
        if(p < r) {
            int q = (p + r) / 2;
            merge_sort(nums, p, q);
            merge_sort(nums, q+1, r);
            merge(nums, p, q, r);
        }
    }

    private void merge(int[] nums, int p, int q, int r) {
        // merge two sorted lists, nums[p:q] and nums[q+1:r]
        int[] L = new int[q - p + 2];   // extra slots of infinity
        int idx = 0;
        for(int i = p; i <= q; i++, idx++) {
            L[idx] = nums[i];
        }
        L[idx] = Integer.MAX_VALUE;
        int[] R = new int[r - q + 1];
        idx = 0;
        for(int i = q+1; i <= r; i++, idx++) {
            R[idx] = nums[i];
        }
        R[idx] = Integer.MAX_VALUE;

        // arrays are ready
        idx = p;
        int left = 0, right = 0;
        while(idx <= r) {
            if(L[left] <= R[right]) {
                nums[idx] = L[left];
                left++;
            } else {
                nums[idx] = R[right];
                right++;
            }
            idx++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 8, 11, 0, 2, 14, 9, 3, 0, 100};
        new MergeSort().merge_sort(nums, 0, nums.length-1);
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}
