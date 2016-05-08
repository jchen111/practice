package leetcode;

import java.util.Arrays;
import java.util.Hashtable;

public class MajorityElement {
	public static int majorityElement(int[] num) {
        int length = num.length;
        Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
        table.put(num[0], 1);
        int max = 1;
        int output=num[0];
        for(int i=1;i<length;i++){
        	if(!table.containsKey(num[i])){
        		table.put(num[i], 1);
        	}else{
        		if(table.get(num[i])+1>max){
        			max = table.get(num[i])+1;
        			output = num[i];
        		}
        		table.replace(num[i], table.get(num[i])+1);
        	}
        }
        return output;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,3,4};
		int[] b = {2,1,1,2,2,1,1};
		System.out.println(majorityElement(b));
	}
}
