package leetcode;
import java.util.LinkedList;
import java.util.Queue;

import CC150.TreeNode;

public class BSTIterator {
	private LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	private TreeNode current = null;
	public void helper(TreeNode root){
		if(root!=null){
			helper(root.left);
			queue.add(root);
			helper(root.right);
		}
	}
	public BSTIterator(TreeNode root) {
        	helper(root);
        	if(!queue.isEmpty())
        		current = queue.getFirst();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!queue.isEmpty()){
        	return true;
        }else{
        	return false;
        }
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode tmp = queue.removeFirst();
    	if(!queue.isEmpty())
    		current = queue.getFirst();
    	else
    		current = null;
        return tmp.val;
    }
}
