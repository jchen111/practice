package CC150;

public class Chapter3 {
	/* solution for 3.6 sort a stack in ascending order should remember*/
	public static MyStack sortStackAscending(MyStack s){
		MyStack r = new MyStack();
		while(s.SizeOfStack()!=0){
			Node temp = s.pop();
			while(r.SizeOfStack()!=0 && temp.data<r.last().data){
				s.push(r.pop());
			}
			r.push(temp);
		}
		return r;
	}
    /* solution for 3.4 Towers of Hanoi should remember*/
	public static void hanoiMove(int n, MyStack source, MyStack dest, MyStack buffer){
		if(n>0){
			hanoiMove(n-1,source,buffer,dest);
			dest.push(source.pop());
			hanoiMove(n-1, buffer, dest, source);
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node array[] = {n6,n5,n3,n4,n2,n1};
		
		MyStack s = new MyStack();
		/* solution for problem 3.5 implement a queue*/
		MyQueue q = new MyQueue();
		/* solution for problem 3.3 structure SetOfStack*/
//		SetOfStacks sos = new SetOfStacks();
//		sos.setThreshold(2);
		for(int i=0; i< array.length; i++){
			s.push(array[i]);
		}
//		sos.push(s);
//		System.out.println("original sos:");
//		sos.displaySOS();
//		System.out.println("after poping:");
//		sos.popAt(2);
//		sos.displaySOS();
		/* solution for 3.4 Towers of Hanoi */
//		Stack rod1 = new Stack();
//		Stack rod2 = new Stack();
//		Stack rod3 = new Stack();
//		rod1.push(n4);//you decide how many disks in the tower
//		rod1.push(n3);
//		rod1.push(n2);
//		rod1.push(n1);
//		System.out.println("before move:");
//		System.out.println("rod1:");
//		rod1.displayStack();
//		System.out.println("\nrod2:");
//		rod2.displayStack();
//		System.out.println("\nrod3:\n");
//		rod3.displayStack();
//		hanoiMove(4,rod1,rod3,rod2);//hanoiMove(source-rod, destination-rod, buffer-rod)
//		System.out.println("after move");
//		System.out.println("rod1:");
//		rod1.displayStack();
//		System.out.println("\nrod2:");
//		rod2.displayStack();
//		System.out.println("\nrod3:");
//		rod3.displayStack();
		s.displayStack();
		System.out.println("\nafter sorting:");
		sortStackAscending(s).displayStack();
	}

}
