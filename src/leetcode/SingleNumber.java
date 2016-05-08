package leetcode;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

public class SingleNumber {
	public static int singleNumber(int[] A){
		if(A.length==1) return A[0];
		Hashtable<Integer,Boolean> table = new Hashtable<Integer,Boolean>();
		for(int i=0;i<A.length;i++){
			if(!table.containsKey(A[i])){
				table.put(A[i],true);
			}else{
				table.replace(A[i], true, false);
			}
		}
		Enumeration e = table.keys();
		while(e.hasMoreElements()){
			int target = (int) e.nextElement();
			if(table.get(target)==true){
				return target;
			}
		}
		return 0;
	}
	public static int singleNumber2(int[] A){
		if(A.length==1) return A[0];
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
		for(int i=0;i<A.length;i++){
			if(!table.containsKey(A[i])){
				table.put(A[i],1);
			}else{
				int val = table.get(A[i]);
				table.replace(A[i], val, val+1);
			}
		}
		Enumeration e = table.keys();
		while(e.hasMoreElements()){
			int target = (int) e.nextElement();
			if(table.get(target)==1){
				return target;
			}
		}
		return 0;
	}
	public static int singleNumber3(int[] nums){
		int result = 0;
		for(int i=0;i<nums.length;i++){
			result^=nums[i];
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5,5,4,4,1};
//		System.out.println(singleNumber3(A));
	}

}
