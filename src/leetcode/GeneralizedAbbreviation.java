package leetcode;

import java.util.*;

/**
 * Created by jiaqichen on 11/14/16.
 */
public class GeneralizedAbbreviation {
    static List<String> result;
    static Set<Character> set = new HashSet<Character>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
    public static List<String> generateAbbreviations(String word) {
        result = new ArrayList<String>();
        StringBuilder abrv = new StringBuilder();
        helper(word,0,abrv);
        return result;
    }

    public static void helper(String word, int index, StringBuilder abrv){
        if(index == word.length()){
            result.add(abrv.toString());
            return;
        }
        StringBuilder copy = new StringBuilder(abrv);
        char c = word.charAt(index);
        int val = 1;
        int i = abrv.length()-1;
        if(i >= 0){
            while(i >= 0 && set.contains(abrv.charAt(i))){
                i--;
            }
            if(i+1 < abrv.length()) {
                val += Integer.valueOf(abrv.substring(i + 1));
                abrv.delete(i + 1, abrv.length());
            }
        }
        helper(word,index+1,new StringBuilder(copy).append(c));
        helper(word,index+1,new StringBuilder(abrv).append(""+val));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        generateAbbreviations(word);
    }
}
