package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiaqichen on 9/30/16.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return head;
        }

        RandomListNode pointer = head;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        while(pointer != null){
            map.put(pointer, new RandomListNode(pointer.label));
            pointer = pointer.next;
        }

        for(Map.Entry<RandomListNode,RandomListNode> entry : map.entrySet()){
            RandomListNode newNode = entry.getValue();
            newNode.next = map.get(entry.getKey().next);
            newNode.random = map.get(entry.getKey().random);
        }
        return map.get(head);
    }
}
