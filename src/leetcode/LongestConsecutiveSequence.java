package leetcode;

import java.util.HashMap;
import java.util.Hashtable;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] num) {
    	if(num==null) return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int res = 0;
        int max = 0;
        for(int i=0;i<num.length;i++){
        	if(!map.containsKey(num[i])){
        		int left = (map.containsKey(num[i]-1))? map.get(num[i]-1):0;
        		int right = (map.containsKey(num[i]+1))? map.get(num[i]+1):0;
        		res = left+right+1;
        		map.put(num[i], res);
        		max = Math.max(max, res);
        		if(map.containsKey(num[i]-left)) map.put(num[i]-left, res);
        		if(map.containsKey(num[i]+right)) map.put(num[i]+right, res);
        	}
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {0,3,7,2,5,8,4,6,0,1};
		System.out.println(longestConsecutive(num));
	}

}
