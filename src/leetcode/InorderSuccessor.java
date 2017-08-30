package leetcode;

import CC150.TreeNode;

public class InorderSuccessor {
    static TreeNode target;
    static boolean found;
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return target;
    }

    private static void dfs(TreeNode root, TreeNode p) {
        if(root == null) {
            return;
        }
        if(found) {
            target = root;
            return;
        }

        dfs(root.left, p);
        if(target != null) {
            return;
        }
        if(found) {
            target = root;
            return;
        }
        if(root == p) {
            found = true;
        }
        dfs(root.right, p);

    }

    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        n2.left = n1;
        TreeNode res = inorderSuccessor(n2, n1);
        System.out.println(res.val);
    }
}
