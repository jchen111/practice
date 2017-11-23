package leetcode;

/**
 * Created by z001ktb
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[]{left,right};
    }

    private static int searchLeft(int[] nums, int target) {
        int lo = -1;
        int hi = nums.length;
        while(hi - lo > 1) {
            int mid = (hi - lo) / 2 + lo;
            if(mid == 0 && nums[mid] == target) {
                return mid;
            }else if(mid > 0 && nums[mid - 1] < target && nums[mid] == target) {
                return mid;
            }else if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return -1;
    }

    private static int searchRight(int[] nums, int target) {
        int lo = -1;
        int hi = nums.length;
        while(hi - lo > 1) {
            int mid = (hi - lo) / 2 + lo;
            if(mid + 1 == nums.length && nums[mid] == target) {
                return mid;
            }else if(mid < nums.length - 1 && nums[mid + 1] > target && nums[mid] == target) {
                return mid;
            }else if(nums[mid] > target) {
                hi = mid;
            }else {
                lo = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        searchRange(nums, 2);
    }
}
