package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z001ktb on 6/8/17.
 */
public class CountOccurrence {
    static class Pair {
        int val;
        int occurrence;

        Pair(int v, int o) {
            this.val = v;
            this.occurrence = o;
        }
    }

    public static List<Pair> count(int[] nums) {
        int i = 0;
        List<Pair> result = new ArrayList<Pair>();
        while(i < nums.length) {
            int target = nums[i];
            int left = i;
            int right = binarySearch(nums, target, i);
            result.add(new Pair(target,right-left));
            i = right;
        }
        return result;
    }

    private static int binarySearch(int[] nums, int target, int start) {
        start -= 1;
        int end = nums.length;
        while(end - start > 1) {
            int mid = (end - start) / 2 + start;
            if(nums[mid] > target){
                end = mid;
            }else if(nums[mid] < target){
                start = mid;
            }else{
                if((mid + 1 < nums.length && nums[mid] < nums[mid+1]) || (mid == nums.length - 1)) return mid+1;
                start = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,4,5,6,7,7,7,7,8,8,8,8,8,8,8,8,9,9,9,10,10,11,12};
        List<Pair> res = count(nums);
        for(Pair p : res) {
            System.out.print(p.val + " " + p.occurrence);
            System.out.println();
        }
    }
}
