package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
	static List<List<String>> res = new LinkedList<List<String>>();
	static List<String> list = new LinkedList<String>();
    public static List<List<String>> partition(String s) {
    	if(s.length()==0) return res;
    	helper(s);
        return res;
    }
    public static void helper(String str){
    	if(str.length()==0){
    		res.add(new LinkedList<String>(list));
    		return;
    	}
    	for(int i=1;i<=str.length();i++){
    		if(isPalindrome(str.substring(0, i))){
    			list.add(str.substring(0, i));
    			helper(str.substring(i));
    			list.remove(list.size()-1);
    		}
    	}
    }
    public static boolean isPalindrome(String str){
    	int s = 0;
    	int e = str.length()-1;
    	while(s<e){
    		if(str.charAt(s)!=str.charAt(e)) return false;
    		s++;
    		e--;
    	}
    	return true;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> res = partition("aaa");
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}



}
