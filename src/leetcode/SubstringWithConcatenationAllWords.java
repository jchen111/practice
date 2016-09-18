package leetcode;

import java.util.*;

/**
 * Created by jacky on 9/17/16.
 */
public class SubstringWithConcatenationAllWords {


    public static boolean checkMatch(char[] s, int wordsLen, int wordLen, HashMap<String,Integer> map){
        if(s.length != wordsLen * wordLen){
            return false;
        }
        int left = 0;
        int right = s.length - wordLen;
        while(left < right){
            String leftString = String.valueOf(s,left,wordLen);
            String rightString = String.valueOf(s,right, wordLen);

            if(!map.containsKey(leftString) || !map.containsKey(rightString)){
                return false;
            }

            if(!leftString.equals(rightString)){
                if(map.containsKey(leftString)) {
                    int val = map.get(leftString);
                    if (val != 1) {
                        map.put(leftString, val - 1);
                    } else {
                        map.remove(leftString);
                    }
                    left += wordLen;
                }

                if(map.containsKey(rightString)) {
                    int val = map.get(rightString);
                    if (val != 1) {
                        map.put(rightString, val - 1);
                    } else {
                        map.remove(rightString);
                    }
                    right -= wordLen;
                }

            }else{
                if(map.containsKey(leftString)) {
                    int val = map.get(leftString);
                    if (val < 2) {
                        return false;
                    } else {
                        map.put(leftString, val - 2);
                        left += wordLen;
                        right -= wordLen;
                    }
                }
            }
        }
        if(left == right){
            String str = String.valueOf(s,left,wordLen);
            if(!map.containsKey(str) || map.get(str) != 1){
                return false;
            }
        }

        return true;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> wordsVault = new HashMap<String,Integer>();
        List<Integer> toReturn = new LinkedList<Integer>();
        int k = words[0].length();
        int N = s.length();
        if(s.length() == 0 || words.length == 0 || k > N || k * words.length > N){
            return toReturn;
        }

        for(int i = 0; i < words.length; i++){ // loop through words.length
            if(wordsVault.containsKey(words[i])){
                int val = wordsVault.get(words[i]);
                wordsVault.put(words[i],val+1);
            }else {
                wordsVault.put(words[i],1);
            }
        }

        char[] chs = s.toCharArray();
        HashMap<String,Integer> map;
        for(int i = 0; i <= N - k * words.length; i++){
            String toCheck = String.valueOf(chs, i, k * words.length);
            map = new HashMap<String,Integer>(wordsVault);
            if(checkMatch(toCheck.toCharArray(),words.length,k,map)){
                toReturn.add(i);
            }
        }

        return toReturn;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int N = sc.nextInt();
        String[] words = new String[N];
        for(int i = 0; i < N; i++){
            words[i] = sc.next();
        }

        List<Integer> result = findSubstring(s,words);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }
}
