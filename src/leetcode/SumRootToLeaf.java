package leetcode;

import java.util.LinkedList;
import java.util.List;

import CC150.TreeNode;

public class SumRootToLeaf {
	static List<String> res;
	static String str = "";
    public static int sumNumbers(TreeNode root) {
    	if(root==null) return 0;
        res = new LinkedList<String>();
        helper(root);
        int sum = 0;
        for(int i=0;i<res.size();i++){
        	int current = Integer.parseInt(res.get(i));
        	System.out.println(current);
        	sum+=current;
        }
        return sum;
    }
    public static void helper(TreeNode root){
    	if(root.left==null && root.right==null){
    		str+=root.val;
    		res.add(new String(str));
    		str= str.substring(0, str.length()-1);
    		return;
    	}
    	if(root.left!=null || root.right!=null){
    		str+=root.val;
    		if(root.left!=null){
    			helper(root.left);
    		}
    		if(root.right!=null){
    			helper(root.right);
    		}
    		str= str.substring(0, str.length()-1);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t8 = new TreeNode(8);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		TreeNode t9 = new TreeNode(9);
		TreeNode t99 = new TreeNode(9);
		TreeNode t55 = new TreeNode(5);
		t8.left = t3; t8.right = t5; t3.right = t9; t9.left = t99; t9.right = t55;
		System.out.print(sumNumbers(t8));
	}

}
