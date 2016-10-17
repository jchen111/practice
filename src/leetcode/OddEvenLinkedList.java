package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/13/16.
 */
public class OddEvenLinkedList {
    //O(n) constant extra space
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head; //odd half
        ListNode p2 = head.next; //even half
        ListNode m = p2;
        while(p2 != null && p2.next != null){
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p2.next.next;
            p2 = p2.next;
        }
        p1.next = m; // connect even half and odd half
        return head;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        ListNode n = oddEvenList(n1);
        while(n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}
