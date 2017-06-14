package MS;

import leetcode.ListNode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by z001ktb on 5/3/17.
 */
public class DeleteNNode {

    public static Stack<ListNode> stack = new Stack<ListNode>();

    public static ListNode deleteNNode(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        stack.push(dummy);
        while(head != null){
            ListNode next = head.next;
            if(head.val % n == 0){

            }else{
                ListNode pre = stack.pop();
                pre.next = head;
                head.next = null;
                stack.push(head);
            }
            head = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<ListNode> s = new Stack<ListNode>();
        int N = sc.nextInt();
        int k = sc.nextInt();
        ListNode dummy = new ListNode(-1);
        s.push(dummy);
        for(int i = 0; i < N; i++){
            int n = sc.nextInt();
            ListNode tmp = new ListNode(n);
            ListNode pre = s.pop();
            if(pre != null){
                pre.next = tmp;
            }
            s.push(tmp);
        }
        System.out.println(deleteNNode(dummy.next,k).val);
    }
}
