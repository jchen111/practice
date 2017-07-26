package MS;

/**
 * Created by z001ktb on 7/21/17.
 */
public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        int[] s1map = new int[128];
        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1map[c]++;
        }

        int k = s1.length();

        int left = 0;
        int right = 0;
        while(right < s2.length()) {
            s1map[s2.charAt(right)]--;
            while(right - left == k - 1 && left < s2.length()) {
                if(check(s1map)) return true;
                s1map[s2.charAt(left)]++;
                left++;
            }
            right++;
        }
        return false;
    }

    private static boolean check(int[] s1map) {
        for(int i = 0; i < s1map.length; i++) {
            if(s1map[i] != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        checkInclusion("ab","eidbaooo");
    }
}
