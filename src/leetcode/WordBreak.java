package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordBreak {
	//failed at last test case
    public static boolean wordBreak(String s, Set<String> dict) {
    	s = s.replace(" ", "");
    	if(dict.contains(s)){
    		return true;
    	}
        int length = s.length();
        int i=1;
        while(i<=length-1){
        	String sub = s.substring(0, i);
        	if(dict.contains(sub)){
        		s = s.substring(i, length);
        		if(s.isEmpty()) return true;
        		else return wordBreak(s,dict);
        	}
        	i++;
        }
        return false;
    }
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
		String s = "fohhemkka";
		dict.add("fo");
		dict.add("fohhemkka");
		System.out.println(wordBreak2(s,dict));
	}

}
