package leetcode;

import java.util.Hashtable;
import java.util.LinkedList;

public class hasCircle {
	public static boolean hasCycle(ListNode head){
		Hashtable list = new Hashtable();
		while(head!=null){
			if(!list.containsKey(head)){
				list.put(head,true);
			}else
				return true;
			head = head.next;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n1;
//		n2.next = n3;
//		n3.next = n4;
		System.out.println(hasCycle(n1));
	}

}
