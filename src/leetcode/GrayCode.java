package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static List<Integer> grayCode(int n) {
    	if(n==0) return new ArrayList<Integer>();
    	List<List<Integer>> raw = generate(n);
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<raw.size();i++){
        	int number = 0;
        	int digit=0;
        	for(int j=raw.get(i).size()-1; j>=0; j--){
        		number+=raw.get(i).get(j)*Math.pow(2, digit);
        		digit+=1;
        	}
        	result.add(number);
        }
        return result;
    }
	public static List<List<Integer>> generate(int n){
		return helper(n-1,n);
	}
	public static List<List<Integer>> helper(int index, int n){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(index==0){
			List<Integer> sublist;
			for(int i=0;i<2;i++){
				sublist = new ArrayList<Integer>();
				sublist.add(i);
				list.add(sublist);
			}
			return list;
		}
		list = helper(index-1,n);
		List<List<Integer>> morelist = new ArrayList<List<Integer>>();
		for(int i=0;i<list.size();i++){
			List<Integer> sublist ;
			for(int j=0;j<2;j++){
				sublist = new ArrayList<Integer>();
				sublist.addAll(list.get(i));
				sublist.add(j);
				morelist.add(sublist);
			}
		}
		return morelist;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = grayCode(2);
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i)+" ");
		}
	}

}
