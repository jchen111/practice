package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/4/16.
 */
public class HouseRobber {

    /**
     * construct array max, max[i] means the maximum amount of money robber can get util house i
     * Dynamic programming, transition function max[i] = Math.max(nums[i] + max[i-2],max[i-1])
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[1],max[0]);
        for(int i = 2; i < nums.length; i++){
            max[i] = Math.max(nums[i]+max[i-2],max[i-1]);
        }
        return max[nums.length-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(rob(arr));
    }
}
