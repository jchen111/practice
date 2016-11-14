package leetcode;

import java.util.*;

/**
 * Created by jiaqichen on 11/6/16.
 */
public class WordSquares {
    static List<List<String>> result;
    static HashMap<Integer,HashSet<String>> dict;
    public static List<List<String>> wordSquares(String[] words) { // n words, each word has length k
        result = new ArrayList<List<String>>();
        int wordsLen = words.length;
        if(wordsLen == 0) return result;
        int wordLen = words[0].length();
        dict = new HashMap<Integer,HashSet<String>>();

        for(int i = 0; i < wordLen; i++){ // O(k)
            dict.put(i+1,new HashSet<String>());
        }

        // O(k*n)
        for(String s : words){
            for(int i = 0; i < wordLen; i++){
                HashSet<String> set = dict.get(i+1);
                set.add(s.substring(0,i+1));
                dict.put(i+1,set);
            }
        }

        // O(k*n*n)
        helper(wordLen, new ArrayList<String>(), words, new HashMap<Integer,String>());
        return result;
    }

    public static void helper(int wordLen, List<String> list, String[] pool, HashMap<Integer,String> vertical) {
        if(list.size() == wordLen){
            boolean feasible = true;
            // O(k)
            for(int i = 0; i < vertical.size(); i++){
                if(!vertical.get(i).equals(list.get(i))){
                    feasible = false;
                    break;
                }
            }
            if(feasible) result.add(list);
            return;
        }

        ArrayList<String> sublist;
        HashMap<Integer,String> tmpVertical;
        //O(k*n)
        for(String s : pool){ // O(n)
            boolean feasible = true;
            tmpVertical = new HashMap<Integer,String>(vertical);
            sublist = new ArrayList<>(list);
            for(int i = 0; i < s.length(); i++){ // O(k)
                if(!tmpVertical.containsKey(i)) {
                    if (!dict.get(list.size() + 1).contains("" + s.charAt(i))) {
                        feasible = false;
                        break;
                    }
                    tmpVertical.put(i,"" + s.charAt(i));
                }else{
                    String verticalString = tmpVertical.get(i) + s.charAt(i);
                    if(!dict.get(list.size() + 1).contains(verticalString)){
                        feasible = false;
                        break;
                    }
                    tmpVertical.put(i, verticalString);
                }
            }
            if(feasible) {
                sublist.add(s);
                helper(wordLen, new ArrayList<>(sublist), pool, tmpVertical);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = new String[N];
        for(int i = 0; i < N; i++){
            words[i] = sc.next();
        }
        List<List<String>> res = wordSquares(words);
        for(List<String> list : res){
            System.out.println("[");
            for(String s : list){
                System.out.println(s);
            }
            System.out.println("]");
        }
    }

}
