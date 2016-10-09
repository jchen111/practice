package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import CC150.Node;
import CC150.TreeNode;

public class main {
	public static List<List<Integer>> password4(int n1,int n2,int n3,int index){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(index==1){
			for(int i=0;i<10;i++){
				List<Integer> sublist = new ArrayList<Integer>();
				if(i!=n1 && i!=n2 && i!=n3){
					sublist.add(i);
				}
				if(!sublist.isEmpty())
					list.add(sublist);
			}
			return list;
		}
		list = password4(n1,n2,n3,index-1);
		List<List<Integer>> morelist = new ArrayList<List<Integer>>();
		for(int j=0;j<list.size();j++){
			for(int i=0;i<10;i++){
				List<Integer> sublist = new ArrayList<Integer>();
				if(i!=n1 && i!=n2 && i!=n3 && list.get(j).get(index-1-1)!=i){
					if(i==4){
						if(list.get(j).get(0)==4){
							sublist.addAll(list.get(j));
							sublist.add(i);
							morelist.add(sublist);
						}
					}else{
						sublist.addAll(list.get(j));
						sublist.add(i);
						morelist.add(sublist);
					}
				}
			}
		}
		return morelist;
	}
	/*merge two sorted linked list*/
	public static ListNode mergeSortList(ListNode head){
		if(head==null) return null;
		if(head.next==null){
			return head;
		}else{
			ListNode sub1 = head;
			ListNode sub2 = head.next;
			sub1.next =null;
			return mergeTwoSortedList(mergeSortList(sub1),mergeSortList(sub2));
		}
	}
	public static ListNode mergeTwoSortedList(ListNode head1,ListNode head2){
		ListNode head = new ListNode(0);
		LinkedList<ListNode> list = new LinkedList<ListNode>();
		while(head1!=null && head2!=null){
			if(head1.val<head2.val){
				head.val = head1.val;
				head.next = new ListNode(0);
				list.add(head);
				head = head.next;
				head1 = head1.next;
			}else{
				head.val = head2.val;
				head.next = new ListNode(0);
				list.add(head);
				head = head.next;
				head2 = head2.next;
			}
		}
		while(head1!=null){
			list.add(head1);
			head1 = head1.next;
		}
		while(head2!=null){
			list.add(head2);
			head2 = head2.next;
		}
//		for(int i=0;i<list.capacity()-1;i++){
//			list.get(i).next = list.get(i+1);
//		}
		ListNode output = list.getFirst();
		ListNode copy = output;
		list.removeFirst();
		while(!list.isEmpty()){
			output.next = list.removeFirst();
			output = output.next;
		}
		return copy;
	}
	/* reverse list between range*/
	public static ListNode reverseBetween(ListNode head, int m, int n){
		if(m==n) return head;
		ListNode copyhead = head;
		ListNode first = null;
		ListNode last = null;
		ListNode previous = null;
		int iterator = 1;
		LinkedList<ListNode> list = new LinkedList<ListNode>();
		while(head!=null){
				if(iterator == m) {
					first = head;
					while(head!=null && iterator<=n){
						list.add(head);
						iterator++;
						head = head.next;
					}
					if(m==1){
						previous = list.removeLast();
						copyhead = previous;
						while(!list.isEmpty()){
							previous.next = list.removeLast();
							previous = previous.next;
						}
						previous.next = head;
						break;
					}else{
						while(!list.isEmpty()){
							previous.next = list.removeLast();
							previous = previous.next;
						}
						previous.next = head;
						break;
					}
				}
			iterator++;
			previous = head;
			head = head.next;
		}
		return copyhead;
	}
	/* reverse a linked list*/
	public static ListNode reverse(ListNode head){
		ListNode last = null;
		if(head==null){
			return null;
		}else if(head.next == null){
			return head;
		}
		else{
			ListNode second = head.next;
			head.next = null;
			last = reverse(second);
			second.next = head;
		}
		return last;
	}
	
	public static int climbStairs(int n){
	    int[] step = new int[n+1];
		for(int i=1;i<=n; i++){
	    	if(i==1){
	    		step[i]=1;
	    	}
	    	else if(i==2){
	    		step[i]=2;
	    	}else{
	        step[i] = step[i-1]+step[i-2];
	    	}
	    }
		return step[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LRUCache LRU = new LRUCache(3);
//		LRU.set(1,1);
//		LRU.set(2,2);
//		LRU.set(3,3);
//		LRU.set(4,4);
//		System.out.println(LRU.get(4));
//		System.out.println(LRU.get(3));
//		System.out.println(LRU.get(2));
//		System.out.println(LRU.get(1));
//		LRU.set(5, 5);
//		System.out.println(LRU.get(1));
//		System.out.println(LRU.get(2));
//		System.out.println(LRU.get(3));
//		System.out.println(LRU.get(4));
//		System.out.println(LRU.get(5));
//		ListNode n1 = new ListNode(1);
//		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(4);
//		ListNode n5 = new ListNode(5);
//		ListNode n6 = new ListNode(6);
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
//		ListNode tmp = reverseBetween(n1,2,6);
//		while(tmp!=null){
//			System.out.print(tmp.val+" ");
//			tmp =tmp.next;
//		}
//		ListNode n1 = new ListNode(1);
//		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(4);
//		ListNode n5 = new ListNode(5);
//		ListNode n6 = new ListNode(6);
//		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
//		ListNode n0 = mergeSortList(n1);
//		ListNode n0 = mergeTwoSortedList(n6,n1);
//		while(n0!=null){
//			System.out.print(n0.val);
//			n0=n0.next;
//		}
//		System.out.print(climbStairs(4));
//		TreeNode t1 = new TreeNode(1);
//		TreeNode t2 = new TreeNode(2);
//		TreeNode t3 = new TreeNode(3);
//		TreeNode t4 = null;
//		t2.left = t1;
//		t2.right = t3;
//		BSTIterator i = new BSTIterator(t4);
//		while (i.hasNext()){
//			System.out.println(i.next());
//		}
//		List<List<Integer>> result = password4(2,3,5,3);
//		for(int i=0;i<result.capacity();i++){
//			for(int j=0;j<result.get(i).capacity();j++){
//				System.out.print(result.get(i).get(j)+" ");
//			}
//			System.out.println();
//		}
		System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
        System.out.println("The Min val is " + maxHeap.pop());
	}

}
