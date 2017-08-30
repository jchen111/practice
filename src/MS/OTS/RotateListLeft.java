package MS.OTS;

import leetcode.ListNode;

public class RotateListLeft {
    /**
     *  1 -> 2 -> 3 -> 4 -> 5 -> null
     *  k = 2
     *  3 -> 4 -> 5 -> 1 -> 2 -> null
     *
     *  1 -> 2 -> 3 -> 4 -> 5 -> null
     *  to
     *  5 -> 4 -> 3 -> 2 -> 1 -> null
     *  to
     *  5 -> 4 -> 3 2 -> 1 -> null
     *  to
     *  3 -> 4 -> 5 -> 1 -> 2 -> null
     *  done
     * **/
    public static ListNode rotateLeft(ListNode head, int k) {
        head = reverse(head);
        ListNode fast = head;
        ListNode slow = fast;
        ListNode pre = null;
        int count = 1;
        while(fast.next != null) {
            if(count >= k) {
                pre = slow;
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }

        pre.next = null;
        ListNode newhead = reverse(head);
        head.next = reverse(slow);
        return newhead;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

        ListNode r = rotateLeft(n1,2);
    }
}
