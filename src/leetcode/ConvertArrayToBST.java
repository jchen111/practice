package leetcode;

import CC150.TreeNode;

public class ConvertArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return doCovert(nums, 0, nums.length - 1);
    }

    private static TreeNode doCovert(int[] nums, int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);
        int mid = start + (end - start + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = doCovert(nums, start, mid - 1);
        root.right = doCovert(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        TreeNode root = sortedArrayToBST(arr);
    }
}
