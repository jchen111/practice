package leetcode;

import CC150.TreeNode;

public class ConvertBSTtoDDL {
    static TreeNode pre;
    public static TreeNode convert(TreeNode root) {
        pre = null;
        doCovert(root);

        while(pre != null && pre.left != null) {
            pre = pre.left;
        }
        return pre;
    }

    private static void doCovert(TreeNode cur) {
        if(cur == null) return;

        doCovert(cur.left);

        if(pre != null) pre.right = cur;

        cur.left = pre;
        pre = cur;

        doCovert(cur.right);

    }


    public static void main(String[] args) {
        TreeNode n10 = new TreeNode(10);
        TreeNode n6 = new TreeNode(6);
        TreeNode n14 = new TreeNode(14);
        TreeNode n8 = new TreeNode(8);
        TreeNode n4 = new TreeNode(4);
        TreeNode n12 = new TreeNode(12);
        TreeNode n16 = new TreeNode(16);
        n10.left = n6;
        n10.right = n14;
        n6.left = n4;
        n6.right = n8;
        n14.left = n12;
        n14.right = n16;
        TreeNode res = convert(n10);
    }
}
