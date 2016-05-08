package leetcode;
import java.util.Hashtable;

public class IntersectionNode {
//	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode copyheadA = headA;
//        ListNode copyheadB = headB;
//        Hashtable<ListNode,Boolean> listA = new Hashtable<ListNode,Boolean>();
//        while(copyheadA!=null){
//        	listA.put(copyheadA,true);
//        	copyheadA = copyheadA.next;
//        }
//        while(copyheadB!=null){
//        	if(listA.containsKey(copyheadB)){
//        		return copyheadB;
//        	}
//        	copyheadB = copyheadB.next;
//        }
//        return null;
//    }
	
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
		int lenA = length(headA);
		int lenB = length(headB);
		while(lenA>lenB){
			headA = headA.next;
			lenA--;
		}
		while(lenA<lenB){
			headB = headB.next;
			lenB--;
		}
		while(headA!=null && headB!=null){
			if(headA==headB){
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
	
	public static int length(ListNode head){
		int length=0;
		while(head!=null){
			head = head.next;
			length++;
		}
		return length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
