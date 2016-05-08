package leetcode;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res;
		if(numRows==1){
			List<Integer> layer = new LinkedList<Integer>();
			layer.add(1);
			res = new LinkedList<List<Integer>>();
			res.add(layer);
			return res;
		}
		res = generate(numRows-1);
		List<Integer> pre = res.get(res.size()-1);
		List<Integer> layer = new LinkedList<Integer>();
		layer.add(1);
		for(int i=0;i<pre.size()-1;i++){
			layer.add(pre.get(i)+pre.get(i+1));
		}
		layer.add(1);
		List<List<Integer>> moreres = new LinkedList<List<Integer>>();
		moreres.addAll(res);
		moreres.add(layer);
		return moreres;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = generate(5);
	}

}
