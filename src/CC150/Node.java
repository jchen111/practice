package CC150;

public class Node {
	public Node next = null;
	public int data;
	public Node(int d) {data = d;next = null;}
	public void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;
		if(n!=null){
			while(n.next != null){
				n = n.next;
			}
			n.next = end;
		}
	}
	
	public Node deleteNode(Node head, int d){
		if(head.data == d){
			return head.next;
		}else{
			Node end = head.next;
			while(end.data != d){
				end = end.next;
			}
			end.next = end.next.next;
			return head;
		}
	}
}
