package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<List<Integer>> re = new LinkedList<List<Integer>>();
    	List<Integer> sub = new LinkedList<Integer>();
    	helper(candidates,0,re,sub,target);
    	return re;
    }
    public static void helper(int[] candidates, int start,List<List<Integer>> re, List<Integer> sub,int target){
    	if(target==0){
    		List<Integer> newsub = new LinkedList<Integer>(sub);
    		re.add(newsub);
    		return;
    	}
    	for(int i=start;i<candidates.length;i++){
    		if(candidates[i]<=target){
    			sub.add(candidates[i]);
    			helper(candidates,i,re,sub,target-candidates[i]);
    			sub.remove(sub.size()-1);
    		}
    	}
    }

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(candidates.length == 0) return result;
		Arrays.sort(candidates);
		backtrack(result, new ArrayList<Integer>(), candidates, target, 0, 0);
		return result;
	}

	public static void backtrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int sum, int cur) {
		if(sum > target) return;
		if(sum == target){
			result.add(new ArrayList<Integer>(list));
		}

		for(int i = cur; i < candidates.length; i++) {
			if(i > cur && candidates[i-1] == candidates[i]) continue; //skip duplicates
			list.add(candidates[i]);
			backtrack(result, list, candidates, target, sum + candidates[i], i+1);
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {10,1,2,7,6,1,5};
		List<List<Integer>> re = combinationSum2(candidates,8);
		for(int i=0;i<re.size();i++){
			for(int j=0;j<re.get(i).size();j++){
				System.out.print(re.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}
