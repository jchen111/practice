package leetcode;

public class FactorialTrailingZeroes {
	public static int trailingZeroes(int n) {
		n = Math.abs(n);
		int count = 0;
		if(n==0) return 0;
		if(n<5){
			return 0;
		}
		while(n>1){
			n/=5;
			count+=n;
		}
		return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(10));
	}

}
