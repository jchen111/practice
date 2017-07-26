package facebook;

import java.util.*;

/**
 * Created by z001ktb on 6/19/17.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        String sorted = "";
        for(String str : strs) {
            sorted = sort(str);
            Set<String> set;
            if(map.containsKey(sorted)){
                set = map.get(sorted);
                set.add(str);
            }else {
                set = new HashSet<String>();
                set.add(str);
            }
            map.put(sorted,set);
        }

        for(String key : map.keySet()) {
            result.add(new ArrayList<String>(map.get(key)));
        }

        return result;
    }

    private static String sort(String str) {
        int[] dic = new int[26];
        String result = "";
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            dic[c-'a']++;
        }

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < dic[i]; j++){
                result = (char)(i + 97) + result;
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        String[] words = {"eat","tea","tan","ate","nat","bat"};
        String[] words = {"",""};
        groupAnagrams(words);
    }
}
