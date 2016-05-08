package CC150;
import java.util.ArrayList;

public class SetOfStacks {
	private ArrayList<MyStack> setofstacks = new ArrayList<MyStack>();
	private int threshold;
	public void setThreshold(int n){
		threshold = n;
	}
	public int getThreshold(){
		return threshold;
	}
	public void push(MyStack s){
		if(s.SizeOfStack()>threshold){
			MyStack newstack = new MyStack();
			while(s.SizeOfStack()>threshold){
				newstack.push(s.pop());
			}
			setofstacks.add(s);
			this.push(newstack);
		}
		else{
			setofstacks.add(s);
		}
	}
	public Node popAt(int index) throws Exception{
		int length = setofstacks.size();
		Exception e = new NullPointerException();
		if(index>=length){
			throw e;
		}else{
			return setofstacks.get(index).pop();
		}
	}
	public Object Pop(){
		MyStack stack = new MyStack();
		int length = setofstacks.size();
		if(length!=1){
			stack = setofstacks.get(length-1);
			setofstacks.remove(length-1);
			return stack;
		}else{
			return setofstacks.get(length-1).pop();
		}
	}
	public void displaySOS(){
		for(int i=0; i< setofstacks.size();i++){
			setofstacks.get(i).displayStack();
			System.out.println("\n");
		}
	}
}
