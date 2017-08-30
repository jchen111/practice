package MS.OTS;

import leetcode.ListNode;

public class RotateList {
    /**
     *  1 2 3 4 5

     5 4 3 2 1 reverse the original list

     5 4, 3 2 1 disconnect the first k nodes and the rest of the list
     4 5 1 2 3 reverse them respectfully and linked them together
     time O(2*N)
     space O(1)
     * **/
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k < 1) return head;
        head = reverse(head);
        ListNode p = head;
        int len = 0;
        while(p != null) {
            p = p.next;
            len++;
        }
        k = k % len;
        p = head;
        ListNode pre = null;
        ListNode second = null;
        for(int i = 0; i < k; i++) {
            pre = p;
            p = p.next;
        }
        if(pre != null) {
            second = pre.next;
            pre.next = null;
        }
        ListNode newhead = reverse(head);
        head.next = reverse(second);
        return newhead;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode second = head.next;
            head.next = pre;
            pre = head;
            head = second;
        }
        if(pre != null) return pre;
        return head;
    }
}
