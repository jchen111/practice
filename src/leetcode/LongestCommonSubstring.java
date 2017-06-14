package leetcode;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/21/17.
 */
public class LongestCommonSubstring {

    public static String longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n]; // dp[i][j] means the length of the common substring ends with str1.charAt(i) or str2.charAt(j)
        int maxLen = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }

                    if(dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        index = i;
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(maxLen > 0){
            sb.insert(0,str1.charAt(index--));
            maxLen--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String str1 = sc.next();
            String str2 = sc.next();
            System.out.println(longestCommonSubstring(str1, str2));
        }
    }
}
