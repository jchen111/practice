package google;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by jiaqichen on 11/21/16.
 */
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        if(k >= num.length()) return "0";
        LinkedList<Character> stack = new LinkedList<Character>();
        int t = k;
        for(int i = 0; i < num.length(); i++){
            while(!stack.isEmpty() && num.charAt(i) < stack.getLast() && t > 0){
                stack.removeLast();
                t--;
            }
            stack.add(num.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while(i < stack.size() && stack.get(i) == '0'){
            i++;
        }
        if(i == stack.size()) return "0";
        for(;i < num.length()-k; i++){
            result.append(stack.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(removeKdigits(s,k));
    }
}
