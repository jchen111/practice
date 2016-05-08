package leetcode;

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,3,6,7};
		List<List<Integer>> re = combinationSum(candidates,7);
		for(int i=0;i<re.size();i++){
			for(int j=0;j<re.get(i).size();j++){
				System.out.print(re.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}
