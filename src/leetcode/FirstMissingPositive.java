package leetcode;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] A) {
	    if (A == null || A.length == 0) {
	        return 1;
	    }

	    // Put the corresponding positive value in the index that equals to its value
	    int len = A.length;
	    for (int i = 0; i < len;) {
	        int num = A[i];
	        if (num > 0 && num < len && num != i && num != A[num]) {
	            A[i] = A[num];
	            A[num] = num;
	        } else {
	            ++i;
	        }
	    }

	    // Scan the array to find the first value that is not equal to its index, then it is the missing value
	    // Test small examples first
	    int missingValue = A[0] == len ? len+1 : len;
	    for (int i = 1; i < len; ++i) {
	        if (A[i] != i) {
	            missingValue = i;
	            break;
	        }
	    }

	    return missingValue;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] num = {{3,4,-1,1},
				{1,2,0},
				{-1,-2,-3,4,5},
				{4},
				{1},
				{1,2,3,4,5},
				{2,1}};
		int[] num2 = {-1,-2,-3,4,5};
		System.out.println(firstMissingPositive(num2));
//		for(int i=0;i<num.length;i++){
//			System.out.println(firstMissingPositive(num[i]));
//		}
	}

}
