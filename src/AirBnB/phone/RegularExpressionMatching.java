package AirBnB.phone;

public class RegularExpressionMatching {

	 public static boolean isMatch(String s, String p) {
	        // DP
	        boolean opt[][] = new boolean[s.length()+1][p.length()+1];
	        // base case
	        opt[0][0] = true;
	        boolean valid = false;
	        for(int j = 2;j <= p.length();j+=2){
	            if(p.charAt(j-1)=='*'){ valid = true; opt[0][j] = true;}
	            else{ valid = false;}
	            if(!valid) break;
	        }
	        // iteration
	        for(int i = 1;i <= s.length();i++){
	            for(int j = 1;j <= p.length();j++){
	                opt[i][j] = false;
	                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') opt[i][j] = opt[i-1][j-1];
	                else if(p.charAt(j-1)=='*'){
	                    if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')
	                        opt[i][j] = opt[i-1][j] || opt[i][j-2];
	                        // opt[i-1][j] do take s[i] to match p[j-1],p[j]
	                        // opt[i][j-2] don't take s[i] to match p[j-1],p[j]
	                    else
	                        opt[i][j] = opt[i][j-2];
	                        // opt[i][j-2] cannot take s[i] to match p[j-1],p[j]
	                }
	            }
	        }
	        return opt[s.length()][p.length()];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(isMatch("aasdfasdfasdfasdfas","aasdf.*asdf.*asdf.*asdf.*s"));
//		System.out.println(isMatch("abcd","d*"));
//		System.out.println(isMatch("b","b"));//true
//		System.out.println(isMatch("aaa","ab*a")); //false
//		System.out.println(isMatch("aab","c*a*b")); //true
//		System.out.println(isMatch("aaa","ab*ac*a")); //true
		System.out.println(isMatch("aaa","ab*a*c*a")); //true
	}

}
