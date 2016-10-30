package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class InterleavingString {
	
	private static Set<Integer> visited; // The combination of i1, i2 has been onStack and return false
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length())
            return false;
        visited = new HashSet<Integer>();
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }

    private static boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3)
    {   
        int hash = i1 * s3.length() + i2;
        if(visited.contains(hash))
            return false;

        if(i1 == s1.length())
            return s2.substring(i2).equals(s3.substring(i3));
        if(i2 == s2.length())
            return s1.substring(i1).equals(s3.substring(i3));

        if(s3.charAt(i3) == s1.charAt(i1) && isInterleave(s1, i1+1, s2, i2, s3, i3+1) ||
           s3.charAt(i3) == s2.charAt(i2) && isInterleave(s1, i1, s2, i2+1, s3, i3+1))
            return true;

        visited.add(hash);
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="aabcc", s2="dbbca", s3="aadbbbaccc";
		System.out.println(isInterleave(s1,s2,s3));	
	}

}
