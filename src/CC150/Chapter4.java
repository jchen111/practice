package CC150;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Chapter4 {
	/* BFS binary tree*/
	public static void BreadthFirstSearch(TreeNode root){
		if(root == null){
			return;
		}
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.get(0);
			System.out.print(node.val+" ");
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
			queue.remove(0);
		}
	}
	/* Insert a node to a binary search tree*/
	public static TreeNode insertNodeBinarySearchTree1(TreeNode root, TreeNode n){
        if(root == null){
            return n;
        }
        else if(n.val >= root.val){
            root.left = insertNodeBinarySearchTree1(root.left, n);
        }
        else if(n.val < root.val){
            root.right = insertNodeBinarySearchTree1(root.right, n);
        }
        return root;
    }
	public static void insertNodeBinarySearchTree(TreeNode left, TreeNode right,TreeNode root, TreeNode n){
		if(root == null){
			if(left!=null){
				left.left = n;
			}
			if(right!=null){
				right.right = n;
			}
			root = n;
		}
		else if(n.val >= root.val){
			insertNodeBinarySearchTree(root,null,root.left,n);
		}
		else if(n.val < root.val){
			insertNodeBinarySearchTree(null,root,root.right,n);
		}
	}
	/* Traverse tree post-order*/
	public static void postOrderTraverse(TreeNode root){
		if(root == null){
			return;
		}
		postOrderTraverse(root.left);
		postOrderTraverse(root.right);
		System.out.print(root.val+" ");
	}
	/* Traverse tree pre-order*/
	public static void preOrderTraverse(TreeNode root){
		if(root == null){
			return;
		}
		System.out.print(root.val+" ");
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}
	/* Traverse tree In-order */
	public static void inOrderTraverse(TreeNode root){
		if(root == null){
			return;
		}
		inOrderTraverse(root.left);
		System.out.print(root.val+" ");
		inOrderTraverse(root.right);
	}
	/* solution for 4.1 if a tree is balanced tree*/
	public static int maxDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	public static int minDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		return 1+Math.min(minDepth(root.left), minDepth(root.right));
	}
	public static boolean isBalancedTree(TreeNode root){
		if(Math.abs((maxDepth(root) - minDepth(root) ))< 1){
			return true;
		}
		return false;
	}
	/* solution for 4.3 create a binary tree with minimal height*/
	public static TreeNode createBinaryTree(TreeNode[] array){
		TreeNode root = array[0];
		int i=1;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty() && i<array.length){
			TreeNode temp = queue.removeFirst();
			while(temp.left == null || temp.right == null){
				if(temp.left == null && i<array.length){
					temp.left = array[i];
					i++;
				}
				if(temp.right == null && i<array.length){
					temp.right = array[i];
					i++;
				}
			}
			if(temp.left!=null)
				queue.add(temp.left);
		    if(temp.right!=null)
		    	queue.add(temp.right);
		}
		return root;
	}
	/* solution for 4.4 Given a binary tree, design an algorithm which creates a linked list
	 * of all the nodes at each depth*/
	public static ArrayList<LinkedList<TreeNode>> listOfNodesAtEachLevel(TreeNode root){
		int level = 0;
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		result.add(level, list);
		while(!list.isEmpty()){
			list = new LinkedList<TreeNode>();
			for(int i=0; i<result.get(level).size();i++){
				TreeNode temp = result.get(level).get(i);
				if(temp.left!=null) list.add(temp.left);
				if(temp.right!=null) list.add(temp.right);
			}
			if(list.size()>0) result.add(level+1, list);
			level++;
		}
		return result;
	}
	/* solution for 4.6 design an algorithm to find the first common ancestor
	 * of two nodes in a binary tree*/
	public static boolean isReachable(TreeNode root, TreeNode n){
		if(root == null) return false;
		if(root == n) return true;
		return (isReachable(root.left,n) || isReachable(root.right,n));
	}
	public static TreeNode firstCommonAncestor(TreeNode root,TreeNode n1, TreeNode n2){
		if(isReachable(root.left,n1) && isReachable(root.left,n2))
			return firstCommonAncestor(root.left,n1,n2);
		if(isReachable(root.right,n1) && isReachable(root.right,n2))
			return firstCommonAncestor(root.right,n1,n2);
		return root;
	}
	/* solution for 4.7 Create an algorithm to decide if T2 is a subtree of T1*/
	public static boolean subTree(TreeNode t1, TreeNode t2){
		if(t1 == null || t2 == null)
			return false;
		if(t1.val == t2.val)
			return matchTree(t1,t2);
		else
			return (subTree(t1.left,t2) || subTree(t1.right,t2));
	}
	public static boolean matchTree(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null)
			return true;
		if((t1.val != t2.val) || (t1==null || t2==null))
			return false;
		return (matchTree(t1.left,t2.left) && matchTree(t1.right,t2.right));
	}
	/* solution for 4.8 print all paths which sum up to a value
	 * Note that it can be any path in the tree*/
	public static void findSum(TreeNode root, int sum, ArrayList<Integer> buffer, int level){
		if(root == null) return;
		int temp = sum;
		buffer.add(root.val);
		for(int i=level; i>-1;i--){
			temp-=buffer.get(i);
			if(temp==0) print(buffer,i,level);
		}
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		findSum(root.left,sum,c1,level+1);
		findSum(root.right,sum,c2,level+1);
	}
	public static void print(ArrayList<Integer> buffer, int i2, int level){
		for(int i=i2; i<=level;i++){
			System.out.print(buffer.get(i)+" ");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// construct a binary tree
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		TreeNode t11 = new TreeNode(11);
		TreeNode t12 = new TreeNode(12);
		TreeNode[] array = {t1,t2,t3,t4,t5,t6,t7,t8,t9,t11,t12};
//		System.out.println(maxDepth(createBinaryTree(array)));
		t1.left = null;
		t1.right = null;
		t2.left = null;
		t2.right = null;
		t3.left = null;
		t3.right = null;
		t4.left = null;
		t4.right = t11;
		t5.left = t9;
		t5.right = t7;
		t7.left = t1;
		t7.right = t12;
		t8.left = t5;
		t8.right = t4;
		t9.left = null;
		t9.right = null;
		t11.left = t3;
		t11.right = null;
		t12.left = t2;
		t12.right = null;
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		findSum(t8,14,buffer,0);
//		System.out.println(subTree(t8,t5));
//		System.out.println(firstCommonAncestor(t8,t12,t1).data);
//		for(int i=0;i<listOfNodesAtEachLevel(t8).size();i++){
//			for(int j=0;j<listOfNodesAtEachLevel(t8).get(i).size();j++){
//				System.out.print(listOfNodesAtEachLevel(t8).get(i).get(j).data+" ");
//			}
//			System.out.println(" ");
//		}
//		inOrderTraverse(t8);
//		preOrderTraverse(t8);
//		insertNodeBinarySearchTree(null,null,t8,t6);
//		insertNodeBinarySearchTree1(t8,t6);
//		BreadthFirstSearch(t8);
//		postOrderTraverse(t8);
//		System.out.println(isBalancedTree(t8));
		
		//construct a directed graph
//		DirectedGraph g = new DirectedGraph(13);
//		g.addEdge(0, 1);g.addEdge(0, 5);g.addEdge(0, 6);g.addEdge(2, 0);g.addEdge(2, 3);
//		g.addEdge(3, 5);g.addEdge(5, 4);g.addEdge(6, 4);g.addEdge(6, 9);g.addEdge(7, 6);
//		g.addEdge(8, 7);g.addEdge(9, 10);g.addEdge(11, 12);g.addEdge(9, 12);g.addEdge(9, 11);
//		System.out.println(g.hasRouteBetween(12, 0));
		
	}

}
