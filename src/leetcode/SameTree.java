package leetcode;
import java.util.ArrayList;
import java.util.List;

import CC150.TreeNode;

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p==null && q==null){
    		return true;
    	}else if((p!=null && q!=null) && (p.val==q.val) ){
    		return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    	}
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
