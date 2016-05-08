package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Integer> col = new ArrayList<Integer>();
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        getlist(n,k,col,re,1);
        return re;
    }
    
    public static void getlist(int n, int k, ArrayList<Integer> col, List<List<Integer>> re, int start){
        if(col.size()==k){
            ArrayList<Integer> t = new ArrayList<Integer>(col);
            re.add(t);
            return;
        }
        for(int i=start; i<=n; i++){
            col.add(i);
            getlist(n,k,col,re,i+1);
            col.remove(col.size()-1);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = combine(3,2);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}
