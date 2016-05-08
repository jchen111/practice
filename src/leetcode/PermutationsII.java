package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public static List<List<Integer>> permuteUnique(int[] num) {
		if(num==null) return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int length = num.length;
        if(length==0) return new ArrayList<List<Integer>>();
        if(length==1){
        	List<Integer> output = new ArrayList<Integer>();
        	output.add(num[0]);
        	result.add(output);
        	return result;
        }
        int first = num[0];
        int[] newnum = Arrays.copyOfRange(num, 1, length);
        result = permuteUnique(newnum);
        List<List<Integer>> moreresult = new ArrayList<List<Integer>>();
        for(List<Integer> subresult:result){
        	for(int i=0;i<=subresult.size();i++){
        		List<Integer> subline = new ArrayList<Integer>();
        		subline.addAll(subresult);
        		subline.add(i, first);
        		if(!moreresult.contains(subline))
        			moreresult.add(subline);
        	}
        }
        return moreresult;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1,2};
		List<List<Integer>> result = permuteUnique(num);
		for(int i=0;i<result.size();i++){
			for(int j=0;j<result.get(i).size();j++){
				System.out.print(result.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
}
