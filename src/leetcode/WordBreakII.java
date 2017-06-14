package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by z001ktb on 6/3/17.
 */
public class WordBreakII {

    public static String wordBreakII(String s, List<String> wordDict) {
        return dfs(s, new StringBuilder(), wordDict);
    }

    // O()  assume length of wordDict is m, length of s is n
    public static String dfs(String s, StringBuilder sentence, List<String> wordDict) {
        if(wordDict.contains(s)){ // O(m)
            sentence.append(' ');
            sentence.append(s);
            return sentence.toString();
        }

        for(String word : wordDict) { // O(m)
            if(s.startsWith(word)){ // O(n)
                String res = dfs(s.substring(word.length()), sentence.length() == 0? sentence.append(word) : sentence.append(' ').append(word), wordDict);
                if(!res.isEmpty()) return res;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> wordDict = new ArrayList<>();
        String s = sc.next();
        int n = sc.nextInt();
        for(int i  = 0; i < n; i++){
            wordDict.add(sc.next());
        }

        System.out.println(wordBreakII(s,wordDict));
    }
}
