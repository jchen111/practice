package leetcode;

import CC150.TreeNode;

/**
 * Created by z001ktb on 10/21/16.
 */
public class SortedListToBST {
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode first = head;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = null;
        while(p2 != null && p2.next != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        pre.next = null;
        ListNode second = p1.next;
        TreeNode root = new TreeNode(p1.val);
        root.left = sortedListToBST(first);
        root.right = sortedListToBST(second);
        return root;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
        n1.next = n2;
//        n2.next = n3;
        System.out.println(sortedListToBST(n1));
    }
}
