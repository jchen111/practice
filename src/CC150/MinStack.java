package CC150;

public class MinStack extends MyLinkedList{
	private MyLinkedList stack = new MyLinkedList();
	private MyLinkedList minstack = new MyLinkedList();
	public void push(Node n){
		if(minstack.isEmpty()){
			minstack.append(n);
		}else{
			Node lastmin = minstack.last();
			if(n.data<=lastmin.data){
				minstack.append(n);
			}
		}
		stack.append(n);
	}
	public Node pop(){
		if(!stack.isEmpty()){
			if(stack.last().data == minstack.last().data){
				minstack.pop();
			}
			return stack.pop();
		}
		return null;
	}
	public Node min(){
		return minstack.last();
	}
}
