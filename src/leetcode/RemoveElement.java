package leetcode;

public class RemoveElement {
	public static int removeElement(int[] A, int elem) {
	    int len = A.length;
	    for (int i = 0 ; i< len; ++i){
	        while (A[i]==elem && i< len) {
	            A[i]=A[--len];
	        }
	    }
	    return len;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {2,2,3,2,4,2};
		System.out.println(removeElement(num,2));
	}

}
