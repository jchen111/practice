package leetcode;

import java.util.List;
import java.util.Scanner;

/**
 * Created by z001ktb on 10/22/16.
 */
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode largeTail = large;
        small.next = head;
        ListNode scanner = small.next;
        ListNode scannerPre = small;
        while(scanner != null){
            if(scanner.val >= x){
                scannerPre.next = scanner.next;
                largeTail.next = scanner;
                scanner = scanner.next;
                largeTail = largeTail.next;
                largeTail.next = null;
            }else {
                scannerPre = scanner;
                scanner = scanner.next;
            }
        }
        if(scannerPre != null) scannerPre.next = large.next;
        else return large.next;
        return small.next;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = sc.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for(int i = 0; i < N; i++){
            int val = sc.nextInt();
            ListNode tmp = new ListNode(val);
            dummy.next = tmp;
            dummy = dummy.next;
        }
        System.out.println(partition(head.next,x));
    }
}
