package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaqichen on 11/5/16.
 */
public class FindAllAnagramsInString {
//    public static List<Integer> findAnagrams(String s, String p) {
//        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//        List<Integer> result = new ArrayList<Integer>();
//        if(s.isEmpty() || p.isEmpty() || s.length() < p.length()) return result;
//        for(int i = 0; i < p.length(); i++){
//            char c = p.charAt(i);
//            int val = map.containsKey(c) ? map.get(c)+1:1;
//            map.put(c,val);
//        }
//
//        HashMap<Character,Integer> tmpmap = new HashMap<Character,Integer>(map);
//        for(int i = 0; i <= s.length() - p.length(); i++){
//            for(int j = i; j < i + p.length(); j++){
//                if(tmpmap.containsKey(s.charAt(j))){
//                    int val = tmpmap.get(s.charAt(j)) - 1;
//                    tmpmap.put(s.charAt(j),val);
//                    if(val == 0) tmpmap.remove(s.charAt(j));
//                    if(tmpmap.size() == 0){
//                        result.add(i);
//                        tmpmap = new HashMap<Character,Integer>(map);
//                    }
//                }else{
//                    tmpmap = new HashMap<Character,Integer>(map);
//                    break;
//                }
//            }
//        }
//        return result;
//    }

    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        List<Integer> result = new ArrayList<Integer>();
        if(s.isEmpty() || p.isEmpty() || s.length() < p.length()) return result;
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            int val = map.containsKey(c) ? map.get(c)+1:1;
            map.put(c,val);
        }

        HashMap<Character,Integer> tmpmap = new HashMap<Character,Integer>(map);
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(tmpmap.containsKey(c)){
                int val = tmpmap.get(c) - 1;
                tmpmap.put(c,val);
                if(val == 0) tmpmap.remove(c);
            }

            if(tmpmap.size() == 0){
                result.add(left);
            }
            right++;

            if(right - left == p.length()){
                char ch = s.charAt(left);
                if(map.containsKey(ch) && ch != c){
                    int val = 1;
                    if(tmpmap.containsKey(ch)){
                        val = tmpmap.get(ch) + 1;
                        tmpmap.put(ch,Math.min(val,map.get(ch)));
                    }else{
                        tmpmap.put(ch,val);
                    }
                }
                left++;
            }
        }
        return result;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) {
                list.add(left);
            }
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() ) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;

            }


        }
        return list;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        findAnagrams(s,p);
    }

}
