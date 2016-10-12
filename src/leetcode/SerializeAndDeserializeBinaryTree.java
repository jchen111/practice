package leetcode;

import CC150.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jiaqichen on 10/10/16.
 */
public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("X").append(",");
        }else{
            sb.append(root.val).append(",");
            buildString(root.left,sb);
            buildString(root.right,sb);
        }
    }

    public TreeNode deserialize(String str){
        Deque<String> deque = new LinkedList<String>();
        deque.addAll(Arrays.asList(str.split(",")));
        return buildTree(deque);
    }

    public TreeNode buildTree(Deque<String> nodes){
        String tmp = nodes.remove();
        if(tmp.equals("X")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(tmp));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}
