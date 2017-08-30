package leetcode;

import CC150.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Scanner;

/**
 * Created by z001ktb on 10/10/16.
 */
public class SerializeAndDeserializeBinaryTree {

    public static String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    public static void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("X").append(",");
        }else{
            sb.append(root.val).append(",");
            buildString(root.left,sb);
            buildString(root.right,sb);
        }
    }

    public static TreeNode deserialize(String str){
        Deque<String> deque = new LinkedList<String>();
        deque.addAll(Arrays.asList(str.split(",")));
        return buildTree(deque);
    }

    public static TreeNode buildTree(Deque<String> nodes){
        String tmp = nodes.remove();
        if(tmp.equals("X")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(tmp));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        String str = sc.next();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        System.out.println(serialize(t1));

        deserialize(serialize(t1));
    }
}
