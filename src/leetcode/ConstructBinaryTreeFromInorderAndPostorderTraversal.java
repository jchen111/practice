package leetcode;

import CC150.TreeNode;

/**
 * Created by jacky on 9/20/16.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        return helper(postorder.length - 1, 0, inorder.length - 1,inorder,postorder);
    }

    public static TreeNode helper(int postend, int inbeg, int inend, int[] inorder, int[] postorder){
        if(postend < 0 || inbeg > inend){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);
        int index = 0;

        while(inorder[index] != root.val){
            index++;
        }

        root.left = helper(postend - (inend - index) - 1, inbeg, index - 1, inorder, postorder);
        root.right = helper(postend - 1, index + 1, inend, inorder, postorder);
        return root;
    }

    public static void main(String[] args){
        int[] test1 = {2,1};
        int[] test2 = {2,1};
        System.out.println(buildTree(test1,test2).val);
    }
}
