package leetcode;

import java.util.Stack;

/**
 * Created by jiaqichen on 12/6/16.
 */
public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode n1 = l1;
        ListNode n2 = l2;
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        while(n1 != null || n2 != null){
            if(n1 != null) {
                s1.push(n1);
                n1 = n1.next;
            }
            if(n2 != null) {
                s2.push(n2);
                n2 = n2.next;
            }
        }

        int carry = 0;
        Stack<ListNode> result = new Stack<ListNode>();

        while(!s1.isEmpty() && !s2.isEmpty()){
            n1 = s1.pop();
            n2 = s2.pop();
            result.push(new ListNode((n1.val + n2.val + carry)%10));
            if(n1.val + n2.val + carry > 9) carry = 1;
            else carry = 0;

        }

        while(!s1.isEmpty()){
            n1 = s1.pop();
            result.push(new ListNode((n1.val + carry)%10));
            if(n1.val + carry > 9) carry = 1;
            else carry = 0;
        }

        while(!s2.isEmpty()){
            n2 = s2.pop();
            result.push(new ListNode((n2.val + carry)%10));
            if(n2.val + carry > 9) carry = 1;
            else carry = 0;
        }

        if(carry != 0) {
            result.push( new ListNode(1));
        }
        ListNode head = result.peek();
        while(!result.isEmpty()){
            result.pop().next = result.isEmpty()? null:result.peek();
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode cn4 = new ListNode(4);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n7.next = n2; n2.next = n4; n4.next = n3;
        n5.next = n6; n6.next = cn4;

        System.out.println(addTwoNumbers(n7,n5));
    }
}
