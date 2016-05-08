package leetcode;

public class ReverseInteger {
	public static int reverse(int x) {
		if(x==0) return 0;
		long output = 0;
        int j=1;
			long x1 = x;
        	while(x%10!=x){
        		j*=10;
        		x/=10;
        	}
        	if(x1>Integer.MAX_VALUE || x1<Integer.MIN_VALUE) return 0;
        	while(x1%10!=x1){
        		output+=(x1%10)*j;
        		if(output>Integer.MAX_VALUE || output<Integer.MIN_VALUE) return 0;
        		j/=10;
        		x1/=10;
        	}
        	output+=x1;
		return (int) output;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x =1534236469;
		System.out.println(reverse(x));
	}

}
