package leetcode;

import java.util.Stack;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
    	s = s.toLowerCase();
    	s = s.replaceAll("[^0-9a-zA-Z]", "");
    	int i=0, j = s.length()-1;
        while(i<j){
        	if(s.charAt(i)!=s.charAt(j)) return false;
        	i++;
        	j--;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isPalindrome("1a2"));
	}

}
