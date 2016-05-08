package leetcode;
import java.util.ArrayList;
import java.util.List;

import CC150.TreeNode;
public class UniqueBinarySearchTreesII {
    public static List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    public static List<TreeNode> helper(int start,int end){
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	if(start==end){
    		list.add(new TreeNode(start));
    		return list;
    	}
    	if(start>end){
    		list.add(null);
    		return list;
    	}
    	List<TreeNode> left,right;
    	for(int i=start;i<=end;i++){
    		left = helper(start,i-1);
    		right = helper(i+1,end);
    		for(TreeNode lnode:left){
    			for(TreeNode rnode:right){
    				TreeNode root = new TreeNode(i);
    				root.left = lnode;
    				root.right = rnode;
    				list.add(root);
    			}
    		}
    	}
    	return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateTrees(3);
	}

}
