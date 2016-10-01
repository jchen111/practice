package leetcode;

import java.util.LinkedList;
import java.util.Scanner;
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


    public static String reverseWords2(String s) {
		/*
		test cases: ___hello____world
		hello_world
		hello_world____
		____hello____world_____
		helloworld
		 */
		if(s.isEmpty()){
			return "";
		}
		char[] chs = s.toCharArray();
		LinkedList<String> queue = new LinkedList<String>();

		int index = 0;
		StringBuilder sb;
		while(index < chs.length){
			if(chs[index] != 32){
				sb = new StringBuilder();
				while(index < chs.length && chs[index] != 32){
					sb.append(chs[index]);
					index++;
				}
				queue.add(sb.toString());
				if(index == chs.length){
					break;
				}
			}
			index++;
		}
		if(queue.isEmpty()){
			return "";
		}

		StringBuilder res = new StringBuilder();
		int j = queue.size() - 1;
		String str;
		while(j > 0){
			str = queue.get(j);
			if(!str.isEmpty()){
				res.append(str);
				res.append(' ');
			}
			j--;
		}
		res.append(queue.get(0));
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.print(reverseWords2(s));
	}

}
