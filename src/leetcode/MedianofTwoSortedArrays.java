package leetcode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
//    public static double findMedianSortedArrays(int A[], int B[]) {
//    	int m = A.length;
//    	int n = B.length;
//    	int[] c = new int[m+n];
//    	int a=0,b=0,k=0;
//    	int first=0;
//    	while(a<m && b<n){
//    		if(A[a]<B[b]){
//    			c[k]=A[a];
//    			if((m+n)%2!=0 && k==(m+n)/2)
//    				return c[k];
//    			if((m+n)%2==0 && k==(m+n)/2-1)
//    				first = c[k];
//    			if((m+n)%2==0 && k==(m+n)/2)
//    				return (double)(first+c[k])/2;
//    			a++;
//    			k++;
//    		}else{
//    			c[k] = B[b];
//    			if((m+n)%2!=0 && k==(m+n)/2)
//    				return c[k];
//    			if((m+n)%2==0 && k==(m+n)/2-1)
//    				first = c[k];
//    			if((m+n)%2==0 && k==(m+n)/2)
//    				return (double)(first+c[k])/2;
//    			b++;
//    			k++;
//    		}
//    	}
//    	while(b<n){
//    		c[k] = B[b];
//    		if((m+n)%2!=0 && k==(m+n)/2)
//				return c[k];
//    		if((m+n)%2==0 && k==(m+n)/2-1)
//				first = c[k];
//			if((m+n)%2==0 && k==(m+n)/2)
//				return (double)(first+c[k])/2;
//    		b++;
//    		k++;
//    	}
//    	while(a<m){
//    		c[k] = A[a];
//    		if((m+n)%2!=0 && k==(m+n)/2)
//				return c[k];
//    		if((m+n)%2==0 && k==(m+n)/2-1)
//				first = c[k];
//			if((m+n)%2==0 && k==(m+n)/2)
//				return (double)(first+c[k])/2;
//    		k++;
//    		a++;
//    	}
//    	if((m+n)%2==0){
//    		return (double)(c[(m+n)/2]+c[(m+n)/2-1])/2;
//    	}else{
//    		return c[(m+n)/2];
//    	}
//    }

	public static double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		if (len % 2 == 1) {
			return findKth(A, 0, B, 0, len / 2 + 1);
		}
		return (
				findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)
		) / 2.0;
	}

	// find kth number of two sorted array
	public static int findKth(int[] A, int A_start,
							  int[] B, int B_start,
							  int k){
		if (A_start >= A.length) {
			return B[B_start + k - 1];
		}
		if (B_start >= B.length) {
			return A[A_start + k - 1];
		}

		if (k == 1) {
			return Math.min(A[A_start], B[B_start]);
		}

		int A_key = A_start + k / 2 - 1 < A.length
				? A[A_start + k / 2 - 1]
				: Integer.MAX_VALUE;
		int B_key = B_start + k / 2 - 1 < B.length
				? B[B_start + k / 2 - 1]
				: Integer.MAX_VALUE;

		if (A_key < B_key) {
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		} else {
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a ={1,2,4,5};
//		int[] b ={6,7,8,9,10};
		int[] a = {1,2,10,11};
		int[] b = {4,5,5,8,9};
		System.out.println(findMedianSortedArrays(a,b));
	}

}
