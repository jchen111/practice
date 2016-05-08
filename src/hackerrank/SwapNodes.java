package hackerrank;

import java.util.LinkedList;
import java.util.Scanner;


public class SwapNodes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node[] nodes = new Node[N+1];
        Node root = new Node();
        root.data = 1;
        nodes[1] = root;
        for(int i=1; i<N+1; i++) {
            Node left_node = new Node();
            left_node.data = sc.nextInt();
            if(left_node.data!=-1)
                nodes[left_node.data] = left_node;

            Node right_node = new Node();
            right_node.data = sc.nextInt();
            if(right_node.data!=-1)
                nodes[right_node.data] = right_node;

            nodes[i].left = left_node;
            nodes[i].right = right_node;
        }

        LinkedList<LinkedList<Node>> levels = new LinkedList<LinkedList<Node>>();
        LinkedList<LinkedList<Node>> stored_levels = new LinkedList<LinkedList<Node>>();
        LinkedList<Node> current_level = new LinkedList<Node>();
        current_level.add(nodes[1]);
        levels.add(current_level);
        while(!levels.isEmpty()){
            LinkedList<Node> current = levels.poll();
            LinkedList<Node> new_layer = new LinkedList<Node>();
            LinkedList<Node> layer = new LinkedList<Node>();
            while(!current.isEmpty()){
                Node tmp = current.poll();
                layer.add(tmp);
                if(tmp.left != null){
                    new_layer.add(tmp.left);
                }
                if(tmp.right != null){
                    new_layer.add(tmp.right);
                }
            }
            if(!new_layer.isEmpty()){
                levels.add(new_layer);
            }
            stored_levels.add(layer);
        }

        int T = sc.nextInt();
        for(int i=0; i< T; i++){
            int depth = sc.nextInt();
            for(int layer_index = 0; layer_index< stored_levels.size(); layer_index++){
                if((layer_index+1)%depth == 0){
                    for(int node_index =0; node_index<stored_levels.get(layer_index).size(); node_index++) {
                        if ((stored_levels.get(layer_index).get(node_index).left != null && stored_levels.get(layer_index).get(node_index).right != null)
                                && (stored_levels.get(layer_index).get(node_index).left.data != -1 || stored_levels.get(layer_index).get(node_index).right.data != -1)) {
                            Node tmp = stored_levels.get(layer_index).get(node_index).left;
                            stored_levels.get(layer_index).get(node_index).left = stored_levels.get(layer_index).get(node_index).right;
                            stored_levels.get(layer_index).get(node_index).right = tmp;
                        }
                    }
                }
            }
            printInorderTraversal(nodes[1]);
            System.out.println();
        }
    }

    public static void printInorderTraversal(Node root){
        if(root == null){
            return;
        }
        if(root.left != null && root.right != null && root.left.data == -1 && root.right.data == -1){
            System.out.print(root.data + " ");
            return;
        }
        printInorderTraversal(root.left);
        if(root.data != -1)
            System.out.print(root.data + " ");
        printInorderTraversal(root.right);
    }
}
