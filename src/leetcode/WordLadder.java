package leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Collection;

public class WordLadder {
	public  static int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> strqueue = new LinkedList<String>();
        Queue<Integer> strdist = new LinkedList<Integer>();
        Set<String> visited = new HashSet<String>();
        strqueue.add(start);
        strdist.add(1);
        int dist = Integer.MAX_VALUE;
        while(!strqueue.isEmpty() && !strdist.isEmpty()){
        	String currentstr = strqueue.remove();
        	int currentdist = strdist.remove();
        	for(int i=0;i<currentstr.length();i++){
        		char[] strarray = currentstr.toCharArray();
        		for(char c='a';c<='z';c++){
        			strarray[i] = c;
        			if(end.equals(new String(strarray))){
        				return Math.min(dist, currentdist+1);
        			}
        			else if(!visited.contains(new String(strarray)) && dict.contains(new String(strarray))){
        				visited.add(new String(strarray));
        				strqueue.add(new String(strarray));
        				strdist.add(currentdist+1);
        			}
        		}
        	}
        }
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");dict.add("dot");dict.add("dog");
		dict.add("lot");dict.add("log");
		int res = ladderLength(start,end,dict);
		System.out.println(res);
	}

}
