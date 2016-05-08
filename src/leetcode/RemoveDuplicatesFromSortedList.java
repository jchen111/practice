package leetcode;

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head == null) return null;
    	if(head.next ==null) return head;
        ListNode pre = head;
        ListNode runner = head.next;
        int current = head.val;
        while(runner!=null){
        	if(runner.val == current){
        		while(runner!=null && runner.val==current){
        			runner = runner.next;
        		}
        		if(runner!=null){
        		current = runner.val;
        		pre.next = runner;
        		pre = runner;
        		runner = runner.next;
        		}
        		else{
        			pre.next = null;
        		}
        	}else{
        		current = runner.val;
        		pre = runner;
        		runner = runner.next;
        	}
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(5);
		n1.next = n2; n2.next =n3; n3.next = n4; n4.next = n5;n5.next = n6;
		ListNode res = deleteDuplicates(n1);
		while(n1!=null){
			System.out.print(n1.val);
			n1 = n1.next;
		}
		
	}

}
