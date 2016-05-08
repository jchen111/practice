package leetcode;

import java.util.Stack;

public class StringToInteger {
    public static int atoi(String str) {
    	if(str.isEmpty()) return 0;
        long digit = 1;
        long res=0;
        Stack<Character> stack = new Stack<Character>();
        int i=0;
        boolean mark = false;
        boolean min = false;
        while(str.charAt(i)==' '){
        	i++;
        }
        for(;i<str.length();i++){
        if(((int)str.charAt(i)>=48 && (int)str.charAt(i)<=57) || str.charAt(i)=='-' || str.charAt(i)=='+'){
    		if((str.charAt(i)=='-' || str.charAt(i)=='+') && !mark){
    			if(str.charAt(i)=='-') min = true;
    			mark = true;
    		}else if((str.charAt(i)=='-' || str.charAt(i)=='+') && mark){
    			return 0;
    		}else{
    			stack.push(str.charAt(i));
    		}
    	}else if(stack.isEmpty()){
    		return 0;
    	}else{
    		break;
    	}
        }
        if(min){
        	res = digit*Character.getNumericValue(stack.pop())*(-1);
        	digit*=10;
        	while(!stack.isEmpty()){
        		res-=digit*Character.getNumericValue(stack.pop());
        		if(res<Integer.MIN_VALUE)
        			return Integer.MIN_VALUE;
        		digit*=10;
        	}

        }else{
        	while(!stack.isEmpty()){
        		char  current = stack.pop();
        		if(digit>Integer.MAX_VALUE || digit*Character.getNumericValue(current)>Integer.MAX_VALUE){
        			return Integer.MAX_VALUE;
        		}
        		res+=digit*Character.getNumericValue(current);
        		if(res>Integer.MAX_VALUE){
        			return Integer.MAX_VALUE;
        		}
        		digit*=10;
    	}
        }
        return (int)res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(atoi("2147483648"));
	}

}
