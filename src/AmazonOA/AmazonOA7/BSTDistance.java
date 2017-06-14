//package AmazonOA.AmazonOA7;
//
///**
// * Created by z001ktb on 5/17/17.
// */
//public class BSTDistance {
//    private BTreeNode root;
//    public void CreateBST(int[] values,int n){
//        for(int i=0;i<n;i++){
//            add(values[i]);
//        }
//    }
//
//    public void add(int item){
//        if(root==null){
//            root=new BTreeNode(null,item,null);
//        }else{
//            add(root,item);
//        }
//    }
//
//    public void add(BTreeNode node,int item){
//        if (item < node.val) {
//            if (node.left == null) {
//                node.left = new BTreeNode(null, item, null);
//            } else {
//                add(node.left, item);
//            }
//        } else if (item > node.val) {
//            if (node.right == null) {
//                node.right = new BTreeNode(null, item, null);
//            } else {
//                add(node.right, item);
//            }
//        }
//    }
//
//
//    public  int bstDistance(int[] values, int n, int node1, int node2){
//        int l1=Pathlength(root,node1);
//        int l2=Pathlength(root,node2);
//        int lcaVal = findLCA(root, node1, node2).val;
//        int lcaDistance = Pathlength(root, lcaVal);
//        return (l1 + l2) - 2 * lcaDistance;
//
//    }
//
//    public int Pathlength(BTreeNode root, int n) {
//        return PathlengthHelp(root,n)-1;
//    }
//
//    public int PathlengthHelp(BTreeNode root, int n) {
//        if (root != null) {
//            int x = 0;
//            if ((root.val == n) || (x = PathlengthHelp(root.left, n)) > 0
//                    || (x = PathlengthHelp(root.right, n)) > 0) {
//                return x+1 ;
//            }
//            return 0;
//        }
//        return 0;
//    }
//
//    public BTreeNode findLCA(BTreeNode root, int node1, int node2) {
//        if (root != null) {
//            if (root.val == node1 || root.val == node2) {
//                return root;
//            }
//            BTreeNode left = findLCA(root.left, node1, node2);
//            BTreeNode right = findLCA(root.right, node1, node2);
//
//            if (left != null && right != null) {
//                return root;
//            }
//            if (left != null) {
//                return left;
//            }
//            if (right != null) {
//                return right;
//            }
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        BSTDistance test=new BSTDistance();
//        int values[]={5,6,3,1,2,4};
//        test.CreateBST(values,6);
//        BTreePrinter.printNode(test.root);
//        int res=test.bstDistance(values, 6, 2, 4);
//        System.out.println(res);
//    }
//}
