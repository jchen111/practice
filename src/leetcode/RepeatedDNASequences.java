package leetcode;

import java.util.*;

/**
 * Created by jiaqichen on 10/17/16.
 */
public class RepeatedDNASequences {
    public static List<String> findRepeatedDnaSequences(String s) {
        LinkedList<String> list = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        HashSet<String> check = new HashSet<String>();
        for(int i = 0; i <= s.length() - 10; i++){
            int j = i+10;
            String tmp = s.substring(i,j);
            if(set.contains(tmp)){
                if(!check.contains(tmp)) {
                    list.add(tmp);
                    check.add(tmp);
                }
            }else{
                set.add(tmp);
            }
        }
        return list;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        findRepeatedDnaSequences(s);
    }
}
