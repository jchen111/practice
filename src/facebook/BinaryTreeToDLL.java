package facebook;

import CC150.TreeNode;

/**
 * Created by z001ktb on 6/18/17.
 */
public class BinaryTreeToDLL {
    /**
     * in-order traverse
     * left pointer serves as pre
     * right pointer serves as next
     * time O(N) where N is the size of the tree
     * space O(1)
     */
    static TreeNode head;
    static TreeNode pre;
    public static void binaryTreeToDLLInOrder(TreeNode root) {
        if(root == null) return;
        binaryTreeToDLLInOrder(root.left);
        if(pre == null){
            head = root;
            head.left = null;
        }else {
           root.left = pre;
           pre.right = root;
        }
        pre = root;
        binaryTreeToDLLInOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode n10 = new TreeNode(10);
        TreeNode n12 = new TreeNode(12);
        TreeNode n15 = new TreeNode(15);
        TreeNode n25 = new TreeNode(25);
        TreeNode n30 = new TreeNode(30);
        TreeNode n36 = new TreeNode(36);
        n10.left = n12; n10.right = n15;
        n12.left = n25; n12.right = n30;
        n15.left = n36;
        binaryTreeToDLLInOrder(n10);
    }


}
