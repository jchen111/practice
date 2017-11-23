package AirBnB.phone;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by z001ktb
 */
public class Flatten2DVector {
    static class Vector2D implements Iterator<Integer> {

        Queue<Iterator> queue;
        Iterator<Integer> current;
        public Vector2D(List<List<Integer>> vec2d) {
            queue = new LinkedList<Iterator>();
            for(List<Integer> list : vec2d) {
                if(!list.isEmpty()) {
                    queue.add(list.iterator());
                }
            }
            if(!queue.isEmpty()) {
                current = queue.poll();
            }
        }

        private void findNextIterator() {
            if(!queue.isEmpty()) {
                current = queue.poll();
            } else {
                current = null;
            }
        }

        @Override
        public Integer next() {
            Integer res = current.next();
            if(!current.hasNext()) {
                findNextIterator();
            }
            return res;
        }

        @Override
        public boolean hasNext() {
            return current != null && current.hasNext();
        }
    }

}
