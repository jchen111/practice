package leetcode;

import java.util.*;

/**
 * Created by z001ktb on 11/13/16.
 */
public class FlipGame {
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length-1; i++){
            char c = chs[i];
            if(c == '+'){
                if(chs[i+1] == c){
                    chs[i] = '-';
                    chs[i+1] = '-';
                    String tmp = new String(chs);
                    if(!set.contains(tmp)) result.add(tmp);
                    chs[i] = '+';
                    chs[i+1] = '+';
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> list = generatePossibleNextMoves(s);
        System.out.println(list);
    }
}
