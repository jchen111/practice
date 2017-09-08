package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> solution, int[] nums, int index) {
        result.add(new ArrayList<>(solution));
        for(int i = index; i < nums.length; i++) {
            if(i == index || nums[i] != nums[i - 1]) {
                solution.add(nums[i]);
                backtrack(result, solution, nums, i + 1);
                solution.remove(solution.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
