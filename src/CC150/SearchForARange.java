package CC150;

import java.util.Arrays;

public class SearchForARange {
    public static int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[1] = searchRight(A,target,0,A.length-1);
        res[0] = searchLeft(A,target,0,A.length-1);
        return res;
    }
    
    public static int searchRight(int[] nums,int target,int left,int right){
    	if(left>right) return -1;
    	int mid = left+(right-left)/2;
    	if(nums[mid]==target){
    		if(mid==nums.length-1){
    			return mid;
    		}
    		if(nums[mid+1]==target){
    			return searchRight(nums,target,mid+1,right);
    		}else{
    			return mid;
    		}
    	}else if(target>nums[mid]){
    		return searchRight(nums,target,mid+1,right);
    	}else{
    		return searchRight(nums,target,left,mid-1);
    	}
    }
    public static int searchLeft(int[] nums,int target,int left,int right){
    	if(left>right) return -1;
    	int mid = left+(right-left)/2;
    	if(target==nums[mid]){
    		if(mid==0){
    			return mid;
    		}
    		if(nums[mid-1]==target){
    			return searchLeft(nums,target,left,mid-1);
    		}else{
    			return mid;
    		}
    	}else if(target>nums[mid]){
    		return searchLeft(nums,target,mid+1,right);
    	}else{
    		return searchLeft(nums,target,left,mid-1);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums 
//				   = {1,4,4,4,5,5,6};
				   = {2,2,2,2};
//				   = {1,2,3};
//				   = {2,2}; 
//				   = {4,4};
		int[] res = searchRange(nums,2);
		System.out.print(res[0]+" "+res[1]);
//		System.out.println(searchRight(nums,1,0,nums.length));
		}
	}

