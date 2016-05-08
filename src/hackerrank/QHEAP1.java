package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/3/16.
 */
public class QHEAP1 {

    static class MinHeap {
        int maxSize;
        int size;
        int[] heap;
        static final int FRONT = 1;

        MinHeap(int maxSize) {
            this.maxSize = maxSize;
            heap = new int[++maxSize];
            for(int i=1; i< heap.length; i++) {
                heap[i] = Integer.MAX_VALUE;
            }
            size = 0;
        }

        boolean isLeaf(int current) {
            if(current <= size && current > size/2) {
                return true;
            }
            return false;
        }

        void swap(int a, int b) {
            int tmp = heap[a];
            heap[a] = heap[b];
            heap[b] = tmp;
        }

        int parent(int current) {
            return current/2;
        }

        int leftChild(int current) {
            return current*2;
        }

        int rightChild(int current) {
            return current*2 + 1;
        }

        void minHeapify(int current) {
            if(!isLeaf(current)){
                if(heap[current] > heap[leftChild(current)] || heap[current] > heap[rightChild(current)]) {
                    if(heap[leftChild(current)] < heap[rightChild(current)]) {
                        swap(current,leftChild(current));
                        minHeapify(leftChild(current));
                    }else {
                        swap(current,rightChild(current));
                        minHeapify(rightChild(current));
                    }
                }
            }
        }

        void insert(int val) {
            heap[++size] = val;
            int current = size;
            while(current > 1 && heap[current] < heap[parent(current)]) {
                swap(current,parent(current));
                current = parent(current);
            }
        }

        int peek() {
            return heap[FRONT];
        }

        boolean isEmpty() {
            if(heap[FRONT] == Integer.MAX_VALUE)
                return true;
            else
                return false;
        }

        void delete(int val, int root) {
            if(root > size) {
                return;
            }
            if(isLeaf(root)){
                if(val == heap[root]) {
                    if(root == size) {
                        heap[size--] = Integer.MAX_VALUE;
                    }else {
                        while(root <= size) {
                            heap[root] = heap[root+1];
                            root++;
                        }
                        heap[size--] = Integer.MAX_VALUE;
                    }
                }else {
                    return;
                }
            }else {
                if(val == heap[root]){
                    if(heap[leftChild(root)] < heap[rightChild(root)]){
                        heap[root] = heap[leftChild(root)];
                        delete(heap[leftChild(root)],leftChild(root));
                    }else {
                        heap[root] = heap[rightChild(root)];
                        delete(heap[rightChild(root)],rightChild(root));
                    }
                }else {
                    delete(val,leftChild(root));
                    delete(val,rightChild(root));
                }
            }
        }

    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        MinHeap minHeap = new MinHeap(Q);
        for(int i=0; i<Q; i++) {
            int op = sc.nextInt();
            int v;
            switch(op) {
                case 1:
                    v = sc.nextInt();
                    minHeap.insert(v);
                    break;
                case 2:
                    v = sc.nextInt();
                    minHeap.delete(v,1);
                    break;
                case 3:
                    if(!minHeap.isEmpty())
                        System.out.println(minHeap.peek());
                    break;
                default:
                    break;
            }
        }
    }
}
