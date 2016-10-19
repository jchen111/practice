package leetcode;

import org.hamcrest.core.Is;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/17/16.
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int i = 0, j = 0;
        HashMap<Character,Character> mapS = new HashMap<Character,Character>();
        HashMap<Character,Character> mapT = new HashMap<Character,Character>();
        while(i < s.length() && j < t.length()){
            char sc = s.charAt(i);
            char tc = t.charAt(j);
            if(mapS.containsKey(sc)){
                if(mapS.get(sc) != tc)
                    return false;
            }else{
                if(mapT.containsKey(tc)){
                    if(mapT.get(tc) != sc)
                        return false;
                }else{
                    mapS.put(sc,tc);
                    mapT.put(tc,sc);
                }
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(isIsomorphic(s,t));
    }
}
