package AmazonOA.phone;

import leetcode.ListNode;

/**
 * Created by z001ktb on 5/23/17.
 */
public class MergeTwoListsWithDuplicatesOut {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = new ListNode(l1.val);
                pre = pre.next;

                l1 = l1.next;
                while(l1 != null && l1.val == pre.val){
                    l1 = l1.next;
                }

            }else{
                pre.next = new ListNode(l2.val);
                pre = pre.next;

                l2 = l2.next;
                while(l2 != null && l2.val == pre.val){
                    l2 = l2.next;
                }
            }
        }

        while(l1 != null){
            pre.next = new ListNode(l1.val);
            pre = pre.next;

            l1 = l1.next;
            while(l1 != null && l1.val == pre.val){
                l1 = l1.next;
            }
        }

        while(l2 != null){
            pre.next = new ListNode(l2.val);
            pre = pre.next;

            l2 = l2.next;
            while(l2 != null && l2.val == pre.val){
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(1);
        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6;

        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(2);
        ListNode l9 = new ListNode(2);
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(3);

        l7.next = l8; l8.next = l9; l9.next = l10; l10.next = l11;

        ListNode res = mergeTwoLists(l1,l7);
    }
}
