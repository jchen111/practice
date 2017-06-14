package leetcode;

import java.util.*;

public class Permutations {
//	public static List<List<Integer>> permute(int[] num) {
//		if(num==null) return null;
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        int length = num.length;
//        if(length==0) return new ArrayList<List<Integer>>();
//        if(length==1){
//        	List<Integer> output = new ArrayList<Integer>();
//        	output.add(num[0]);
//        	result.add(output);
//        	return result;
//        }
//        int first = num[0];
//        int[] newnum = Arrays.copyOfRange(num, 1, length);
//        result = permute(newnum);
//        List<List<Integer>> moreresult = new ArrayList<List<Integer>>();
//        for(List<Integer> subresult:result){
//        	for(int i=0;i<=subresult.size();i++){
//        		List<Integer> subline = new ArrayList<Integer>();
//        		subline.addAll(subresult);
//        		subline.add(i, first);
//        		moreresult.add(subline);
//        	}
//        }
//        return moreresult;
//    }

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(nums, new HashSet<Integer>(), result);
		return result;
	}

	public static void helper(int[] nums, Set<Integer> subset, List<List<Integer>> result) {
		if(subset.size() == nums.length){
			result.add(new ArrayList<Integer>(subset));
			return;
		}

		for(int i = 0; i < nums.length; i++){
			if(subset.contains(nums[i])) continue;
			subset.add(nums[i]);
			helper(nums, subset, result);
			subset.remove(nums[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3};
		List<List<Integer>> result = permute(num);
		for(int i=0;i<result.size();i++){
			for(int j=0;j<result.get(i).size();j++){
				System.out.print(result.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}
