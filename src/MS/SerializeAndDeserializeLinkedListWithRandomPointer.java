package MS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by z001ktb on 5/1/17.
 */
public class SerializeAndDeserializeLinkedListWithRandomPointer {

    public ListNodeWithRandPointer deserialize(String str) {
        Queue<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(str.split(",")));
        return dodeserialize(queue);
    }

    public ListNodeWithRandPointer dodeserialize(Queue<String> queue) {
        if(!queue.isEmpty()){
            String str = queue.poll();
            if(!str.equals("X")) {
                ListNodeWithRandPointer head = new ListNodeWithRandPointer(Integer.valueOf(str));
                head.next = dodeserialize(queue);
                head.rand = dodeserialize(queue);
                return head;
            }
            return null;
        }
        return null;
    }

    public String serialize(ListNodeWithRandPointer head) {
        StringBuilder sb = new StringBuilder();
        doserialize(head, sb);
        return sb.toString();
    }

    public void doserialize(ListNodeWithRandPointer head, StringBuilder sb) {
        if(head != null){
            sb.append(head.val);
            sb.append(',');
            doserialize(head.next, sb);
            doserialize(head.rand, sb);
        }else{
            sb.append('X');
            sb.append(',');
            return;
        }
    }

    public static void main(String[] args) {

    }
}
