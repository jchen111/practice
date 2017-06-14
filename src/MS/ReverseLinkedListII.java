package MS;

import leetcode.ListNode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by z001ktb on 5/6/17.
 */
public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode root = head;
        ListNode pre = null;
        int count = 0;
        while(head != null && count < m-1){
            pre = head;
            head = head.next;
            count++;
        }
        if(pre != null) pre.next = reverse(head, n-m);
        else return reverse(head, n-m);
        return root;
    }

    public static ListNode reverse(ListNode head, int k) {
        ListNode pre = null;
        ListNode tail = head;
        ListNode nxt = null;
        int count = 0;
        while(head != null && count < k+1){
            count++;
            ListNode next = head.next;
            nxt = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        if(tail != null) tail.next = nxt;
        if(pre == null) return head;
        return pre;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<ListNode> s = new Stack<ListNode>();
        int N = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        ListNode dummy = new ListNode(-1);
        s.push(dummy);
        for(int i = 0; i < N; i++){
            int v = sc.nextInt();
            ListNode tmp = new ListNode(v);
            ListNode pre = s.pop();
            if(pre != null){
                pre.next = tmp;
            }
            s.push(tmp);
        }
        ListNode r = reverseBetween(dummy.next, m, n);
        System.out.println(r);
    }
}
