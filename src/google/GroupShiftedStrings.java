package google;

import java.util.*;

/**
 * Created by z001ktb on 11/18/16.
 */
public class GroupShiftedStrings {

    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        if(strings.length == 0) return result;

        for(String s: strings){
            boolean newseq = true;
            for(String key: map.keySet()){
                if(sameSequence(key,s)) {
                    map.get(key).add(s);
                    newseq = false;
                    break;
                }
            }
            if(newseq) {
                ArrayList<String> tmp = new ArrayList<String>();
                tmp.add(s);
                map.put(s,tmp);
            }
        }

        for(String key: map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }

    public static boolean sameSequence(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        for(int i = 0; i < s1.length()-1; i++){
            if(((int)s1.charAt(i+1) - (int)s1.charAt(i) + 26) % 26 != ((int)s2.charAt(i+1) - (int)s2.charAt(i) + 26) % 26){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] strings = new String[n];
//        for(int i = 0; i < n; i++){
//            strings[i] = sc.next();
//        }
//        groupStrings(strings);
        Map<Integer,int[][]> map = new HashMap<Integer, int[][]>();
        map.put(1,new int[2][2]);
    }
}
