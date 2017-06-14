package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by z001ktb on 6/6/17.
 */
public class LongestSubstringWithKrepeating {

    public static int longestSubstring(String s, int k) {
        int right = s.length() - 1;
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int occur = map.containsKey(c)? map.get(c) : 0;
            map.put(c, ++occur);
        }

        while(right >= 0 && map.get(s.charAt(right)) < k) {
            right--;
        }

        if(right < 0) return max;

        int left = right;

        while(right >= 0) {
            while(left >= 0 && map.get(s.charAt(left)) >= k) {
                left--;
            }
            max = Math.max(max, right - left);
            while(left >=0 && map.get(s.charAt(left)) < k) {
                left--;
            }
            right = left;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aaabb";
        System.out.println(longestSubstring(s,2));
    }
}
