package leetcode;
import CC150.TreeNode;

public class BinaryTreePathSum {
	public  static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null && root.right ==null){
        	if(root.val==sum) return true;
        	else return false;
        }
        if(root.left!=null || root.right!=null){
        	return (hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val));
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
