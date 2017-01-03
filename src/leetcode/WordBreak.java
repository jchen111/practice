package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordBreak {
    //correct solution
    public static boolean wordBreak2(String s, Set<String> dict){
    	if(s.isEmpty()) return false;
    	if(dict.contains(s)) return true;
    	LinkedList<Integer> starts = new LinkedList<Integer>();
    	starts.add(0);
    	for(int end=1;end<=s.length();end++){
    		for(int i=0;i<starts.size();i++){
    			if(dict.contains(s.substring(starts.get(i), end))){
    				starts.add(0, end);
    				break;
    			}
    		}
    	}
    	return (starts.get(0)==s.length());
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");
		System.out.println(wordBreak2(s,dict));
	}

}
