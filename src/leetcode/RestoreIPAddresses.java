package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by z001ktb on 9/27/16.
 */
public class RestoreIPAddresses {

    public static List<String> result;

    public static List<String> restoreIpAddresses(String s) {
        result = new ArrayList<String>();
        helper(s.toCharArray(),4,"",s.length());
        return result;
    }


    public static void helper(char[] chars, int seg, String pre, int L) {
        int length = chars.length;
        if(length == 0 || length > seg * 3 || length < seg){
            return;
        }

        for(int j = 1; j <= 3; j++){
            if(j <= length) {
                char[] tmp = Arrays.copyOfRange(chars, j, length);
                String s = String.valueOf(Arrays.copyOfRange(chars, 0, j));
                if(j != 1 && chars[0] == '0'){
                    continue;
                }
                if (Integer.parseInt(s) <= 255 && Integer.parseInt(s) >= 0) {
                    if (s.length() == L && seg == 1) {
                        result.add(pre + s);
                        return;
                    }
                    if (pre.length() != 0)
                        helper(tmp, seg - 1, pre + s + ".", L - s.length());
                    else
                        helper(tmp, seg - 1, s + ".", L - s.length());
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        List<String> res = restoreIpAddresses(input);
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
