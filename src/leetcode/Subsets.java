package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> getsubsets(int[] S, int index){
		List<List<Integer>> subsets;
		if(index==-1){
			subsets = new ArrayList<List<Integer>>();
			List<Integer> sub = new LinkedList<Integer>();
			subsets.add(sub);
			return subsets;
		}
		subsets = getsubsets(S,index-1);
		int item = S[index];
		List<List<Integer>> moresubsets = new ArrayList<List<Integer>>();
		for(List<Integer> subset:subsets){
			List<Integer> sub = new LinkedList<Integer>();
			sub.addAll(subset);
			sub.add(item);
			if(!moresubsets.contains(sub))
				moresubsets.add(sub);
		}
		subsets.addAll(moresubsets);
		return subsets;
	}
	public static List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		S = mergeSort(S);
		result = getsubsets(S,S.length-1);
		return result;
    }
	public static int[] merge(int[] a, int[] b){
		int[] c = new int[a.length+b.length];
		int i=0, j=0, k=0;
		while(k<c.length){
			if(i==a.length || j==b.length){
				if(i==a.length && j!=b.length){
					c[k] = b[j];
					j++;
				}
				if(i!=a.length && j==b.length){
					c[k] = a[i];
					i++;
				}
			}else{
				c[k] = Math.min(a[i], b[j]);
				if(Math.min(a[i], b[j]) == a[i])
					i++;
				else
					j++;
			}
			k++;
		}
		return c;
	}
	public static int[] mergeSort(int[] array){
		int length = array.length;
		int n = length/2;
		if(length==1){
			return array;
		}else{
			int[] a = Arrays.copyOfRange(array, 0, n);
			int[] b = Arrays.copyOfRange(array, n, array.length);
			return merge(mergeSort(a),mergeSort(b));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		List<List<Integer>> result = subsets(nums);
		}
	}
