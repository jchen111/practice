//package AmazonOA.AmazonOA7;
//
//
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//
///**
// * Created by z001ktb on 5/17/17.
// */
//public class MovieNetwork {
//    //check if n < 0
//    public List<Integer> find(int id, int k, Moive moive) {
//        Queue<Moive> q = new LinkedList<Moive>();
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        List<Integer> res = new ArrayList<Integer>();
//        Set<Integer> visited = new HashSet<Integer>();
//
//        Iterator<In>
//
//        q.offer(moive);
//        Map<String,String> map =  new Map();
//
//        while (!q.isEmpty()) {
//            Moive cur = q.poll();
//
//            for (Moive neighbor : cur.neighbors) {
//                if (visited.add(neighbor.id)) {
//                    minHeap.offer(neighbor.id);
//
//                    if (minHeap.size() > k) {
//                            minHeap.poll();
//                    }
//
//                    q.offer(neighbor);
//                }
//            }
//        }
//
//        while (!minHeap.isEmpty()) {
//            res.add(minHeap.poll());
//        }
//
//        return res;
//    }
//
//    class Moive {
//        int id;
//        int rate;
//        List<Moive> neighbors;
//
//        public Moive(int id, int rate, List<Moive> neighbors) {
//            this.id = id;
//            this.rate = rate;
//            this.neighbors = neighbors;
//        }
//    }
//}
