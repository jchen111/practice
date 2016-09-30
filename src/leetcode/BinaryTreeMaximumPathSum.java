package leetcode;

import CC150.TreeNode;

/**
 * Created by jacky on 9/26/16.
 */
public class BinaryTreeMaximumPathSum {

    static int result;
    public static int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        helper(root);
        return result;
    }

    public static int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int maxLeft = helper(root.left); // left subtree max path
        int maxRight = helper(root.right); // right subtree max path

        // root max path
        int maxPath = root.val + Math.max(
                maxLeft + maxRight,
                Math.max(maxLeft, maxRight)
        );
        result = Math.max(result,maxPath);
        // if Math.max(maxLeft,maxRight) + root.val is less than 0, just return 0, making sure helper method only returns non negative value
        return Math.max(Math.max(maxLeft,maxRight) + root.val,0);
    }


    public static void main(String[] args){

    }
}
