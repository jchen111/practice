package leetcode;

import java.util.Arrays;

public class SearchInsertPosition {
	public static int helpersearch(int[] A, int index, int target){
		int length = A.length;
		int mid = length/2;
		if(length==1){
			if(A[0]>=target){
				return index;
			}else{
				return index+1; 
			}
		}else{
			int[] a = Arrays.copyOfRange(A, 0, mid);
			int[] b = Arrays.copyOfRange(A, mid, length);
			if(A[mid]==target){
				return mid+index;
			}
			if(target>=A[mid]){
				return helpersearch(b,index+mid,target);
			}else{
				return helpersearch(a,index,target);
			}
		}
		
	}
	public static int searchInsert(int[] A, int target) {
        return helpersearch(A,0,target);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,3,5,6};
		System.out.println(searchInsert(num,0));
	}

}
