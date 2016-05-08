package CC150;

public class MyLinkedList {
	private Node first = null;
	private Node last = null;
	public int NumberOfNodes(){
		Node current = first;
		int count = 0;
		while(current!=null){
			current = current.next;
			count++;
		}
		return count;
	}
	public void deleteNode(Node n){
		Node previous = null;
		Node current = first;
		if(n==first){
			first = first.next;
		}else{
			while(current!=n){
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
		}
	}
	
	public void append(Node tail){
		Node current = first;
		if(first == null){
			first = tail;
			last = tail;
		}else{
			while(current.next!=null){
				current = current.next;
			}
			current.next = tail;
			last = tail;
			last.next = null;
		}
	}
	public Node last(){
		return last;
	}
	public Node first(){
		return first;
	}
	public void displayList(){
		Node current = first;
		while(current!=null){
			System.out.print(current.data+" ");
			current = current.next;
		}
	}
	public Node pop(){
		Node current = first;
		Node Last = last;
		if(current==last){
			first = null;
			return last;
		}
		while(current.next!=last){
			current = current.next;
		}
		current.next = null;
		last = current;
		return Last;
	}
	
	public Node dequeue(){
		Node current = first;
		Node Last = last;
		if(current==last){
			first = null;
			return last;
		}else{
			first = first.next;
		}
		return current;
	}
	public boolean isEmpty(){
		return (first==null);
	}
}
