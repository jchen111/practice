package MS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by z001ktb on 4/26/17.
 */
public class SerializeAndDeserializeNaryTree {

    //https://discuss.leetcode.com/topic/25/serialize-and-deserialize-an-n-ary-tree

    private static String serialize(NaryTreeNode root) {
        if (root != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(root.val);
            if (root.children != null) {
                for (int i = 0; i < root.children.size(); i++) {
                    sb.append(serialize(root.children.get(i)));
                }
            }
            sb.append(")");
            return sb.toString();
        }
        return "";
    }

    public static NaryTreeNode deserialize(String str) {
        NaryTreeNode root = null;
        NaryTreeNode parent = null;
        int pos = 0;
        Stack<NaryTreeNode> stack = new Stack<NaryTreeNode>();
        while(pos < str.length()){
            if(str.charAt(pos) == '('){
                pos++;
                NaryTreeNode node = new NaryTreeNode(Character.getNumericValue(str.charAt(pos)));
                if(parent == null){
                    root = node;
                }else{
                    parent.children.add(node);
                }
                stack.push(node);
                parent = node;
            }else if(str.charAt(pos) == ')'){
                stack.pop();
                if(!stack.isEmpty()){
                    parent = stack.peek();
                }
            }
            pos++;
        }
        return root;
    }

    private static void printNode(NaryTreeNode nd) {
        Queue<NaryTreeNode> queue = new LinkedList<NaryTreeNode>();
        if (nd != null) {
            queue.add(nd);
            while(!queue.isEmpty()) {
                int n = queue.size();
                for(int i = 0; i < n; i++) {
                    NaryTreeNode cur = queue.poll();
                    System.out.print(cur.val + " ");
                    if(!cur.children.isEmpty()) queue.addAll(cur.children);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        NaryTreeNode n1 = new NaryTreeNode(1);
        NaryTreeNode n2 = new NaryTreeNode(2);
        NaryTreeNode n3 = new NaryTreeNode(3);
        NaryTreeNode n4 = new NaryTreeNode(4);
        NaryTreeNode n5 = new NaryTreeNode(5);
        NaryTreeNode n6 = new NaryTreeNode(6);
        NaryTreeNode n7 = new NaryTreeNode(7);

        NaryTreeNode n8 = new NaryTreeNode(8);
        NaryTreeNode n9 = new NaryTreeNode(9);
        NaryTreeNode n10 = new NaryTreeNode(1);
        NaryTreeNode n11 = new NaryTreeNode(4);
        NaryTreeNode n12 = new NaryTreeNode(2);
        NaryTreeNode n13 = new NaryTreeNode(3);
        n2.children.add(n5);
        n2.children.add(n6);
        n2.children.add(n7);
        n3.children.add(n8);
        n3.children.add(n9);
        n3.children.add(n10);
        n3.children.add(n11);
        n4.children.add(n12);
        n4.children.add(n13);
        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);

        NaryTreeNode nd = deserialize(serialize(n1));

        printNode(nd);

    }

}
