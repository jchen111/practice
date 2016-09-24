package leetcode;

import CC150.TreeNode;
/**
 * Created by jacky on 9/21/16.
 */
public class FlattenBinaryTreeToLinkedList {

    public static void flatten(TreeNode root) {
        root = doFlatten(root);
    }

    public static TreeNode doFlatten(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }
        TreeNode tmp = root.right;
        root.right = doFlatten(root.left);
        root.left = null;
        TreeNode pointer = root;
        while(pointer.right != null){
            pointer = pointer.right;
        }
        pointer.right = doFlatten(tmp);
        return root;
    }

 /*
        public void Flatten(TreeNode root) {
            solve(root, null);
        }
        TreeNode solve(TreeNode root, TreeNode last)    {
            if(root == null) return last;
            root.right = solve(root.left, solve(root.right, last));
            root.left = null;
            return root;
        }
        */

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        flatten(node1);
        System.out.println(node1.right.right.right.right.right.right);
    }
}
