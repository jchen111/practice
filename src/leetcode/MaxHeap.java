package leetcode;

public class MaxHeap {
	private int[] Heap;
	private int size;
	private int maxsize;
	private static final int FRONT=1;
	
	public MaxHeap(int maxsize){
		this.size = 0;
		this.maxsize = maxsize;
		Heap = new int[this.maxsize+1];
		Heap[0] = Integer.MAX_VALUE;
	}
	
	private int parent(int i){
		return i/2;
	}
	
	private int leftChild(int i){
		return i*2;
	}
	
	private int rightChild(int i){
		return i*2+1;
	}
	
	private boolean isLeaf(int i){
		if(i>=size/2 && i<=size)
			return true;
		else
			return false;
	}
	
	private void swap(int i,int j){
		int tmp = Heap[i];
		Heap[i] = Heap[j];
		Heap[j] = tmp;
	}
	
	private void maxHeapify(int root){
		if(!isLeaf(root)){
			if(Heap[root]<Heap[leftChild(root)] || Heap[root]<Heap[rightChild(root)]){
				if(Heap[leftChild(root)] > Heap[rightChild(root)]){
					swap(root,leftChild(root));
					maxHeapify(leftChild(root));
				}else{
					swap(root,rightChild(root));
					maxHeapify(rightChild(root));
				}
			}
		}
	}
	/*When Heapify is called, the running time depends on how far an element might 
	 * move down in tree before the process terminates. In other words it depends on the height of node. 
	 * In the worst case the element might go down all the way to the leaf level.
	 * Let us count the work done level by level. At the bottommost level there are 2^(h) nodes, but we do not call Heapify on any of these so the work is 0. 
	 * At the next to level there are  2^(h − 1) nodes, and each might move down by 1 level. 
	 * At the 3rd level from the bottom there are 2^(h − 2) nodes, and each might move down by 2 levels.
	 * As you can see not all heapify operations are O(logn), this is why you are getting O(n).*/
	public void insert(int element){
		Heap[++size] = element;
		int current = size;
		while(Heap[current]>Heap[parent(current)]){
			swap(current,parent(current));
			current = parent(current);
		}
	}
	
	public void print()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i] 
                + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            System.out.println();
        } 
    }
	
	public int pop()//return the root of the heap which is the max element of the heap
	{
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		maxHeapify(FRONT);//after each pop operation, we need to re-adjust the heap
		return popped;
	}
	
	public void heapify()//public API to call heapify
	{
		maxHeapify(FRONT);
	}
}
