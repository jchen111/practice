package AmazonOA;

public class DeleteVowels {
	public static String DeleteVowelsFromAString(String s){
		StringBuilder sb = new StringBuilder();
		String v = "aeiouAEIOU";
		for(int i=0;i<s.length();i++){
			if(v.indexOf(s.charAt(i))==-1){
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DeleteVowelsFromAString("How a string looks like without vowels?"));
	}

}
