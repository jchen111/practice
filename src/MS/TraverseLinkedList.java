package MS;

import leetcode.ListNode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by z001ktb on 5/6/17.
 */
public class TraverseLinkedList {

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode cycle = null;
        do{
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }while(fast != null && fast.next != null);
        return cycle;
    }

    public static void traverse(ListNode head) {
        ListNode cycle = detectCycle(head);
        boolean checked = false;
        while(head != null){
            if(head == cycle){
                if(checked){
                    break;
                }
                checked = true;
            }
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        traverse(n1);
    }
}
