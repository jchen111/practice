package AmazonOA;

import java.util.Scanner;

public class isRotation {
	public static boolean isRotation(String s1, String s2){
		if(s1.isEmpty() || s2.isEmpty()) return false;
		return (s1.length() == s2.length() && (s1+s1).indexOf(s2)!=-1);
	}

	public static boolean isValid(Double value, int digitsBefore, int digitsAfter) {
		String decimalStr = String.valueOf(value);
		int lo = 0;
		int hi = decimalStr.length() - 1;
		int beforeCount = 0;
		int afterCount = 0;
		while(lo < hi && (decimalStr.charAt(lo) != '.' || decimalStr.charAt(hi) != '.')) {
			if(decimalStr.charAt(lo) != '.') {
				beforeCount++;
				lo++;
			}
			if(decimalStr.charAt(hi) != '.') {
				afterCount++;
				hi--;
			}
			if(beforeCount > digitsBefore || afterCount > digitsAfter) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		while(true) {
			double value = sc.nextDouble();
			int b = sc.nextInt();
			int a = sc.nextInt();
			System.out.println(isValid(value, b, a));
		}
//		System.out.println(isRotation("aaaab","aabaa"));
	}

}
