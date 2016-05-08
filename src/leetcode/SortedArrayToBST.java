package leetcode;
import java.util.Arrays;

import CC150.TreeNode;
public class SortedArrayToBST {
	public static void preOrderTraverse(TreeNode root){
		if(root == null){
			return;
		}
		System.out.print(root.val+" ");
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}
	public static TreeNode sortedArrayToBST(int[] num) {
        int length = num.length;
        int mid = length/2;
        if(length==0) return null;
        if(length==1){
        	return new TreeNode(num[0]);
        }
        int[] sub1 = Arrays.copyOfRange(num, 0, mid);
        int[] sub2 = Arrays.copyOfRange(num, mid+1, length);
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(sub1);
        root.right = sortedArrayToBST(sub2);
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,4,5,6,7};
		TreeNode root = sortedArrayToBST(num);
		preOrderTraverse(root);
		
	}

}
