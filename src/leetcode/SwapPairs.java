package leetcode;

public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
    	if(head==null) return null;
    	else if(head.next==null) return head;
    	else{
    		ListNode dummy = new ListNode(0);
    		dummy.next = head;
    		ListNode pre = dummy;
    		ListNode pointer1 = head;
    		ListNode pointer2 = head.next;
    		while(pointer1!=null && pointer2!=null){
    			ListNode tmp = pointer2.next;
    			pointer2.next = pointer1;
    			pointer1.next = tmp;
    			pre.next = pointer2;
    			pre = pointer1;
    			tmp = pointer1;
    			pointer1 = pointer2;
    			pointer2 = tmp;
    			if(pointer1.next!=null && pointer2.next!=null){
    				pointer1 = pointer1.next.next;
    				pointer2 = pointer2.next.next;
    			}else
    				break;
    		}
    		return dummy.next;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2; n2.next = n3; n3.next = n4;
		ListNode res = swapPairs(n1);
	    while(res!=null){
	    	System.out.print(res.val);
	    	res = res.next;
	    }
	}

}
