package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jiaqichen on 10/30/16.
 */
public class DecodeString {
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        if(s.isEmpty()) return res.toString();
        Stack<String> resStack = new Stack<String>();
        Stack<Integer> countStack = new Stack<Integer>();
        HashSet<Character> nums = new HashSet<Character>();
        StringBuilder countString = new StringBuilder();
        char[] chs = {'0','1','2','3','4','5','6','7','8','9'};
        for(int i = 0; i < chs.length; i++){
            nums.add(chs[i]);
        }
        int i = 0;
        while(i < s.length()) {
            while(nums.contains(s.charAt(i))){
                countString.append(s.charAt(i));
                i++;
            }
            if(countString.length() != 0){
                int count = Integer.valueOf(countString.toString());
                countStack.push(count);
                countString = new StringBuilder();
            }

            if(s.charAt(i) == ']'){
                StringBuilder tmp = new StringBuilder(resStack.pop());
                int occur = countStack.pop();
                for(int j = 0; j < occur; j++){
                    tmp.append(res);
                }
                res = tmp;
                i++;

            }else if(s.charAt(i) == '['){
                resStack.push(res.toString());
                res = new StringBuilder();
                i++;
            }else{
                res.append(s.charAt(i));
                i++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(decodeString(s));
    }
}
