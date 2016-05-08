package hackerrank;

/**
 * Created by z001ktb on 5/1/16.
 */
public class BinaryHeap {


    static class MaxHeap {
        int size;
        int[] heap;
        static final int FRONT = 1;
        private int index =0;

        MaxHeap(int size) {
            this.size = size;
            this.heap = new int[++size];
            heap[0] = Integer.MAX_VALUE;
        }

        boolean isLeaf(int pointer) {
            if(pointer <= index && pointer > index/2){
                return true;
            }
            return false;
        }

        int parent(int index) {
            return index/2;
        }

        int leftChild(int index) {
            return index*2;
        }

        int rightChild(int index) {
            return index*2 + 1;
        }

        void swap(int index1, int index2) {
            int tmp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = tmp;
        }

        void maxHeapify(int current) {
            if(!isLeaf(current)) {
                if(heap[current] < heap[leftChild(current)] || heap[current] < heap[rightChild(current)]) {
                    if(heap[leftChild(current)] < heap[rightChild(current)]) {
                        swap(rightChild(current),current);
                        maxHeapify(rightChild(current));
                    }else {
                        swap(leftChild(current),current);
                        maxHeapify(leftChild(current));
                    }
                }
            }
        }

        int pop() {
            int pop = heap[FRONT];
            heap[FRONT] = heap[index--];
            maxHeapify(FRONT);
            return pop;
        }

        void insert(int val) {
            heap[++index] = val;
            int current = index;
            while(heap[current] > heap[parent(current)]) {

                swap(current,parent(current));
                current = parent(current);
            }
        }

        void print() {
            for(int i=FRONT; i<= index; i++) {
                if(!isLeaf(i)) {
                    System.out.println("ROOT: " + heap[i] + " LEFT CHILD: " + heap[i * 2] + " RIGHT CHILD: " + heap[i * 2 + 1]);
                }
            }
        }
    }


    static class MinHeap {
        int size;
        int[] heap;
        static int FRONT = 1;
        private int index =0;

        MinHeap(int size) {
            this.size = size;
            this.heap = new int[++size];
//            this.heap[0] = Integer.MIN_VALUE;
        }

        boolean isLeaf(int pointer) {
            if(pointer <= index && pointer > index/2){
                return true;
            }
            return false;
        }

        int parent(int index) {
            return index/2;
        }

        int leftChild(int index) {
            return index*2;
        }

        int rightChild(int index) {
            return index*2 + 1;
        }

        void swap(int index1, int index2) {
            int tmp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = tmp;
        }

        void minHeapify(int current) {
            if(!isLeaf(current)) {
                if(heap[current] > heap[leftChild(current)] || heap[current] > heap[rightChild(current)]) {
                    if(heap[leftChild(current)] < heap[rightChild(current)]) {
                        swap(leftChild(current),current);
                        minHeapify(leftChild(current));
                    }else {
                        swap(rightChild(current),current);
                        minHeapify(rightChild(current));
                    }
                }
            }
        }

        int pop() {
            int pop = heap[FRONT];
            heap[FRONT] = heap[index--];
            minHeapify(FRONT);
            return pop;
        }

        void insert(int val) {
            heap[++index] = val;
            int current = index;
            while(heap[current] < heap[parent(current)]) {
                swap(current,parent(current));
                current = parent(current);
            }
        }

        void print() {
            for(int i=FRONT; i<= index; i++) {
                if(!isLeaf(i)) {
                    System.out.println("ROOT: " + heap[i] + " LEFT CHILD: " + heap[i * 2] + " RIGHT CHILD: " + heap[i * 2 + 1]);
                }
            }
        }
    }

    public static void main(String...arg)
    {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        minHeap.print();
        System.out.println("The Max val is " + maxHeap.pop());
        System.out.println("The Min val is " + minHeap.pop());
    }
}
