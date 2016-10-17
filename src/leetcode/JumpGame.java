package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/16/16.
 */
public class JumpGame{
    //stack overflow
    public static boolean canJump2(int[] nums) {
        return helper(nums,0);
    }

    public static boolean helper(int[] nums, int start){
        if(start == nums.length - 1){
            return true;
        }
        int i = nums[start];
        if(i + start >= nums.length - 1) return true;
        while(i > 0){
            if(helper(nums,start+i)){
                return true;
            }
            else
                i--;
        }
        return false;
    }

    //O(n) constant extra space
    public static boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int lastGood = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] >= lastGood){
                lastGood = i;
            }
        }
        return lastGood == 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(canJump(arr));
    }
}
