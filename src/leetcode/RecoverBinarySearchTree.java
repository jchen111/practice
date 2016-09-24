package leetcode;

import CC150.TreeNode;

import java.util.ArrayList;

/**
 * Created by jacky on 9/22/16.
 */
public class RecoverBinarySearchTree {

    public static TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    public static TreeNode firstNode = null;
    public static TreeNode secondNode = null;
    public static void inOrderTraverse(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraverse(root.left);
        if(firstNode == null && root.val < preNode.val ){
            firstNode = preNode;
        }
        if(firstNode != null && root.val < preNode.val){
            secondNode = root;
        }
        preNode = root;
        inOrderTraverse(root.right);
    }

    public static void recoverTree(TreeNode root) {
        preNode = new TreeNode(Integer.MIN_VALUE);
        firstNode = null;
        secondNode = null;
        inOrderTraverse(root);
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }


    public static void main(String[] args){

    }
}
