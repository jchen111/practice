package leetcode;

/**
 * Created by jiaqichen on 10/30/16.
 */
public class PlusOneLinkedList {
    public static ListNode plusOne(ListNode head) {
        if(head == null) return null;
        ListNode p1 = head;
        ListNode pre = null;
        while(p1 != null){
            ListNode next = p1.next;
            p1.next = pre;
            pre = p1;
            p1 = next;
        }
        ListNode p2 = pre;
        ListNode pre3 = null;
        int carry = 1;
        while(p2 != null){
            pre3 = p2;
            p2.val += carry;
            if(p2.val > 9){
                p2.val %= 10;
                carry = 1;
            }else{
                carry = 0;
                break;
            }
            p2 = p2.next;
        }
        if(carry != 0){
            pre3.next = new ListNode(1);
        }

        ListNode p3 = pre;
        ListNode pre2 = null;
        while(p3 != null){
            ListNode next = p3.next;
            p3.next = pre2;
            pre2 = p3;
            p3 = next;
        }
        return pre2;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        plusOne(n1);
    }
}
