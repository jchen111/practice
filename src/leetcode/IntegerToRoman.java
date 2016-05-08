package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IntegerToRoman {
	private static LinkedHashMap<Integer,Character> map = new LinkedHashMap<Integer,Character>();
    public static String intToRoman(int num) {
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        Stack<Integer> stack = new Stack<Integer>();
        int digit=1;
        while(num!=num%10){
        	digit*=10;
        	stack.push(num%10);
        	num/=10;
        }
        stack.add(num);
        String Roman = "";
        List<Integer> keys = new ArrayList(map.keySet());
        while(!stack.isEmpty()){
        	int current = stack.pop();
        	if(current==4 || current==9){
        		if(current==4){
        			int index = keys.indexOf(digit);
        			Roman+=map.get(digit);
        			Roman+=map.get(keys.get(index+1));
        		}
        		if(current==9){
        			int index = keys.indexOf(digit);
        			Roman+=map.get(digit);
        			Roman+=map.get(keys.get(index+2));
        		}
        	}else{
        		if(current>=5){
        			int index = keys.indexOf(digit);
        			Roman+=map.get(keys.get(index+1));
        			current-=5;
        		}
        		for(int i=1;i<=current;i++){
        			Roman+=map.get(digit);
        		}
        	}
        	digit/=10;
        }
        return Roman;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(3999));
	}

}
