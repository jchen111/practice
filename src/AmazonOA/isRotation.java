package AmazonOA;

public class isRotation {
	public static boolean isRotation(String s1, String s2){
		if(s1.isEmpty() || s2.isEmpty()) return false;
		return (s1.length() == s2.length() && (s1+s1).indexOf(s2)!=-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isRotation("aaaab","aabaa"));
	}

}
