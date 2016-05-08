package AmazonOA;

public class LongestPalindromicSubstring {
	public static void expend(String s,StringBuilder sb, int i, int j){
		while(i>=0 && j<=s.length()-1){
			if(s.charAt(i)==s.charAt(j)){
				if(j-i+1>sb.length()){
					sb.delete(0, sb.length());
					sb.append(s.substring(i, j+1));
				}
				i--;
				j++;
			}else
				break;
		}
	}
    public static String longestPalindrome(String s) {
    	StringBuilder sb = new StringBuilder();
    	if(s.length()<=1) return s;
        for(int i=0;i<s.length();i++){
        	expend(s,sb,i,i+1); //even
        	expend(s,sb,i,i);  //odd
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaabaaa";
		System.out.println(longestPalindrome(s));
	}

}
