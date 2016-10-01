package leetcode;

public class MergeSortedArray {
    public static void merge(int A[], int m, int B[], int n) {
        int i=0,j=0;
        int Alength = m, Blength = n;
        while(i<Blength && j<Alength+Blength){
        	if(B[i]<A[j]){
        		m+=1;
				// shifting the A[] one place to the right to make space for B[i]
        		int tmp1 = A[j]; //tmp1 hosting the previous place value
        		for(int k=j+1;k<m;k++){
        			int tmp2 = tmp1;
        			tmp1 = A[k];
        			A[k] = tmp2;
        		}
        		A[j] = B[i]; // placing B[i]
        		++i;
        		++j;
        	}else{
        		if(j==m){
        			A[j] = B[i];
        			i++;
        			j++;
        			m++;
        		}else
        			j++;
        	}
        }
//        for(int c=0;c<Alength+Blength;c++){
//        	System.out.println(A[c]);
//        }
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[3];
		int[] b = new int[5];
		a[0]=1;a[1]=2;a[2]=3;
		merge(a,3,b,0);
	}
}
