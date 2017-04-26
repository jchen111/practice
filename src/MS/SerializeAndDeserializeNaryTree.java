package MS;

import java.util.Stack;

/**
 * Created by z001ktb on 4/26/17.
 */
public class SerializeAndDeserializeNaryTree {

    //https://discuss.leetcode.com/topic/25/serialize-and-deserialize-an-n-ary-tree

    public static String serialize(NaryTreeNode root, StringBuilder sb) {
        if(root != null){
            sb.append('(');
            sb.append(root.val);
            for(NaryTreeNode child : root.children){
                sb.append(serialize(child, sb));
            }
            sb.append(')');
        }
        return sb.toString();
    }

    public static NaryTreeNode deserialize(String str) {
        NaryTreeNode root = null;
        NaryTreeNode parent = null;
        int pos = 0;
        Stack<NaryTreeNode> stack = new Stack<NaryTreeNode>();
        while(pos< str.length()){
            if(str.charAt(pos) == '('){
                pos++;
                NaryTreeNode node = new NaryTreeNode(Character.getNumericValue(str.charAt(pos)));
                if(parent == null){
                    root = parent;
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

}
