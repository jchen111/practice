package MS.OTS;

import CC150.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     * @Return the root node of the tree we recover
     * @param preorder the preorder traverse of the tree
     * @param inorder the inorder traverse of the tree
     *  **/
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode dfs(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if(ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int k = 0;
        for(int i = is; i <= ie; i++ ) {
            if(inorder[i] == preorder[ps]) {
                k = i;
                break;
            }
        }

        root.left = dfs(preorder, ps + 1, ps + k - is, inorder, is, k - 1);
        root.right = dfs(preorder, ps + k - is + 1, pe, inorder, k + 1, ie);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] in = {4,2,5,1,6,3,7};
        TreeNode root = buildTree(pre, in);
    }
}
