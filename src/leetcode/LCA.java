package leetcode;

import CC150.TreeNode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/1/16.
 */
public class LCA {
    //O(log(n))
    public static boolean findNode(TreeNode root, TreeNode target){
        if(root == null){
            return false;
        }
        if(target.val < root.val){
            return findNode(root.left, target);
        }
        else if(target.val > root.val){
            return findNode(root.right, target);
        }else{
            return true;
        }
    }

    //O((logN)^2)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(findNode(root,p) && findNode(root,q)){
            TreeNode left = null, right = null;
            if(Math.min(p.val, q.val) > root.val){
                left = lowestCommonAncestor(root.right,p,q); //O(logN)
            }else if(Math.max(p.val,q.val) < root.val){
                right = lowestCommonAncestor(root.left,p,q);
            }
            else{
                return root;
            }

            if(left != null){
                root = left;
            }else if(right != null){
                root = right;
            }
        }else{
            return null;
        }
        return root;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.next();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n2.left = n1;
        TreeNode root = lowestCommonAncestor(n2,n1,n2);
        System.out.println(root.val);
    }
}
