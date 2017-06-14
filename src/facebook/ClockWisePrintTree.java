package facebook;

import CC150.TreeNode;

/**
 * Created by z001ktb on 6/12/17.
 */
public class ClockWisePrintTree {
    public static void printTree(TreeNode root) {
        if(root != null){
            System.out.print(root.val + " ");
            printRightTopDown(root.right);
            printLeavesRightToLeft(root);
            printLeftBottomUp(root.left);
        }
    }

    public static void printLeavesRightToLeft(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            System.out.print(root.val + " ");
        }
        printLeavesRightToLeft(root.right);
        printLeavesRightToLeft(root.left);
    }

    public static void printLeftBottomUp(TreeNode root) {
        if(root == null || root.left == null) return;
        printLeftBottomUp(root.left);
        System.out.print(root.val + " ");
    }

    public static void printRightTopDown(TreeNode root) {
        if(root == null || root.right == null) return;
        System.out.print(root.val + " ");
        printRightTopDown(root.right);
    }

    public static void main(String[] args) {
        TreeNode n20 = new TreeNode(20);
        TreeNode n8 = new TreeNode(8);
        TreeNode n22 = new TreeNode(22);
        TreeNode n4 = new TreeNode(4);
        TreeNode n12 = new TreeNode(12);
        TreeNode n25 = new TreeNode(25);
        TreeNode n10 = new TreeNode(10);
        TreeNode n14 = new TreeNode(14);
        n20.left = n8; n20.right = n22;
        n8.left = n4; n8.right = n12;
        n12.left = n10; n12.right = n14;
        n22.right = n25;

        printTree(n20);
    }
}
