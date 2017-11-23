package BB;

/**
 * Created by z001ktb
 */
public class FirstNonRepeatChar {
    public int firstUniqChar(String s) {
        int[] map = new int[256];
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(left != right){
                map[s.charAt(right)]++;
            }
            map[s.charAt(left)]++;
            left++;
            right--;
        }
        for(int i = 0; i < s.length(); i++){
            if(map[s.charAt(i)] == 1) return i;
        }
        return -1;
    }
}
