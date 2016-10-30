package leetcode;

import java.util.*;

/**
 * Created by jiaqichen on 10/29/16.
 */
public class AlienDictionary {

    public static String alienOrder(String[] words) {
        if(words.length == 0) return "";
        HashMap<Character,HashSet<Character>> map = new HashMap<Character,HashSet<Character>>();
        HashMap<Character,Integer> dic = new HashMap<Character,Integer>();

        for(String s : words){
            for(Character c : s.toCharArray()){
                dic.put(c,0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String str1 = words[i];
            String str2 = words[i+1];
            int len = Math.min(str1.length(),str2.length());
            for(int j = 0; j < len; j++){
                Character c1 = str1.charAt(j);
                Character c2 = str2.charAt(j);
                if(c1 != c2){
                    HashSet<Character> set;
                    if(!map.containsKey(c1)){
                        set = new HashSet<Character>();
                    }else{
                        set = map.get(c1);
                    }

                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1,set);
                        dic.put(c2,dic.get(c2)+1);
                    }
                    break;
                }else{
                    if(j+1 <= str1.length()-1 && j+1 > str2.length()-1) return "";
                }
            }
        }

        Queue<Character> queue = new LinkedList<Character>();
        for( Character key : dic.keySet()){
            if(dic.get(key) == 0) queue.add(key);
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            char c = queue.remove();
            sb.append(c);
            if(map.containsKey(c)){
                for(char c2 : map.get(c)){
                    dic.put(c2,dic.get(c2)-1);
                    if(dic.get(c2) == 0) queue.add(c2);
                }
            }
        }
        if(sb.length() != dic.size()) return "";
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = new String[N];
        for(int i = 0; i < N; i++){
            words[i] = sc.next();
        }
        System.out.println(alienOrder(words));
    }

}
