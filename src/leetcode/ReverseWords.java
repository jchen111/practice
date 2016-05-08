package leetcode;

import java.util.Stack;

public class ReverseWords {
	public static String reverseWords(String s) {
		if(s.isEmpty()) return "";
		String output = "";
		String[] array = s.split("\\s+");
		int length = array.length;
		for(int i=length-1;i>=0;i--){
			if(!array[i].isEmpty()){
				output+=array[i];
				if(i-1>=0 && !array[i-1].isEmpty()){
					output+=" ";
				}
			}
		}
		return output;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "     ";
		System.out.print(reverseWords(s));
	}

}
