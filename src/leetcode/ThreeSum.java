package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	Hashtable<String,Boolean> table = new Hashtable<String,Boolean>();
    	Arrays.sort(num);
    	for(int i=0;i<num.length-2;i++){
    		int left =i+1;
    		int right = num.length-1;
    		while(left<right){
    			if(num[i]+num[left]+num[right]>0){
    				right--;
    			}else if(num[i]+num[left]+num[right]<0){
    				left++;
    			}else{
    				List<Integer> sub = new LinkedList<Integer>();
    				String s = "";
    				sub.add(num[i]);
    				s+=num[i];
    				sub.add(num[left]);
    				s+=num[left];
    				sub.add(num[right]);
    				s+=num[right];
    				if(!table.containsKey(s)){
    					res.add(sub);
    					table.put(s, true);
    				}
    				left++;
    			}
    		}
    	}
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> res = threeSum(nums);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}
