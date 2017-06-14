package facebook;

import CC150.TreeNode;

import java.util.*;

/**
 * Created by z001ktb on 6/7/17.
 */
public class PrintBinaryTreeInVerticalOrder {

    public static List<List<Integer>> verticalOrderTraverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> colmap = new HashMap<Integer,List<Integer>>();
        helper(root, colmap, 0);
        List<Integer> keys = new ArrayList<Integer>(colmap.keySet());
        Collections.sort(keys);
        for(Integer key : keys) {
            result.add(colmap.get(key));
        }
        return result;
    }

    public static void helper(TreeNode root, Map<Integer, List<Integer>> colmap, int column) {
        if(root == null) return;
        List<Integer> list = colmap.containsKey(column) ? colmap.get(column) : new ArrayList<Integer>();
        list.add(root.val);
        colmap.put(column,list);
        helper(root.left, colmap, column - 1);
        helper(root.right, colmap, column + 1);
    }

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    // O(n^2)
    public static void printVerticalOrder(TreeNode root) {

        findMaxAndMin(root,  0); // n

        for(int i = min; i <= max; i++) { // n
            printColumn(root, i, 0); // n
            System.out.println();
        }
    }

    public static void printColumn(TreeNode root, int col, int dis) {
        if(root == null) return;

        if(dis == col) System.out.print(root.val + " ");

        printColumn(root.left, col, dis - 1);
        printColumn(root.right, col, dis + 1);
    }

    public static void findMaxAndMin(TreeNode root, int dis) {
        if(root == null) return;

        if(dis < min) min = dis;
        else if(dis > max) max = dis;

        findMaxAndMin(root.left,  dis - 1);
        findMaxAndMin(root.right,  dis + 1);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n6.right = n8;
        n7.right = n9;

//        List<List<Integer>> result = verticalOrderTraverse(n1);
//        System.out.print(result);
        printVerticalOrder(n1);

    }
}
