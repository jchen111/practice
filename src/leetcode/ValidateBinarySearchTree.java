package leetcode;
import java.util.LinkedList;

import CC150.TreeNode;

public class ValidateBinarySearchTree {
	public static LinkedList<TreeNode> helperTraverse(TreeNode root){
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		if(root!=null){
			list.addAll(helperTraverse(root.left));
			list.add(root);
			list.addAll(helperTraverse(root.right));
		}
		return list;
	}
	public static boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> list;
		if(root!=null){
        	list = helperTraverse(root);
        	for(int i=0;i<list.size()-1;i++){
    			if(list.get(i).val>=list.get(i+1).val){
    				return false;
    			}
    		}
        	return true;
        }else{
        	return false;
        }
    }
	
	public boolean isValidBST2(TreeNode root) {
        if(root==null){
        	return true;
        }
        if(root.left == null || root.right ==null){
        	if(root.left==null && root.right ==null)
        		return true;
        	if(root.left==null && root.val<root.right.val)
        		return isValidBST(root.right) && root.val<minOfBST(root.right);
        	if(root.right==null && root.val>root.left.val)
        		return isValidBST(root.left) && root.val>maxOfBST(root.left);
        	return false;
        }
        if(root.left.val<root.val && root.val<root.right.val && root.val>maxOfBST(root.left) && root.val<minOfBST(root.right)){
        	return isValidBST(root.left) && isValidBST(root.right);
        }else{
        	return false;
        }
    }
	public int maxOfBST(TreeNode root){
		if(root!=null){
			if(root.right==null){
				return root.val;
			}else{
				return maxOfBST(root.right);
			}
		}else{
			return 0;
		}
	}
	public int minOfBST(TreeNode root){
		if(root!=null){
			if(root.left==null){
				return root.val;
			}else{
				return maxOfBST(root.left);
			}
		}else{
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
