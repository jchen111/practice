package leetcode;
import java.util.LinkedList;
import java.util.List;

import CC150.TreeNode;

public class BinaryTreeInorderTraversal {
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> list = new LinkedList<Integer>();
		if(root!=null){
			list.addAll(inorderTraversal(root.left));
			list.add(root.val);
			list.addAll(inorderTraversal(root.right));
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.right = t2;
		t2.left = t3;
	}

}
