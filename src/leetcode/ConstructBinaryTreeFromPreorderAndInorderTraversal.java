package leetcode;

import CC150.TreeNode;

/**
 * Created by jacky on 9/20/16.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length-1,preorder,inorder);
    }

    public TreeNode helper(int prebegin, int inbegin, int inend, int[] preorder, int[] inorder){
        TreeNode root;
        if(prebegin > preorder.length - 1 || inbegin > inend){
            return null;
        }

        root = new TreeNode(preorder[prebegin]);

        int index = 0;
        while(inorder[index] != root.val){
            index++;
        }

        root.left = helper(prebegin + 1, inbegin, index - 1, preorder,inorder);
        root.right = helper(prebegin + index - inbegin + 1, index + 1, inend, preorder, inorder);

        return root;
    }

    public static void main(String[] args){

    }
}
