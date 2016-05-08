package leetcode;

public class PalindormeNumber {
	
	public static boolean isPalindrome(int x) {
		int y=0;
		int copyx = Math.abs(x);
		x = Math.abs(x);
		int factor = 1;
		int digit = 1;
		while(x%10!=x){
			factor*=10;
			x/=10;
			digit+=1;
		}
		if(digit%2==0) return false;
		x = copyx;
		while(x%10!=x){
			y+=((x%10)*factor);
			x = x/10;
			factor/=10;
		}
		y+=((x%10)*factor);
		
		if(y==copyx) {
			return true;
		}else{
        return false;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = -101;
		System.out.println(isPalindrome(a));
	}

}
