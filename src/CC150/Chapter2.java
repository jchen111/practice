package CC150;
import java.util.Hashtable;
import java.util.LinkedList;


public class Chapter2 {
	public static void printList(Node n){
		while(n.next!=null){
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}
    /* solution for 2.1 remove duplicates from an unsorted linked list without extra space*/
	public static void removeDuplicates(Node n){
		Node previous = n;
		Node current = n.next;
		while(current!=null){
			Node runner = n;
			while(runner!=current){
				if(runner.data == current.data){
					Node temp = current.next;
					previous.next = temp;
					current = temp;
					break;
				}
				runner = runner.next;
			}
			if(runner == current){
				previous = current;
				current = current.next;
			}
		}
		printList(n);
	}
	//with extra space
	public static void removeDuplicates2(Node head){
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node n = head;
		Node previous = null;
		while(n!=null){
			if(table.containsKey(n.data)){
				previous.next = n.next;
			}else{
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
		printList(head);
	}
	/* solution for 2.2 find the nth to last element of a single linked list*/
	public static void subList(Node head, int n){
		Node copyhead = head;
		Node previous = head;
		int count =0;
		while(copyhead!=null){
			if(count==n-1){
				 previous = copyhead;
				 break;
			}
			copyhead = copyhead.next;
			count++;
		}
		printList(previous);
	}
	/* solution for 2.3 implement an algorithm to delete a node in the middle 
	 * of a single linked list, 
	 * given only access to that node*/
	public static void deleteAMiddleNode(Node n)// can not delete last node
	{
		if(n!=null){
			Node next;
			next = n.next;
			n.data = next.data;
			n.next = next.next;
		}
	}
	public static Node deleteAnyNode(Node head,Node n) // can delete any node
	{
		Node previous = null;
		if(head.data == n.data){
			return head.next;
		}
		else{
			Node copyhead = head;
			while(copyhead.data!=n.data){
				previous = copyhead;
				copyhead = copyhead.next;
			}
			previous.next = copyhead.next;
			return head;
		}
	}
	/* solution for 2.4 linked list sum*/
	public static Node sumList(Node head1, Node head2){
		Node result = new Node(0);
		boolean flag=false;
		while(head1!=null && head2!= null){
			if(head1.data + head2.data>=10){
				result.appendToTail((head1.data + head2.data)-10);
				head1.next.data++;
				flag=true;
			}else{
				flag = false;
				result.appendToTail(head1.data + head2.data);
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		if(flag)
			result.appendToTail(1);
		return deleteAnyNode(result,result);
	}
	/* solution for 2.5 given a circular linked list, implement an algorithm which returns
	 * node at the beginning of the loop*/
	public static Node findCircularNode(Node head){
		Node copyhead = head;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		while(!table.containsKey(copyhead.data)){
			table.put(copyhead.data, true);
			copyhead = copyhead.next;
		}
		return copyhead;
	}
	/* reverse a linked list*/
	public static Node reverse(Node head){
		if(head.next == null){
			return head;
		}
		Node second = head.next;
		Node previous;
		head.next = null;
		previous = reverse(second);
		second.next = head;
		return previous;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = null;
		
//		System.out.println("original list:");
//		MyLinkedList l1 = new MyLinkedList();
//		l1.append(n2);
//		l1.append(n3);
//		l1.append(n6);
//		l1.displayList();
//		l1.displayList();
//		System.out.println("after removal duplicates");
//		removeDuplicates2(n);
//		System.out.println("get a sub list:");
//		subList(n1,5);
//		System.out.println("after reverse:");
//		printList(reverse(n1));
//		System.out.println("deleting a middle node:");
//		deleteAMiddleNode(n5);
//		printList(deleteAnyNode(n1,n5));
//		System.out.println("sum of the two list:");
//		printList(sumList(n1,n4));
//		System.out.println("The circle starts from:");
//		System.out.println(findCircularNode(n1).data);
		
	}

}
