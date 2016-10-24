package leetcode;

/**
 * Created by z001ktb on 10/23/16.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int rotatePoint = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1])
                rotatePoint = i+1;
        }
        if(rotatePoint == 0) return binarySearch(nums,0,nums.length-1,target);
        else{
            return binarySearch(nums,0,rotatePoint-1,target) || binarySearch(nums,rotatePoint,nums.length-1,target);
        }
    }

    public boolean binarySearch(int[] nums, int left, int right, int target){
        if(nums.length == 0) return false;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
