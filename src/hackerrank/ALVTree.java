package hackerrank;

/**
 * Created by z001ktb on 2/10/16.
 */
public class ALVTree {
    static class Node{
        int val;
        Node left;
        Node right;
        int ht;
    }

    static int height(Node root){
        return root == null ? -1:root.ht;
    }

    static Node insert(Node root, int val){
        if(root == null) {
            root = new Node();
            root.val = val;
            return root;
        }
        if(val > root.val) {
            root.right = insert(root.right,val);
        }else {
            root.left = insert(root.left,val);
        }

        root.ht = Math.max(height(root.left),height(root.right)) + 1;

        int balance = getBalance(root);

        if(balance > 1) {
            if(val < root.left.val){
                root = rotateWithLeftChild(root);
            }else {
                root = doubleRotateWithLeftChild(root);
            }
        }
        if(balance < -1) {
            if(val > root.right.val) {
                root = rotateWithRightChild(root);
            }else {
                root = doubleRotateWithRightChild(root);
            }
        }
        return root;
    }

    static Node rotateWithRightChild(Node root) {
        Node right_child = root.right;
        root.right = right_child.left;
        right_child.left = root;

        updateHeight(root);
        updateHeight(right_child);
        return right_child;
    }

    static Node doubleRotateWithRightChild(Node root) {
        root.right = rotateWithLeftChild(root.right);
        return rotateWithRightChild(root);
    }

    static Node rotateWithLeftChild(Node root) {
        Node left_child = root.left;
        root.left = left_child.right;
        left_child.right = root;

        updateHeight(root);
        updateHeight(left_child);
        return left_child;
    }

    static Node doubleRotateWithLeftChild(Node root) {
        root.left = rotateWithRightChild(root.left);
        return rotateWithLeftChild(root);
    }

    static int getMinValue(Node root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }else if(root.left == null) {
            return root.val;
        }else {
            return getMinValue(root.left);
        }
    }

    static int getBalance(Node root) {
        if(root == null) {
            return 0;
        }
        int balance;
        balance = height(root.left) - height(root.right);
        return balance;
    }

    static void updateHeight(Node node)
    {
        if (node == null) return;

        node.ht = Math.max(height(node.left), height(node.right)) + 1;
    }

    static Node delete(Node root, int val) {
        if(root == null) {
            return root;
        }
        if(val > root.val) {
            root.right = delete(root.right,val);
        }else if(val < root.val) {
            root.left = delete(root.left,val);
        }else {
            if(root.left == null || root.right == null) {
                Node tmp = null;
                if(root.left == null) {
                    tmp = root.right;
                }else {
                    tmp = root.left;
                }

                if(tmp == null) {
                    root = null;
                }else {
                    root = tmp;
                }
            }else {
                int successor = getMinValue(root.right);
                root.val = successor;
                root.right = delete(root.right,successor);
            }
        }

        if(root == null) {
            return root;
        }

        root.ht = Math.max(height(root.left),height(root.right)) + 1;

        int balance = getBalance(root);

        if(balance > 1) {
            if(getBalance(root.left) >= 0) {
                root = rotateWithLeftChild(root);
            }else {
                root = doubleRotateWithLeftChild(root);
            }
        }
        if(balance < -1) {
            if(getBalance(root.right) <= 0) {
                root = rotateWithRightChild(root);
            }else {
                root = doubleRotateWithRightChild(root);
            }
        }
        return root;
    }

    public static void main(String[] args){
        Node node10 = new Node();
        node10.val = 10;
        node10.ht = 0;
        Node node5 = new Node();
        node5.val = 5;
        node5.ht = 1;
        Node node8 = new Node();
        node8.val = 8;
        node8.ht = 2;
        Node node12 = new Node();
        node12.val = 12;
        node12.ht = 1;
        node10.left = node5;
        node10.right = node12;
        node5.right = node8;

        Node tmp = delete(node10,12);
        System.out.println(tmp);
    }
}
