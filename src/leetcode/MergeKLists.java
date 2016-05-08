package leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
	public static ListNode mergeKLists(List<ListNode> lists) {
		if(lists.isEmpty()) return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
			@Override
			public int compare(ListNode l1, ListNode l2){
				if(l1.val<l2.val){
					return -1;
				}else if(l1.val>l2.val){
					return 1;
				}else
					return 0;
			}
		});
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		for(ListNode node:lists){
			if(node!=null){
				queue.add(node);
			}
		}
		while(!queue.isEmpty()){
			tail.next = queue.poll();
			tail = tail.next;
			if(tail.next!=null) queue.add(tail.next);
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
