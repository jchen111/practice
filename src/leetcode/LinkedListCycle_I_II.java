package leetcode;

public class LinkedListCycle_I_II {
	public static ListNode detectCycle(ListNode head){
		if(head==null) return null;
		if(head.next==null || head.next.next==null) return null;
		ListNode pointer1 = head;
		ListNode pointer2 = head;
		while(pointer1!=null && pointer2!=null){
			pointer1 = pointer1.next;
			if(pointer2.next==null || pointer2.next.next==null)
				return null;
			else
				pointer2 = pointer2.next.next;
			if(pointer1==pointer2){
				break;
			}
		}
		if(pointer2==null || pointer2.next==null)
			return null;
		if(pointer1==pointer2){
			pointer1 = head;
			while(pointer1!=pointer2){
				pointer1 = pointer1.next;
				pointer2 = pointer2.next;
			}
			return pointer1;
		}
		return null;
	}
	public static boolean hasCycle(ListNode head){
		if(head==null) return false;
		if(head.next==null || head.next.next==null) return false;
		ListNode pointer1 = head;
		ListNode pointer2 = head;
		while(pointer1!=null && pointer2!=null){
			pointer1 = pointer1.next;
			if(pointer2.next==null || pointer2.next.next==null)
				return false;
			else
				pointer2 = pointer2.next.next;
			if(pointer1==pointer2){
				return true;
			}
		}
//		if(pointer1==pointer2) return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2; n2.next = n3; n3.next = n4;n4.next = n5; n5.next = n6; n6.next = n7; n7.next = n4;
		System.out.println(hasCycle(n1));
//		System.out.println(detectCycle(n1).val);
	}

}
