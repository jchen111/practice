package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/9/16.
 */
public class KthLargestElement {
    static class MaxHeap {
        int capacity;
        int[] heap;
        int size;
        final int FRONT = 0;

        MaxHeap(int n){
            capacity = n;
            size = 0;
            heap = new int[n];
        }

        boolean isLeaf(int i){
            if(i >= size /2)
                return true;
            return false;
        }

        int leftChild(int i){
            return i*2 + 1;
        }

        int rightChild(int i){
            return i*2 + 2;
        }

        boolean isEmpty(){
            if(size > 0)
                return false;
            else
                return true;
        }

        int pop(){
            int res = heap[FRONT];
            if(size > 0) {
                heapfiy();
                size--;
            }
            else
                size--;
            return res;
        }

        int parent(int i){
            if(i%2 == 0)
                return i/2-1;
            else
                return i/2;
        }

        void add(int num){
            if(size <= capacity - 1) {
                int current = size;
                heap[size++] = num;
                while(current > 0 && heap[current] > heap[parent(current)]){
                    int tmp = heap[current];
                    heap[current] = heap[parent(current)];
                    heap[parent(current)] = tmp;
                    current = parent(current);
                }
            }
        }

        void heapfiy(){
            heap[FRONT] = heap[size -1];
            int i = FRONT;
            while(!isLeaf(i)){
                if((leftChild(i) <= size -1 && heap[leftChild(i)] > heap[i]) || (rightChild(i) <= size -1 && heap[rightChild(i)] > heap[i])){
                    if(heap[leftChild(i)] > heap[rightChild(i)]){
                        int tmp = heap[leftChild(i)];
                        heap[leftChild(i)] = heap[i];
                        heap[i] = tmp;
                        i =leftChild(i);
                    }else{
                        int tmp = heap[rightChild(i)];
                        heap[rightChild(i)] = heap[i];
                        heap[i] = tmp;
                        i = rightChild(i);
                    }
                }else{
                    break;
                }
            }
        }
    }

    //Upper bound O(nlogn + klogn)
    public static int findKthLargest(int[] nums, int k) {
        MaxHeap heap = new MaxHeap(nums.length);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            heap.add(nums[i]);
        }
        for(int i = 0; i < k; i++){
            res = heap.pop();
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        System.out.println(findKthLargest(array,K));
    }
}
