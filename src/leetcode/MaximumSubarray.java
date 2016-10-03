package leetcode;

import java.util.Arrays;

public class MaximumSubarray {
    public static int maxSubArray(int[] A) {
        if(A==null){
        	return 0;
        }
        int currentsum = A[0];
        int maxsum = A[0];
        for(int i = 1; i < A.length; i++){
        	if(currentsum+A[i] < A[i]){
        		currentsum = A[i];
        	}else{
        		currentsum += A[i];
        	}
        	if(currentsum > maxsum){
        		maxsum = currentsum;
        	}
        }
        return maxsum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

}
