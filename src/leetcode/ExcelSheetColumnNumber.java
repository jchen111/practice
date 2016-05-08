package leetcode;

public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s){
		int length = s.length();
		int output = 0;
		int j=0;
		for(int i=length-1;i>=0;i--){
			int rank = s.charAt(i)-64;
			output += rank*Math.pow(26, j);
			j+=1;
		}
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 'A';
		int z = 'Z';
		System.out.println(titleToNumber("B"));
	}

}
