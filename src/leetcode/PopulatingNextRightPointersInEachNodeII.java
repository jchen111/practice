package leetcode;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jiaqichen on 9/25/16.
 */
public class PopulatingNextRightPointersInEachNodeII {

    /*
    Time complexity: O(n), Space complexity: constant extra space
     */
    public static void connect2(TreeLinkNode root){
        if(root == null){
            return;
        }
        TreeLinkNode pre = null;
        TreeLinkNode current = root;
        TreeLinkNode currentLevelHead = root;
        TreeLinkNode nextLevelHead = null;

        while(currentLevelHead != null) {
            current = currentLevelHead;
            while (current != null) { //linking current level nodes while constructing next level
                //left child
                if (current.left != null) {
                    if (pre != null) {
                        pre.next = current.left;
                    } else {
                        nextLevelHead = current.left;
                    }
                    pre = current.left;
                }
                //right child
                if (current.right != null) {
                    if (pre != null) {
                        pre.next = current.right;
                    } else {
                        nextLevelHead = current.right;
                    }
                    pre = current.right;
                }
                current = current.next;
            }
            currentLevelHead = nextLevelHead;
            pre = null;
            nextLevelHead = null;
        }
    }

    //O(n) n space
    public static void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }

        int levelIndex = 0;
        LinkedList<TreeLinkNode> level = new LinkedList<TreeLinkNode>();
        LinkedList<LinkedList<TreeLinkNode>> levels = new LinkedList<LinkedList<TreeLinkNode>>();
        LinkedList<TreeLinkNode> newlevel;
        level.add(root);
        levels.add(levelIndex,level);

        TreeLinkNode pre = null;

        while(!levels.get(levelIndex).isEmpty()){
            level = levels.get(levelIndex);
            newlevel = new LinkedList<TreeLinkNode>();
            while(!level.isEmpty()) {
                TreeLinkNode node = level.poll();
                if (node.left != null) {
                    if (pre != null) {
                        pre.next = node.left;
                    }
                    pre = node.left;
                    newlevel.add(node.left);
                }
                if (node.right != null) {
                    if (pre != null) {
                        pre.next = node.right;
                    }
                    pre = node.right;
                    newlevel.add(node.right);
                }
            }
            if(level.isEmpty()){
                levelIndex++;
                levels.add(levelIndex,newlevel);
                pre = null;
            }
        }
        return;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int dimmy = sc.nextInt();
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n7 = new TreeLinkNode(7);

//        n1.left = n2;
        n1.right = n3;
//        n2.left = n4;
//        n3.right = n7;
        connect(n1);
        System.out.println(n1);
    }
}
