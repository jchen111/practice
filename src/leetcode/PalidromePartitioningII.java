package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jiaqichen on 9/29/16.
 */
public class PalidromePartitioningII {

    public static int minCut(String s) {
        int min = 0;
        int len = s.length();
        int[] cuts = new int[len+1];
        boolean[][] matrix = new boolean[len][len];
        if(len == 0 || len == 1){
            return min;
        }

        for(int i =0; i < len; i++){
            cuts[i] = len - i;
        }

        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if((s.charAt(i) == s.charAt(j) && (j - i <= 1)) || (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1])){
                    matrix[i][j] = true;
                    cuts[i] = Math.min(cuts[i],cuts[j+1]+1);
                }
            }
        }
        return cuts[0] - 1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(minCut(s));
    }
}
