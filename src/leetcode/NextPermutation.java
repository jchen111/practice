package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/17/16.
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
    }

    public static void reverse(int[] nums, int start, int end){
        if(start == end) return;
        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        nextPermutation(arr);

        for(int i = 0; i < N; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
