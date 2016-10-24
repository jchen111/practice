package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by z001ktb on 10/22/16.
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        if(str.isEmpty() || pattern.isEmpty()) return false;
        str = str.trim();
        String[] strs = str.split(" ");
        if(strs.length != pattern.length()) return false;
        HashMap<Character,String> map = new HashMap<Character,String>();
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(strs[i]))
                    return false;
            }else{
                if(!set.contains(strs[i])) {
                    map.put(c, strs[i]);
                    set.add(strs[i]);
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pattern = sc.next();
        System.out.println(wordPattern(pattern,str));
    }
}
