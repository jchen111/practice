package leetcode;

import CC150.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jacky on 9/19/16.
 */
public class BinaryTreeLevelOrderTraversalII {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
        List<Integer> tmplevel = new ArrayList<Integer>();;
        Stack<List<Integer>> stack = new Stack<List<Integer>>();

        Stack<List<TreeNode>> levels = new Stack<List<TreeNode>>();
        List<TreeNode> looplevel = new ArrayList<TreeNode>();

        if(root == null ){
            return  toReturn;
        }

        looplevel.add(root);
        tmplevel.add(root.val);
        levels.push(looplevel);
        stack.push(tmplevel);

        while(!looplevel.isEmpty()){
            looplevel = new ArrayList<TreeNode>();
            tmplevel = new ArrayList<Integer>();
            for(int i = 0; i < levels.lastElement().size(); i++){
                TreeNode tmp = levels.lastElement().get(i);
                if(tmp.left != null) {
                    looplevel.add(tmp.left);
                    tmplevel.add(tmp.left.val);
                }
                if(tmp.right != null) {
                    looplevel.add(tmp.right);
                    tmplevel.add(tmp.right.val);
                }
            }
            if(!looplevel.isEmpty()){
                levels.push(looplevel);
                stack.push(tmplevel);
            }
        }

        //parsing the result
        while (!stack.isEmpty()){
            toReturn.add(stack.pop());
        }
        return toReturn;
    }

    public static void main(String[] args){

    }
}
