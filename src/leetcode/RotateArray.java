package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/5/16.
 */
public class RotateArray {
    public void rotate2(int[] nums, int k) {
        if(k == 0){
            return;
        }
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        k = k % nums.length;
        int[] tmp = new int[nums.length];
        int j = 0;
        for(int i = nums.length - k; i < nums.length; i++){
            tmp[j] = nums[i];
            j++;
        }
        for(int i = 0; i < nums.length - k; i++){
            tmp[j] = nums[i];
            j++;
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = tmp[i];
        }
        return;
    }

    public static void rotate(int[] nums, int k) {
        if(k == 0){
            return;
        }
        if(nums.length == 0 || nums.length == 1 || k % nums.length == 0){
            return;
        }
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        return;
    }

    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
        return;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        rotate(arr,K);
        for(int i = 0; i < N; i++){
            System.out.print(arr[i] + " ");
        }
    }

}
