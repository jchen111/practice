package CC150;

public class MyQueue extends MyLinkedList{
	public int SizeOfQueue(){
		return this.NumberOfNodes();
	}
	
	public void enqueue(Node n){
		this.append(n);
	}
	public void deleteNode(Node n){
		if(!this.isEmpty()){
			this.deleteNode(n);
		}
	}
	public Node dequeue(){
		if(!this.isEmpty()){
			return this.dequeue();
		}
		return null;
	}
	public Node last(){
		if(!this.isEmpty()){
			return this.last();
		}
		return null;
	}
	public Node first(){
		if(!this.isEmpty()){
			return this.first();
		}
		return null;
	}
	
	public void displayQueue(){
		this.displayList();
	}
}
