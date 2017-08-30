package leetcode;

import java.util.Arrays;

public class WiggleSortII {
    public static void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int n = nums.length;
        int[] result = new int[n];
        Arrays.sort(nums);
        int m = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int k = 0;
        for(int i = 0; i < m; i++) {
            result[k] = nums[i];
            k += 2;
        }
        k = 1;
        for(int i = m; i < n; i++) {
            result[k] = nums[i];
            k += 2;
        }

        for(int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,1,1,4,6};
        wiggleSort(arr);
    }
}
