package facebook;

import CC150.TreeNode;

/**
 * Created by z001ktb on 6/17/17.
 */
public class LCAForDeepestNode {
    static class Result {
        int depth;
        TreeNode node;
        Result(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    private static Result findDeepestLCA(TreeNode root) {
        if(root == null){
            return new Result(0,null);
        }

        Result left = findDeepestLCA(root.left);
        Result right = findDeepestLCA(root.right);

        if(left.depth == right.depth) {
            return new Result(left.depth + 1,root);
        }else if(left.depth > right.depth) {
            return new Result(left.depth + 1, left.node);
        }else {
            return new Result(right.depth + 1, right.node);
        }
    }

    private static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        else if(root == p || root == q){
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }else if(left != null) {
            return left;
        }else if(right != null){
            return right;
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;

    }
}
