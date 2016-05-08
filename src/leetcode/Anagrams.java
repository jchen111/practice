package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class Anagrams {
    public static List<String> anagrams(String[] strs) {
    	if(strs.length==0) return null;
        List<String> res = new LinkedList<String>();
        Hashtable<String,String> table = new Hashtable<String,String>();
        Boolean flag = false;
        HashSet<String> marks = new HashSet<String>();
        if(strs.length==1) return res;
        for(int i=0;i<strs.length;i++){
        	char[] c = strs[i].toCharArray();
        	Arrays.sort(c); 
        	String s = new String(c);
        	if(!table.containsKey(s)){
        		table.put(s, strs[i]);
        	}else{
        		flag = true;
        		marks.add(s);
        		res.add(strs[i]);
        	}
        }
        if(flag){
        	for(String mar:marks){
        		res.add(table.get(mar));
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] strs = {"ape","pea","tax"};
//		String[] strs1 = {"tea","and","ate","eat","dan"};
//		List<String> res = anagrams(strs);
//		for(int i=0;i<res.size();i++){
//			System.out.println(res.get(i));
//		}
		for ( int i = 1; i <= 9; i++ ) {
		    for ( int j = 1; j <= 9; j++ ) {
		      System.out.print ( String.format ( "%4d", j * i ));
		    }
		  System.out.println();
		  }
	}

}
