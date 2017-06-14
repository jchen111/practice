package MS;

import CC150.TreeNode;
import java.util.Stack;

/**
 * Created by z001ktb on 5/2/17.
 */
public class LeafsToLinkedList {

    static TreeNode dummy = new TreeNode(-1);
    static Stack<TreeNode> stack = new Stack<TreeNode>();
    public static TreeNode linkLeafs(TreeNode root) {
        if(root == null) return null;
        stack.push(dummy);
        doLinkLeafs(root);
        return dummy.right;
    }

    public static void doLinkLeafs(TreeNode cur) {
        if(cur == null) {
            return;
        }

        if(cur.left == null && cur.right == null) {
            TreeNode pre = stack.pop();
            pre.right = cur;
            stack.push(cur);
        }
        doLinkLeafs(cur.left);
        doLinkLeafs(cur.right);
    }

    public static boolean isLeaf(TreeNode root) {
        return root != null && (root.left == null && root.right == null);
    }

    public static void main(String[] args) {
        TreeNode t10 = new TreeNode(10);
        TreeNode t5 = new TreeNode(5);
        TreeNode t12 = new TreeNode(12);
        TreeNode t7 = new TreeNode(7);
        TreeNode t11 = new TreeNode(11);
        TreeNode t15 = new TreeNode(15);
        t10.left = t5;
        t10.right = t12;
        t5.right = t7;
        t12.left = t11;
        t12.right = t15;

        TreeNode result = linkLeafs(t10);
        System.out.println(result.val);
    }
}
