package hackerrank;

/**
 * Created by z001ktb on 2/2/16.
 */
public class InsertNode {
    static Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if(head == null){
            head = new Node();
            head.data = data;
            head.next = null;
        }else{
            int index = 0;
            Node pointer = head;
            Node pre = null;
            while(pointer != null){
                if(index == position){
                    Node new_node = new Node();
                    new_node.data = data;
                    if(pre == null){
                        pre = new_node;
                        new_node.next = head;
                        return new_node;
                    }
                    pre.next = new_node;
                    new_node.next = pointer;
                }
                pre = pointer;
                pointer = pointer.next;
                index++;
            }
            if(index == position){
                Node new_node = new Node();
                new_node.data = data;
                new_node.next = null;
                pre.next = new_node;
            }
        }
        return head;
    }
    static Node RemoveDuplicates(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node dummy = new Node();
        dummy.next = head;
        Node pointer = head.next;
        Node pre = head;
        int n = head.data;
        while(pointer != null){
            if(pointer.data == n){
                while(pointer != null && pointer.data == n){
                    pointer = pointer.next;
                }
                pre.next = pointer;
            }

            if(pointer != null){
                pre = pointer;
                n = pre.data;
                pointer = pointer.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        n1.data = 1;
        n1.next = n2;
        n2.data = 1;
        n2.next = n3;
        n3.data = 1;
        n3.next = n4;
        n4.data = 1;
        n4.next = null;

        RemoveDuplicates(n1);
    }
}
