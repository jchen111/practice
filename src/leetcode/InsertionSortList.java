package leetcode;

import java.util.LinkedList;

public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
		ListNode helper=new ListNode(0);
	    ListNode pre=helper;
	    ListNode current=head;
	    while(current!=null) {
	    	ListNode next=current.next;
	        pre=helper;
	        while(pre.next!=null&&pre.next.val<current.val) {
	            pre=pre.next;
	        }
	        current.next=pre.next;
	        pre.next=current;
	        current=next;
	    }
	    return helper.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
//		n1.next = n4; n4.next = n3;
//		n1.next = n2; n2.next = n3;
//		n3.next = n4; n4.next = n1;
//		n1.next = n5; n5.next = n4; n4.next = n3; n3.next = n2;
		n1.next = n3; n3.next = n4; n4.next = n5; n5.next = n2;
		ListNode n0 = insertionSortList(n1);
		while(n0!=null){
			System.out.println(n0.val);
			n0 = n0.next;
		}
	}

}
