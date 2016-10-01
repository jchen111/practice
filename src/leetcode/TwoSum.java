package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class TwoSum {
	public static int[] twoSum(int[] numbers, int target){
		int copytarget = target;
		int[] output = new int[2];
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
		for(int i=0;i<numbers.length;i++){
			table.put(numbers[i],i);
		}
		for(int i=0;i<numbers.length;i++){
			target-=numbers[i];
			if(table.containsKey(target) && table.get(target)>i){
				output[0] = Math.min(i, table.get(target));
				output[1] = Math.max(i, table.get(target));
				break;
			}else{
				target = copytarget;
			}
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] numbers = {0,0};
        int[] output = twoSum(numbers,0);
        System.out.println(output[0]+" "+output[1]);
	}

}
