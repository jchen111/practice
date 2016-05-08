package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] A) {
        int s = 0;
        int index = 0;
        if(A.length==0) return 0;
        int tail = A[0];
        while(s<A.length){
        	A[index] = tail;
        	index++;
        	while(s<A.length && A[s]==tail){
        		s++;
        	}
        	if(s==A.length) break;
        	tail = A[s];
        }
        return index;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {1,1,1,1,1,2};
		int[] a = {1,1,1,1,2,2,2,3};
		System.out.println(removeDuplicates(a));
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
