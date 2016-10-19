package leetcode;

/**
 * Created by jiaqichen on 10/18/16.
 */
public class MissingNumber {

    //The basic idea behind this solution is, since numbers in array nums are picked between 0~n-1, so n must be equal to nums.length + 1. The sum from 0 to n-1 is (n-1)*n/2,  we just need to calculate the sum for all numbers in nums (sum2) and then use sum to minus sum2 to get the missing element.
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int sum = (n-1)*n/2;
        int sum2 = 0;
        for(int i = 0; i < nums.length; i++){
            sum2 += nums[i];
        }
        return sum - sum2;
    }
}
