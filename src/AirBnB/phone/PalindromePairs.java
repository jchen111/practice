package AirBnB.phone;

import java.util.*;

/**
 * Created by z001ktb
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j <= words[i].length(); j++) {
                //The <= in for (int j=0; j<=words[i].length(); j++) is aimed to handle empty string in the input. Consider the test case of ["a", ""]
                String str1 = words[i].substring(0,j);
                String str2 = words[i].substring(j);
                if(isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        result.add(Arrays.asList(map.get(str2rvs), i));
                    }
                }
                if(isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1rvs) && map.get(str1rvs) != i && !str2.isEmpty()) { //check "str.length() != 0" to avoid duplicates
                        //Since we now use <= in for (int j=0; j<=words[i].length(); j++) instead of <. There may be duplicates in the output (consider test case ["abcd", "dcba"]). Therefore I put a str2.length()!=0 to avoid duplicates
                        result.add(Arrays.asList(i, map.get(str1rvs)));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
