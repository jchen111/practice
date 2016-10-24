package leetcode;

import CC150.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static leetcode.PalindromePartitioning.list;

/**
 * Created by jiaqichen on 10/23/16.
 */
public class BinaryTreePaths {
    static List<String> res = new ArrayList<String>();
    static Stack<TreeNode> stack = new Stack<TreeNode>();
    public static List<String> binaryTreePaths(TreeNode root) {
        stack = new Stack<TreeNode>();
        res = new ArrayList<String>();
        if(root == null) return list;
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        stack.push(root);

        StringBuilder tmp = new StringBuilder(sb);
        helper(stack.pop(),tmp);

        return res;
    }

    public static void helper(TreeNode node, StringBuilder sb){
//        sb.append("->" + node.val);
        if(node.left == null && node.right == null){
            res.add(sb.toString());
            return;
        }
        if(node.left != null) {
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append("->" + node.left.val);
            stack.push(node.left);
            helper(stack.pop(),tmp);
        }
        if(node.right != null) {
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append("->" + node.right.val);
            stack.push(node.right);
            helper(stack.pop(),tmp);
        }
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2; t1.right = t3;
        t2.right = t5;
        binaryTreePaths(t1);
    }
}
