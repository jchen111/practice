package MS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z001ktb on 4/26/17.
 */
public class NaryTreeNode {
    int val;
    List<NaryTreeNode> children;

    public NaryTreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<NaryTreeNode>();
    }

    public NaryTreeNode(int val, List<NaryTreeNode> children) {
        this.val = val;
        this.children = children;
    }

}
