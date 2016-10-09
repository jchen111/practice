package leetcode;

/**
 * Created by jiaqichen on 10/9/16.
 */
public class PalindromeLinkedList {
    //O(n) constant extra space
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow);

        while(slow != null && head != null){
            if(slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return slow == null;
    }

    //reverse linked list in space
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
