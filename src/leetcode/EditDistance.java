package leetcode;

import java.util.Hashtable;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
    	int m = word1.length();
        int n = word2.length();
        if(word1.equals(word2)){
        	return 0;
        }
        if(m==0 || n==0){
        	return Math.abs(m-n);
        }
        int[][] edit = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
        	edit[i][0]=i;
        }
        for(int i=0;i<=n;i++){
        	edit[0][i]=i;
        }
        for(int i=1;i<=m;i++){
        	for(int j=1;j<=n;j++){
        		if(word1.charAt(i-1)==word2.charAt(j-1)){
        			edit[i][j] = edit[i-1][j-1];
        		}else{
        			edit[i][j] = Math.min(edit[i-1][j-1], Math.min(edit[i-1][j], edit[i][j-1]))+1;
        		}
        	}
        }
        return edit[m][n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistance("sea","eat"));
	}

}
