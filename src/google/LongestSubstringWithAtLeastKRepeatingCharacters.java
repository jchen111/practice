package google;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        if(k <= 1) return s.length();
        int n = s.length();
        int maxLen = 0;
        int[] occur = new int[26];
        for(int i = 0; i < n; i++) {
            occur[s.charAt(i) - 'a']++; //count the occurance of charactors
        }

        StringBuilder regex = new StringBuilder();
        boolean firstSplit = false;
        for(int i = 0; i < 26; i++) {
            if(occur[i] < k && occur[i] > 0) {
                if(!firstSplit) {
                    regex.append((char)('a' + i));
                    firstSplit = true;
                } else {
                    if(regex.length() <= 1) {
                        regex.insert(0, "[");
                    }
                    regex.append((char)('a' + i));
                }
            }
        }
        if(regex.length() > 1) {
            regex.append("]");
        }

        if(regex.length() > 0) {
            String[] strs = s.split(regex.toString());
            for(String str : strs) {
                int localmax = longestSubstring(str, k);
                maxLen = Math.max(maxLen, localmax);
            }
        } else {
            return s.length();
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }
}
