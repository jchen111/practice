package leetcode;

/**
 * Created by jiaqichen on 10/5/16.
 */
public class FindMinimumInRotatedSortedArray {
    //O(N)
    public int findMin1(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                res = nums[i];
            }
        }
        return res;
    }

    //O(logN)
    public int findMin(int[] num) {
        if(num.length == 1){
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }

}
