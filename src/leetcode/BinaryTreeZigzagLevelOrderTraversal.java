package leetcode;

import CC150.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jiaqichen on 9/24/16.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> toReturn = new LinkedList<List<Integer>>();
        List<Integer> level = new LinkedList<Integer>();

        List<TreeNode> treeLevel = new LinkedList<TreeNode>();
        List<List<TreeNode>> treeLevels = new LinkedList<List<TreeNode>>();

        if(root == null){
            return toReturn;
        }

        //initializing first level
        int prelevelIndex = 0;
        treeLevel.add(root);
        level.add(root.val);
        treeLevels.add(prelevelIndex,treeLevel);
        toReturn.add(level);

        while(!treeLevel.isEmpty()){
            level = new LinkedList<Integer>();
            treeLevel = new LinkedList<TreeNode>();
            //loop through the previous level
            for (int i = treeLevels.get(prelevelIndex).size() - 1; i >= 0; i--) {
                TreeNode t = treeLevels.get(prelevelIndex).get(i);
                if (prelevelIndex % 2 == 0) { // scan the next level from right to left
                    if (t.right != null) {
                        level.add(t.right.val);
                        treeLevel.add(t.right);
                    }
                    if (t.left != null) {
                        level.add(t.left.val);
                        treeLevel.add(t.left);
                    }
                } else { //zigzag is achieved by alternate scan the next level from left to right.
                    if (t.left != null) {
                        level.add(t.left.val);
                        treeLevel.add(t.left);
                    }
                    if (t.right != null) {
                        level.add(t.right.val);
                        treeLevel.add(t.right);
                    }
                }
            }
            //initializing next level
            if(!treeLevel.isEmpty()){
                prelevelIndex++;
                treeLevels.add(prelevelIndex,treeLevel);
                toReturn.add(level);
            }
        }
        return toReturn;
    }

    public static void main(String[] args){

    }
}
