package leetcode;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/6/16.
 */
public class MaximumProductSubarray {
    // O(n^2) brute force
    public static int maxProduct2(int[] nums) {
        int len = nums.length;
        int[][] matrix = new int[len][len];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(i == j){
                    matrix[i][j] = nums[i];
                }else{
                    matrix[i][j] = matrix[i][j-1] * nums[j];
                }

                if(matrix[i][j] >= max)
                    max = matrix[i][j];
            }
        }
        return max;
    }

    /*
    O(n) no extra space better!
     */
    public static int maxProduct(int[] nums){
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > 0){
                max = Math.max(nums[i]*max,nums[i]);
                min = Math.min(nums[i]*min,nums[i]);
            }else{
                int lastmax = max;
                max = Math.max(nums[i]*min,nums[i]);
                min = Math.min(lastmax*nums[i],nums[i]);
            }
            res = Math.max(res,max);
        }
        return res;
    }



    /**
     * case 2,3,-2,4 ->6
     * case 2,3,-2,7 ->7
     * @param args
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxProduct2(arr));
    }
}
