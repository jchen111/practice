package leetcode;

import java.util.Hashtable;

public class DetectCycle {
	public static ListNode detectCycle(ListNode head){
		Hashtable<ListNode,Boolean> table = new Hashtable<ListNode,Boolean>();
		while(head!=null){
			if(!table.containsKey(head)){
				table.put(head, true);
			}else{
				break;
			}
			head = head.next;
		}
		return head;
	}
	public static ListNode detectCycle2(ListNode head){
		if(head==null) return null;
		ListNode n1 = head;
		ListNode n2 = head;
		while(n2!=null && n2.next!=null){
			n1 = n1.next;
			n2 = n2.next.next;
			if(n1==n2){
				break;
			}
		}
		if(n2==null){
			return null;
		}
			if(n2.next == null)
				return null;
			n1 = head;
			while(n1!=n2){
				n1 = n1.next;
				n2 = n2.next;
			}
			return n1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
//		n6.next = n1;
		System.out.println(detectCycle2(n1));
	}

}
