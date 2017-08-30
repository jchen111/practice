package facebook;

import java.util.ArrayList;

/**
 * Created by jiaqichen on 6/14/17.
 */
public class LongestIncreasingSequence {
    public static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(nums.length > 0) list.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
            }else{
                bs(list, 0, list.size() - 1, nums[i]);
            }
        }
        return list.size();
    }

    private static void bs(ArrayList<Integer> dp, int start, int end, int target) {
        start -= 1;
        end += 1;
        while(end - start > 1) {
            int mid = (end - start)/2 + start;
            if((mid - 1 >= 0 && dp.get(mid) >= target && dp.get(mid-1) <= target) || (mid - 1 < 0 && dp.get(mid) >= target)){
                dp.set(mid, target);
                return;
            }else if(dp.get(mid) > target) {
                end = mid;
            }else {
                start = mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,55,66,2,3,4};
        System.out.println(lengthOfLIS(nums));
    }
}
