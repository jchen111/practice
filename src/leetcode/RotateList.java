package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/19/16.
 */
public class RotateList {
    public static int len = 0;
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode h = head;
        ListNode r = head;
        len = 0;
        while(r != null){
            r = r.next;
            len++;
        }
        k %= len;
        if(k == 0) return head;
        h = reverse(h);
        ListNode p1 = h;
        ListNode p2 = h;
        ListNode pre = null;
        int i = 1;
        while(p2 != null && i <= k){
            pre = p2;
            p2 = p2.next;
            i++;
        }
        pre.next = null; //disconnect the linkedlist
        p2 = reverse(p2);
        ListNode res = reverse(p1);
        p1.next = p2;
        return res;
    }

    public static ListNode reverse(ListNode root){
        ListNode pre = null;
        while(root != null){
            ListNode second = root.next;
            root.next = pre;
            pre = root;
            root = second;
        }
        return pre;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(rotateRight(n1,k));
    }
}
