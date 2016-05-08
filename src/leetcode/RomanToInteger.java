package leetcode;

import java.util.HashMap;

public class RomanToInteger {
	private static HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    public static int romanToInt(String s) {
       map.put('I', 1);
       map.put('V', 5);
       map.put('X', 10);
       map.put('L', 50);
       map.put('C', 100);
       map.put('D', 500);
       map.put('M', 1000);
       int prenum = map.get(s.charAt(0));
       int result = map.get(s.charAt(0));
       for(int i=1;i<s.length();i++){
    	   result+=map.get(s.charAt(i));
    	   if(prenum<map.get(s.charAt(i))){
    		   result -= 2*prenum;
    	   }
    	   prenum = map.get(s.charAt(i));
       }
       return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("DCC"));
	}

}
