package leetcode;

public class DoubleLinkedListNode {
	DoubleLinkedListNode pre;
	DoubleLinkedListNode next;
	DoubleLinkedListNode head;
	DoubleLinkedListNode tail;
	int val;
	DoubleLinkedListNode(int val){
		this.val = val;
		this.pre = null;
		this.next = null;
	}
}
