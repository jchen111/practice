package leetcode;

public class UniqueBinarySearchTrees {
	public static int numTrees(int n) {
        if(n==0) return 1;
        int output = 0;
        for(int i=0;i<n;i++){
        	output+=numTrees(i)*numTrees(n-(i+1));
        }
        return output;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(4));
	}

}
