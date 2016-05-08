package leetcode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

import sun.misc.Queue;

public class LongestSubstringWithoutRepeatingCharacters {
	public static boolean withoutRepeatingLetters(String s){
		int[] table = new int[256];
		for(int i=0;i<s.length();i++){
			if(table[(int) s.charAt(i)] ==0){
				table[(int) s.charAt(i)]+=1;
			}else{
				return false;
			}
		}
		return true;
	}
	public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int iterator=0;
        char[] ch = s.toCharArray();
        LinkedList<Character> queue = new LinkedList<Character>();
        while(iterator<ch.length){
        	if(queue.contains(ch[iterator])){
        		if(queue.size()>max) max = queue.size();
        		while(queue.removeFirst() != ch[iterator]){
        		}
        	}
        	queue.add(ch[iterator]);
        	iterator++;
        }
        
        return Math.max(max, queue.size());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";//12
		String s2 = "hchzvfrkmlnozjk";//11
		String s3 = "qpxrjxkitzyxacbhhkicqc";//10
		LinkedList queue = new LinkedList();
//		System.out.println(s2.indexOf(s2.charAt(2)));
		System.out.println(lengthOfLongestSubstring(s3));
	}

}
