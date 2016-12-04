package leetcode;

import java.util.*;

/**
 * Created by jiaqichen on 11/6/16.
 */
public class WordSquares {
    static List<List<String>> result;
    static HashMap<String,List<String>> dict;
    public static List<List<String>> wordSquares(String[] words) { // n words, each word has length k
        result = new ArrayList<List<String>>();
        int wordsLen = words.length;
        if(wordsLen == 0) return result;
        int wordLen = words[0].length();
        dict = new HashMap<String,List<String>>();

        // O(k*n) build possible prefixe dictionary, for more efficient way please reference Tire
        for(String s : words){
            for(int i = 0; i < wordLen; i++){
                String key = s.substring(0,i+1);
                List<String> list = dict.containsKey(key)? dict.get(key): new ArrayList<String>();
                list.add(s);
                dict.put(key,list);
            }
        }

        // O(n*n) dfs
        List<String> curList = new ArrayList<String>();
        for(String word: words){
            curList.add(word);
            dfs(wordLen, curList, words);
            curList.remove(curList.size()-1);
        }
        return result;
    }

    public static void dfs(int wordLen, List<String> curList, String[] pool) {
        if(curList.size() == wordLen){
            result.add(new ArrayList<String>(curList));
            return;
        }

        StringBuilder prefix = new StringBuilder();
        int col = curList.size();

        for(String s: curList){
            prefix.append(s.charAt(col));
        }

        List<String> startWith = dict.get(prefix.toString()) != null ? dict.get(prefix.toString()) : new ArrayList<String>();
        for(String sw : startWith){
            curList.add(sw);
            dfs(wordLen,curList,pool);
            curList.remove(curList.size()-1);
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
