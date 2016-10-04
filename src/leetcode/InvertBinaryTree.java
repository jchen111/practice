package leetcode;

import CC150.TreeNode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/3/16.
 */
public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        invertTree(t1);
    }
}
