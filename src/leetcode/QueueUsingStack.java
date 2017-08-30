package leetcode;

import java.util.Stack;

/**
 * Created by jiaqichen on 8/29/17.
 */
public class QueueUsingStack {
    static class MyQueue {

        static Stack<Integer> stack1;
        static Stack<Integer> stack2;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int res = 0;
            boolean found = false;
            if(!stack2.isEmpty()) {
                res = stack2.pop();
                found = true;
            }
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if(!found) res = stack2.pop();
            return res;
        }

        /** Get the front element. */
        public int peek() {
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack2.isEmpty() && stack1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.pop();
        System.out.println(queue.peek());
    }
}
