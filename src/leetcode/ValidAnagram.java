package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by z001ktb on 12/31/16.
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            int value = map.containsKey(s.charAt(i))? map.get(s.charAt(i))+1 : 1;
            map.put(s.charAt(i),value);
            value = map.containsKey(t.charAt(i))? map.get(t.charAt(i))-1 : -1;
            map.put(t.charAt(i),value);
            if(map.get(t.charAt(i)) == 0) map.remove(t.charAt(i));
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
        }
        return map.size() == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        isAnagram(s,t);
    }
}
