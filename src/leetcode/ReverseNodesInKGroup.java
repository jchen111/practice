package leetcode;

import java.util.Scanner;

/**
 * Created by jacky on 9/15/16.
 */
public class ReverseNodesInKGroup {

    /**
     * Since the original linked list will be divided into n/k portions which need to be reversed
     * plus the left over portion which does not need to be reversed
     * So basically my idea is to find those portions and reverse them sequentially
     * then link with the left over portion and return the modified list at last
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){ //handle edge case
            return head;
        }

        int index = 1;
        ListNode pointer = head;
        ListNode groot = head;

        while(index <= k && pointer != null){ //find the first portion
            pointer = pointer.next;
            index++;
        }

        if(pointer == null && index <=k) // if k is bigger than list capacity, just return origin list
            return head;

        ListNode nextStart = pointer;
        ListNode toReturn = advancedReverseList(head,nextStart); //reverse first portion of the original list, the boundary of it will be nothing but the next portion's start node


        while(pointer != null){ //keep looping the list
            if(index % k == 0){ //reverse the following portion of the original list
                ListNode boundary = pointer.next;
                groot.next = advancedReverseList(nextStart,boundary);
                groot = nextStart; // update groot
                nextStart = boundary; //set the start node of the next portion
                pointer = nextStart;
            }else{
                pointer = pointer.next;
            }
            index++;
        }
        return toReturn;
    }

    /**
     * similar to ordinary reverse linked list method, but additionally check if node reaches the boundary node
     * and append boundary node to the end of the reversed linked list.
     */
    public static ListNode advancedReverseList(ListNode head, ListNode boundary) {
        if(boundary != null) {
            if (head == null || head.next == null || head.next == boundary) {
                return head;
            }
        }else{
            if(head == null || head.next == null ){
                return head;
            }
        }
        ListNode second = head.next;
        head.next = null;
        ListNode toReturn = advancedReverseList(second,boundary);
        second.next = head;
        head.next = boundary;
        return toReturn;
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode second = head.next;
        head.next = null;
        ListNode root = reverseList(second);
        second.next = head;
        return root;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        ListNode a = new ListNode(sc.nextInt());
        ListNode pre = a;
        for(int i = 1; i < N; i++){
            int val = sc.nextInt();
            pre.next = new ListNode(val);
            pre = pre.next;
        }


//        ListNode tail = new ListNode(-2);
//        pre.next = tail;
//        tail.next = new ListNode(-3);
//        a = reverseList(a);
//        a = advancedReverseList(a,tail);

        a = reverseKGroup(a,K);
        while(a != null){
            System.out.print(a.val+" ");
            a = a.next;
        }
    }
}
