package CC150;
import java.util.ArrayList;
import java.util.HashSet;

import leetcode.ListNode;

public class main {
	public static ListNode removeSomeNodesFromList(HashSet<Integer> list, ListNode head){
	    ListNode copyhead = head;
	    ListNode pre = null;
	    while(copyhead!=null){
	        if(list.contains(copyhead.val) && pre==null){
	        	while(copyhead!=null && list.contains(copyhead.val)){
	        		copyhead = copyhead.next;
	        	}
	        	head = copyhead;
	        }
	        else if(list.contains(copyhead.val) && pre!=null){
	        	while(copyhead!=null && list.contains(copyhead.val)){
	        		copyhead = copyhead.next;
	        	}
	        	pre.next = copyhead;
	        }
	        if(copyhead!=null){
	        pre = copyhead;
	        copyhead = copyhead.next;
	        }
	    }
	    return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		HashSet<Integer> list = new HashSet<Integer>();
		list.add(2);
		ListNode res = removeSomeNodesFromList(list,n1);
		while(res!=null){
			System.out.print(res.val);
			res = res.next;
		}
	}

}
