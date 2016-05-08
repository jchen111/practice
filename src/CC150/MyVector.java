package CC150;
import java.util.LinkedList;

public class MyVector<T> {
	private int size;
	private int capacity;
	private static final int INCREMENT_FACTOR = 5; 
	private LinkedList<T> vector;
	
	public MyVector(int s){
		this.size = s;
		this.capacity = size+INCREMENT_FACTOR;
		this.vector = new LinkedList<T>();
	}
	
	public int getSize(){
		return size;
	}
	
	public void addElement(T e){
		if(vector.size()<this.size){
			this.vector.add(e);
		}else{
			this.vector.add(e);
			this.size+=1;
			if(this.size == this.capacity){
				this.capacity+=INCREMENT_FACTOR;
			}
		}
	}
	public T getElement(int index){
		if(!this.vector.isEmpty()){
			if(index>=0 && index < this.size){
				return this.vector.get(index);
			}else{
				throw new IndexOutOfBoundsException();
			}
		}
		return null;
	}
	public T removeElementAtIndex(int index){
		if(index>=0 && index < this.size){
			return this.vector.remove(index);
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	public T removeLast(){
		if(!this.vector.isEmpty()){
			return this.vector.removeLast();
		}
		return null;
	}
	public T removeFirst(){
		if(!this.vector.isEmpty()){
			return this.vector.removeFirst();
		}
		return null;
	}
	public void insertElementAtIndex(int index, T t){
		if(index>=0 && index < this.size){
			this.vector.add(index, t);
		}else if(index >=0 && (index>=this.size && index<=this.capacity)){
			this.vector.add(index, t);
			this.size+=1;
			if(this.size == this.capacity){
				this.capacity+=INCREMENT_FACTOR;
			}
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
}
