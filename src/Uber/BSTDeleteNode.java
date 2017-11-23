package Uber;

import CC150.TreeNode;

/**
 * Created by z001ktb
 */
public class BSTDeleteNode {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        if(root.val == key && root.left == null && root.right == null) {
            return null;
        }

        if(root.val == key) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if(right != null && left != null) {
                root.val = findmax(left).val;
                root.left = deleteNode(left, root.val);
            } else {
                if(left == null) {
                    return root.right;
                }
                return root.left;
            }
        } else {
            if(root.val > key) {
                root.left = deleteNode(root.left, key);
            }
            if(root.val < key) {
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }

    private static TreeNode findmax(TreeNode root) {
        if(root == null || root.right == null) return root;
        return findmax(root.right);
    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        t5.left = t3;
        t5.right = t6;
        t3.left = t2;
        t3.right = t4;
        t6.right = t7;

        TreeNode res = deleteNode(t5, 3);
        System.out.println(res.val);
    }
}
