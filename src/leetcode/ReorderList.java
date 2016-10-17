package leetcode;

/**
 * Created by jiaqichen on 10/13/16.
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        ListNode l1 = head;
        while(fast!= null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; // disconnect the first half and second half of the linkedlist

        ListNode l2 = reverse(slow); // reverse second half
        merge(l1,l2); // reorder the linked list
    }

    public static void merge(ListNode l1, ListNode l2){
        while(l1 != null){
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;

            if(n1 == null) break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode second = head.next;
            head.next = pre;
            pre = head;
            head = second;
        }
        return pre;
    }

    public static void main(String[] args){

    }
}
