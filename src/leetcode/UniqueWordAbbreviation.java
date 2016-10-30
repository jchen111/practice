package leetcode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/24/16.
 */
public class UniqueWordAbbreviation {
    static HashMap<String,Integer> map;
    public static void ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String,Integer>();
        for(int i = 0; i < dictionary.length; i++){
            if(dictionary[i].length() > 0){
                if(dictionary[i].length() <= 2){
                    int val = (map.containsKey(dictionary[i])) ? map.get(dictionary[i]):0;
                    map.put(dictionary[i],val+1);
                }
                else{
                    int len = dictionary[i].length();
                    String tmp = ""+dictionary[i].charAt(0) + (len-2) + dictionary[i].charAt(len - 1);
                    int val = map.containsKey(tmp) ? map.get(tmp) : 0;
                    map.put(tmp,val+1);
                }
            }
        }
    }

    public static boolean isUnique(String word) {
        if(map.size() == 0 ) return true;
        if(map.size() != 0 && word.isEmpty()) return true;
        if(word.length() <= 2){
            if(!map.containsKey(word)) return false;
            if(map.get(word) == 1) return true;
        }else{
            int len = word.length();
            String tmp = "" + word.charAt(0) + (len-2) + word.charAt(len - 1);
            if(!map.containsKey(tmp)) return false;
            if(map.get(tmp) == 1) return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String dic[] = new String[N];
        for(int i = 0; i < N; i++){
            dic[i] = sc.next();
        }
        ValidWordAbbr(dic);
        System.out.println(isUnique("a"));
    }


}
