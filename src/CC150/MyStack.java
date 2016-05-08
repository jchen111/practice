package CC150;

public class MyStack extends MyLinkedList{
	public int SizeOfStack(){
		return this.NumberOfNodes();
	}
	public void push(Node n){
		this.append(n);
	}
	public void deleteNode(Node n){
		if(!this.isEmpty()){
			this.deleteNode(n);
		}
	}
	public Node pop(){
		if(!this.isEmpty()){
			return this.pop();
		}
		return null;
	}
	public Node first(){
		if(!this.isEmpty()){
			return this.first();
		}
		return null;
	}
	public Node last(){
		if(!this.isEmpty()){
			return this.last();
		}
		return null;
	}
	public void displayStack(){
		this.displayList();
	}
}
