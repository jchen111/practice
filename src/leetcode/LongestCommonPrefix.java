package leetcode;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length==0) return "";
        if(length==1) return strs[0];
        int prefix = 0;
        boolean common = true;
        String minstring = strs[0];
        for(int i=0;i<length;i++){
        	if(strs[i].isEmpty()) return "";
        	if(strs[i].length()<minstring.length())
        		minstring = strs[i];
        }
        char tocheck = minstring.charAt(0);
        while(prefix<minstring.length()){
        	for(int i=0;i<length;i++){
        		if(strs[i].charAt(prefix)!=tocheck){
        				common = false;
        		}
        	}
        	if(common){
        		if(prefix==minstring.length()-1){
        			prefix++;
        			break;
        		}
        		prefix++;
        		tocheck = minstring.charAt(prefix);
        	}else{
        		break;
        	}
        }
        return strs[0].substring(0, prefix);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayofstrings = {"a","a"};
		System.out.println(longestCommonPrefix(arrayofstrings));
	}

}
