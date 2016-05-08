package hackerrank;

/**
 * Created by z001ktb on 4/29/16.
 */
public class BST {
    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val,Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val,null,null);
            return root;
        }else {
            if(val > root.val) {
                if(root.right == null){
                    root.right = new Node(val,null,null);
                }else {
                    insert(root.right, val);
                }
            }else {
                if(root.left == null){
                    root.left = new Node(val,null,null);
                }else {
                    insert(root.left, val);
                }
            }
        }
        return root;
    }

    public static void main(String[] args){
        Node nodeM4 = new Node(-4,null,null);
        Node node3 = new Node(3,null,null);
        Node node2 = new Node(2,nodeM4,node3);
        Node node18 = new Node(18,null,null);
        Node node5 = new Node(5,node2,node18);

        Node root = insert(node5,4);

        System.out.print(root.val);
    }
}
