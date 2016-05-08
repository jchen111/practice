package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import CC150.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public static List<List<Integer>> levelOrder(TreeNode root) {
        int level = 0;
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        result.add(level,list);
        while(!list.isEmpty()){
        	list = new LinkedList<TreeNode>();
        	for(int i=0;i<result.get(level).size();i++){
        		TreeNode tmp = result.get(level).get(i);
        		if(tmp.left!=null) list.add(tmp.left);
        		if(tmp.right!=null) list.add(tmp.right);
        	}
        	if(!list.isEmpty()){
        		result.add(level+1,list);
        	}
        	level++;
        }
        List<List<Integer>> finalresult = new ArrayList<List<Integer>>();
        for(int i=0;i<result.size();i++){
        	LinkedList<Integer> finallist = new LinkedList<Integer>();
        	for(int j=0;j<result.get(i).size();j++){
        		finallist.add(result.get(i).get(j).val);
        	}
        	finalresult.add(finallist);
        }
        return finalresult;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
