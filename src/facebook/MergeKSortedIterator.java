package facebook;

import java.util.*;

/**
 * Created by z001ktb on 6/11/17.
 */
public class MergeKSortedIterator {

    static class MyIterator {
        int next;
        Iterator<Integer> iter;
        MyIterator (Iterator<Integer> it) {
            this.next = it.next();
            this.iter = it;
        }
    }

    public static List<Integer> mergeKIterators(List<Iterator<Integer>> iterators) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<MyIterator> pq = new PriorityQueue<MyIterator>(new Comparator<MyIterator>() {
            @Override
            public int compare(MyIterator o1, MyIterator o2) {
                return o1.next - o2.next;
            }
        });

        for(Iterator<Integer> it : iterators) {
            pq.add(new MyIterator(it));
        }

        while(!pq.isEmpty()) {
            MyIterator cur = pq.poll();
            result.add(cur.next);
            if(cur.iter.hasNext()) pq.add(new MyIterator(cur.iter));
        }

        return result;
    }

    public static void main(String[] args) {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3, 4).iterator();
        Iterator<Integer> it2 = Arrays.asList(2, 2, 3, 4).iterator();
        List<Iterator<Integer>> list = new ArrayList<Iterator<Integer>>();
        list.add(it1); list.add(it2);

        List<Integer> result = mergeKIterators(list);

        System.out.println(result);
    }
}
