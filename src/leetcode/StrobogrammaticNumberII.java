package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaqichen on 11/4/16.
 */
public class StrobogrammaticNumberII {
    static List<String> result;
    static HashMap<Character,Character> dic;
    public static List<String> findStrobogrammatic(int n) {
        result = new ArrayList<String>();
        dic = new HashMap<Character,Character>();
        dic.put('0','0');
        dic.put('1','1'); dic.put('6','9');
        dic.put('9','6'); dic.put('8','8');
        helper("1",n-1);
        helper("6",n-1);
        helper("8",n-1);
        helper("9",n-1);
        return result;
    }

    public static void helper(String s, int n){
        if(n == 0){
            if(checkStrobogrammatic(s))
                result.add(s);
            return;
        }

        for(Character c : dic.keySet()){
            StringBuilder tmp = new StringBuilder(s);
            tmp.append(c);
            helper(tmp.toString(),n-1);
        }
        return;
    }

    public static boolean checkStrobogrammatic(String s){
        int k = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(!dic.containsKey(s.charAt(i)) || s.charAt(k) != dic.get(s.charAt(i))){
                return false;
            }
            k++;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        findStrobogrammatic(n);
    }
}
