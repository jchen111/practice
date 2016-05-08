package leetcode;

public class DecodeWays {
//    public static int numDecodings(String s) {
//        if(s.length()==0) return 0;
//        int n = s.length();
//        int[] ways = new int[n+1];
//        ways[n] = 1;
//        ways[n-1] = s.charAt(n-1)!='0' ? 1:0;
//        for(int i=n-2;i>=0;i--){
//        	if(s.charAt(i) == '0') continue;
//        	else ways[i] = Integer.parseInt(s.substring(i, i+2))<=26 ? ways[i+1]+ways[i+2] : ways[i+1];
//        }
//        return ways[0];
//    }
	public static int numDecodings(String s){
		if(s.length()==0 || s==null || s=="0")
			return 0;
		int[] dp = new int[s.length()+1];
		dp[0] = 1; //base
		if(isValid(s.substring(0, 1))){
			dp[1] = 1;
		}else{
			dp[1] = 0;
		}
		int i=0;
		for(i=2;i<=s.length();i++){
			if(s.charAt(i-1)=='0') dp[i] = dp[i-1];
			else{
				if(isValid(s.substring(i-2, i))){
					dp[i] = dp[i-1]+dp[i-2];
				}else{
					dp[i] = dp[i-1];
				}
			}
		}
		return dp[i-1];
	}
	public static boolean isValid(String s){
		if(s.charAt(0)=='0') return false;
		int code = Integer.parseInt(s);
		if(code>26) return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("110"));
	}

}
