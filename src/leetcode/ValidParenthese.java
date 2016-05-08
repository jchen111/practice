package leetcode;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParenthese {
	public static boolean isValid(String s){
		if(s=="") return false;
		int length = s.length();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<length;i++){
			char now = s.charAt(i);
			switch(now){
			case '(':
				stack.push(now);
				break;
			case '[':
				stack.push(now);
				break;
			case '{':
				stack.push(now);
				break;
			case ')':
				if(stack.isEmpty()) return false;
				char pop = stack.pop();
				if(pop!='(') return false;
				break;
			case ']':
				if(stack.isEmpty()) return false;
				pop = stack.pop();
				if(pop!='[') return false;
				break;
			case '}':
				if(stack.isEmpty()) return false;
				pop = stack.pop();
				if(pop!='{') return false;
				break;
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "}";
		System.out.println(isValid(s));
	}

}
