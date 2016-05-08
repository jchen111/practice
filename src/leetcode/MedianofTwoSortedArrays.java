package leetcode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int A[], int B[]) {
    	int m = A.length;
    	int n = B.length;
    	int[] c = new int[m+n];
    	int a=0,b=0,k=0;
    	int first=0;
    	while(a<m && b<n){
    		if(A[a]<B[b]){
    			c[k]=A[a];
    			if((m+n)%2!=0 && k==(m+n)/2)
    				return c[k];
    			if((m+n)%2==0 && k==(m+n)/2-1)
    				first = c[k];
    			if((m+n)%2==0 && k==(m+n)/2)
    				return (double)(first+c[k])/2;
    			a++;
    			k++;
    		}else{
    			c[k] = B[b];
    			if((m+n)%2!=0 && k==(m+n)/2)
    				return c[k];
    			if((m+n)%2==0 && k==(m+n)/2-1)
    				first = c[k];
    			if((m+n)%2==0 && k==(m+n)/2)
    				return (double)(first+c[k])/2;
    			b++;
    			k++;
    		}
    	}
    	while(b<n){
    		c[k] = B[b];
    		if((m+n)%2!=0 && k==(m+n)/2)
				return c[k];
    		if((m+n)%2==0 && k==(m+n)/2-1)
				first = c[k];
			if((m+n)%2==0 && k==(m+n)/2)
				return (double)(first+c[k])/2;
    		b++;
    		k++;
    	}
    	while(a<m){
    		c[k] = A[a];
    		if((m+n)%2!=0 && k==(m+n)/2)
				return c[k];
    		if((m+n)%2==0 && k==(m+n)/2-1)
				first = c[k];
			if((m+n)%2==0 && k==(m+n)/2)
				return (double)(first+c[k])/2;
    		k++;
    		a++;
    	}
    	if((m+n)%2==0){
    		return (double)(c[(m+n)/2]+c[(m+n)/2-1])/2;
    	}else{
    		return c[(m+n)/2];
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
