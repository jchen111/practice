package google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jiaqichen on 11/27/16.
 */
public class PalindromePermutation {
    public static boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            int val = map.containsKey(s.charAt(i))? map.get(s.charAt(i))+1:1;
            map.put(s.charAt(i),val);
        }
        if(s.length() % 2 == 0){
            for(Character key: map.keySet()){
                if(map.get(key) % 2 != 0) return false;
            }
        }else{
            int oddCount = 0;
            for(Character key: map.keySet()){
                if(map.get(key) % 2 != 0) oddCount++;
                if(oddCount > 1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        canPermutePalindrome(s);
    }
}
