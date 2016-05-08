package leetcode;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int needlelen = needle.length();
        int haylen = haystack.length();
        if(needlelen>haylen){
        	return -1;
        }
        if(haystack.equals(needle)){
        	return 0;
        }
        for(int i=0;i<haystack.length();i++){
        	if(i+needlelen<=haylen){
        		if(haystack.subSequence(i, i+needlelen).equals(needle)){
        			return i;
        		}
        	}else{
        		return -1;
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
