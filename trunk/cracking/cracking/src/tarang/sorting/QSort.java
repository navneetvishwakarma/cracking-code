package tarang.sorting;


/**
 * Quick sort implementation
 *
 * @author tdesai
 */
public class QSort {

    public int ithOrder(int[] nums, int p, int r, int i) {
        // find the ith number
        if(p == r) {
            return nums[p];
        }
        int q = partition(nums, p, r);
        int k = q - p + 1;  // add one because of zero-indexed
        if(i == k) {
            return nums[q];
        } else if (i < k) {
            // go left
            return ithOrder(nums, p, q - 1, i);
        } else {
            // go right
            return ithOrder(nums, q + 1, r, i - k);
        }
    }

    public void quicksort(int[] nums, int p, int r) {
        if(p < r) {
            int q = partition(nums, p, r);
            quicksort(nums, p, q-1);
            quicksort(nums, q+1, r);
        }
    }

    private int partition(int[] nums, int p, int r) {
        // partition around the pivot
        int pivot = nums[r];
        int i = p - 1;
        int j = p;
        while(j < r) {
            if(nums[j] <= pivot) {
                i++;
                // swap
                swap(nums, i, j);
            }
            j++;
        }
        i++;
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if(i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 8, 11, 0, 2, 14, 9, 3, 0, 100};
        /*new QSort().quicksort(nums, 0, nums.length-1);
        for(int num : nums) {
            System.out.print(num + " ");
        }*/
        int num = new QSort().ithOrder(nums, 0, nums.length-1, 5);
        System.out.println(num);
        new QSort().quicksort(nums, 0, nums.length-1);
        for(int num2 : nums) {
            System.out.print(num2 + " ");
        }
    }
}
