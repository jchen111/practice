package leetcode;

public class addTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode root = new ListNode(0);
		int add = 0;
		if(l1!=null && l2!=null){
			if(l1.val+l2.val>=10)
			{
				root.val = l1.val+l2.val-10;
				add+=1;
			}else{
				root.val = l1.val+l2.val;
			}
		}else{
			if(l1==null && l2!=null) root.val = l2.val;
			else if(l1!=null && l2==null) root.val = l1.val;
			else root = null;
		}
		ListNode copyroot = root;
		l1 = l1.next; l2 = l2.next;
		while(l1!=null && l2!=null){
			while(root.next!=null){
				root = root.next;
			}
			ListNode currentNode = new ListNode(0);
			currentNode.val = (l1.val+l2.val)%10;
			if(add!=0) {
				currentNode.val+=1;
				if(currentNode.val>=10) {
					currentNode.val -=10;
					add+=1;
				}
				add -=1;
			}
			if(l1.val+l2.val>=10) add+=1;
			root.next = currentNode;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1!=null){
			while(root.next!=null){
				root = root.next;
			}
			ListNode currentNode = new ListNode(0);
			currentNode.val = l1.val;
			if(add!=0) {
				currentNode.val+=1;
				if(currentNode.val>=10) {
					currentNode.val -=10;
					add+=1;
				}
				add -=1;
			}
			root.next = currentNode;
			l1 = l1.next;
		}
		while(l2!=null){
			while(root.next!=null){
				root = root.next;
			}
			ListNode currentNode = new ListNode(0);
			currentNode.val = l2.val;
			if(add!=0) {
				currentNode.val+=1;
				if(currentNode.val>=10) {
					currentNode.val -=10;
					add+=1;
				}
				add -=1;
			}
			root.next = currentNode;
			l2 = l2.next;
		}
		while(add!=0){
			while(root.next!=null){
				root = root.next;
			}
			ListNode currentNode = new ListNode(0);
			currentNode.val+=1;
			add-=1;
			root.next = currentNode;
		}
		return copyroot;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(1);
		l1.next = new ListNode(9);
//		l2.next = new ListNode(6);
//		l1.next.next = new ListNode(1);
//		l2.next.next = new ListNode(9);
		ListNode r = addTwoNumbers(l1,l2);
		while(r!=null){
			System.out.println(r.val);
			r = r.next;
		}
	}

}
