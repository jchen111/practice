package leetcode;

public class RemoveNthNodeFroomEndofList {
	public  static ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode p1 = head, p2 = head, pre = null;
	        for(int i = 0; i < n; i++) {
	            p2 = p2.next;
	            if(p2 == null)
	                return head.next;
	        }

	        while(p2 != null){
	            p2 = p2.next;
	            pre = p1;
	            p1 = p1.next;
	        }

	        pre.next = p1.next;

	        return head;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2; //n2.next = n3; n3.next = n4; n4.next = n5;
		ListNode n0 = removeNthFromEnd(n1,1);
		while(n0!=null){
			System.out.println(n0.val);
			n0 = n0.next;
		}
		
	}

}
