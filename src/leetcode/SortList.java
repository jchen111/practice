package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/3/16.
 */
public class SortList {


    public static ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null ){
            return h2;
        }
        if(h2 == null){
            return h1;
        }

        if(h1.val <= h2.val){
            h1.next = merge(h1.next,h2);
            return h1;
        }else{
            h2.next = merge(h1,h2.next);
            return h2;
        }
    }

    public static ListNode sortList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        ListNode pre = head;

        while(pointer1 != null && pointer2.next != null){
            pre = pointer1;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }
        pre.next = null;
        ListNode l1 = sortList2(head);
        ListNode l2 = sortList2(pointer1);
        return merge(l1,l2);
    }


    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 0;
        ListNode pointer = head;
        while(pointer != null){
            pointer = pointer.next;
            len++;
        }
        int[] arr = new int[len];
        int i = 0;
        while(head != null){
            arr[i] = head.val;
            head = head.next;
            i++;
        }
        int res[] = mergeSortArray(arr);
        ListNode dummy = new ListNode(-1);
        head = new ListNode(res[0]);
        dummy.next = head;
        for(int k = 1; k < res.length; k++){
            ListNode nxt = new ListNode(res[k]);
            head.next = nxt;
            head = head.next;
        }
        return dummy.next;
    }


    public static int[] mergeSortArray(int[] arr){
        int len = arr.length;
        if(len == 1 || len == 0){
            return arr;
        }
        int[] left = Arrays.copyOfRange(arr,0,len/2);
        int[] right = Arrays.copyOfRange(arr,len/2, len);
        return sortArrays(mergeSortArray(left),mergeSortArray(right));
    }

    public static int[] sortArrays(int[] arr1, int[] arr2){
        int[] arr3 = new int[arr1.length+arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                arr3[k] = arr1[i];
                i++;
            }else{
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i < arr1.length){
            arr3[k] = arr1[i];
            i++;
            k++;
        }
        while(j < arr2.length){
            arr3[k] = arr2[j];
            j++;
            k++;
        }
        return arr3;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for(int i = 0; i < N; i++){
            arr1[i] = sc.nextInt();
        }

        int[] res = mergeSortArray(arr1);
        for(int i = 0; i < N; i++){
            System.out.print(res[i] + " ");
        }
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n5.next = n4; n4.next = n3; n3.next = n2; n2.next = n1;
        sortList(n5);
    }
}
