package hackerrank;

/**
 * Created by z001ktb on 2/2/16.
 */
public class Reverse {

    public static Node Reverse1(Node head){
        if(head != null) {
            Node nxt = head.next;
            Node pointer = head;
            Node pre = head;
            while(pointer.next != null){
                pre = pointer;
                pointer = pointer.next;
            }
            if(pointer == head){
                return head;
            }
            pre.next = null;
            pointer.next = Reverse1(nxt);
            head.next = null;
            return pointer;
        }
        return head;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        n1.data = 1;
        n1.next = n2;
        n2.data = 2;
        n2.next = n3;
        n3.data = 3;
        n3.next = n4;
        n4.data = 4;
        n4.next = null;

        Node n = Reverse1(n1);
        System.out.println(n.data + "--------------");
        while(n!=null) {
            System.out.println(n.data);
            n = n.next;
        }
    }
}
