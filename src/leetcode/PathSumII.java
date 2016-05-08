package leetcode;
import java.util.LinkedList;
import java.util.List;

import CC150.TreeNode;


public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> currentRes = new LinkedList<Integer>();
        findPathSum(root,res,currentRes,sum);
        return res;
    }
    public void findPathSum(TreeNode root, List<List<Integer>> res, List<Integer> currentRes,int sum){
        if(root==null) return;
        if(root.val == sum && root.left==null && root.right==null){
            currentRes.add(root.val);
            res.add(new LinkedList(currentRes));
            currentRes.remove(currentRes.size()-1);
            return;
        }
        else{
            Integer val = new Integer(root.val);
            currentRes.add(val);
            if(root.val<sum){
                findPathSum(root.left,res,currentRes,sum-val);
                findPathSum(root.right,res,currentRes,sum-val);
            }else if(root.val>sum){
                
            }
            currentRes.remove(currentRes.size()-1);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
