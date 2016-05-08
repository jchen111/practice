package leetcode;

import java.util.LinkedList;

public class MergeTwoSortedList {
	public static ListNode mergeTwoSortedList(ListNode head1,ListNode head2){
		ListNode head = new ListNode(0);
		ListNode pre = head;//pre will always stay in the air
		LinkedList<ListNode> list = new LinkedList<ListNode>();
		while(head1!=null && head2!=null){
			if(head1.val<head2.val){
				pre.next = head1;
				head1 = head1.next;
			}else{
				pre.next = head2;
				head2 = head2.next;
			}
			pre = pre.next;
		}
		while(head1!=null){
			pre.next = head1;
			head1 = head1.next;
			pre = pre.next;
		}
		while(head2!=null){
			pre.next = head2;
			head2 = head2.next;
			pre = pre.next;
		}
		return head.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
//		ListNode n0 = mergeSortList(n1);
		ListNode n0 = mergeTwoSortedList(n6,n1);
		while(n0!=null){
			System.out.print(n0.val);
			n0=n0.next;
		}
	}

}
