package leetcode;

public class CountandSay {
    public static String countAndSay(int n) {
        if(n==1) return "1";
        String pre = countAndSay(n-1);
        String output = "";
        char f = pre.charAt(0);
        int i=1;
        int count = 1;
        while(i<pre.length()){
        	if(pre.charAt(i)!=f){
        		output+=count;
        		output+=f;
        		f = pre.charAt(i);
        		count=1;
        	}else{
        		count++;
        	}
        	i++;
        }
        output+=count;
        output+=f;
        return output;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(5));
	}

}
