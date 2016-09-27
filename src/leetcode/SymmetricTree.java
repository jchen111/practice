package leetcode;

import CC150.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jiaqichen on 9/23/16.
 */
public class SymmetricTree {

    //iterative solution
    public static boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    //recursive solution
    public static boolean mirrorTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.val == root2.val){
            boolean f1 = mirrorTree(root1.left,root2.right);
            boolean f2 = mirrorTree(root1.right,root2.left);
            return f1&&f2;
        }
        return false;
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return mirrorTree(root.left,root.right);
    }

    public static void main(String[] args){
        TreeNode r = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode l2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode l3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode l4 = new TreeNode(4);
        r.left = l2;
        r.right = r2;
        l2.left = l3;
        l2.right = l4;
        r2.left = r4;
        r2.right = r3;
        System.out.println(isSymmetric(r));
    }
}
