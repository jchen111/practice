package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class GrayCode {
	static public HashSet<Integer> set;
	public static List<Integer> grayCode(int n) {
		set = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		int[] bits = new int[n];
		set.add(0);
		list.add(0);
		helper(bits,bits.length-1,n,list);
		return list;
	}
	public static void helper(int[] bits, int index, int n, List<Integer> list){
		if(set.size() == Math.pow(2,n)){
			return;
		}
		if(index < 0){
			index = bits.length - 1;
		}

		if(bits[index] == 0){
			bits[index] = 1;
			if(set.contains(toInt(bits))){
				bits[index] = 0;
			}
		}else{
			bits[index] = 0;
			if(set.contains(toInt(bits))){
				bits[index] = 1;
			}
		}

		int tmp = toInt(bits);
		if(set.add(tmp)){
			list.add(tmp);
			helper(bits,bits.length-1,n,list);
		}else{
			helper(bits,index-1,n,list);
		}
	}

	public static int toInt(int[] bits){
		int sum = 0;
		int n = 0;
		for(int i = bits.length - 1; i >= 0; i--){
			sum += (bits[i] * Math.pow(2,n));
			n++;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> result = grayCode(N);
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i)+" ");
		}
	}

}
