package leetcode;

import java.util.*;

/**
 * Created by z001ktb on 6/3/17.
 */
public class WordBreakII {

    static String wordBreakIIOneSolution(String s, List<String> wordDict) {
        if(s.isEmpty()) return "";
        int[] dp = new int[s.length() + 1];
        Set<String> set = new HashSet<String>();
        Arrays.fill(dp, -1);
        set.addAll(wordDict);
        dp[0] = 0;
        for(int i = 0; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] != -1 && set.contains(s.substring(j, i))) {
                    dp[i] = j;
                    break;
                }
            }
        }
        if(dp[s.length()] == -1) return "";
        StringBuilder res = new StringBuilder();
        int j = s.length();
        while(j > 0) {
            if(j == s.length()) res.insert(0,s.substring(dp[j], j));
            else res.insert(0,s.substring(dp[j], j) + " ");
            j = dp[j];
        }
        return res.toString();
    }

    public static String wordBreakII(String s, List<String> wordDict) {
        return backtracking(s, new StringBuilder(), wordDict);
    }

    public static String backtracking(String s, StringBuilder sentence, List<String> wordDict) {
        if(wordDict.contains(s)){
            sentence.append(' ');
            sentence.append(s);
            return sentence.toString();
        }

        for(String word : wordDict) {
            if(s.startsWith(word)){
                String res = backtracking(s.substring(word.length()), sentence.length() == 0? sentence.append(word) : sentence.append(' ').append(word), wordDict);
                if(!res.isEmpty()) return res;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        //catsanddog
        Scanner sc = new Scanner(System.in);
        List<String> wordDict = new ArrayList<>();
        String s = sc.next();
        int n = sc.nextInt();
        for(int i  = 0; i < n; i++){
            wordDict.add(sc.next());
        }

        System.out.println(wordBreakIIOneSolution(s,wordDict));
    }
}
