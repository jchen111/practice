package AirBnB.phone;

import java.util.*;

/**
 * Created by z001ktb
 */
public class PreferenceList {


    /**
     * 每个人都有一个preference的排序，在不违反每个人的preference的情况下得到总体的preference的排序
     *
     * For example:
     * a: 2, 3, 5
     * b: 4, 2, 1
     * c: 4, 1, 5, 6
     * d: 4, 7
     *
     * Return:
     * 4, 2, 7, 3, 1, 5, 6
     *
     * 拓扑排序解决
     * (follow up break tie with person1)
     */

    public static List<Integer> sortPreference(List<List<Integer>> preferences, int tieBreaker) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> degrees = new HashMap<>();
        for(int k = 0; k < preferences.size(); k++) {
            for(int i = 0; i < preferences.get(k).size(); i++) {
                for(int j = i + 1; j < preferences.get(k).size(); j++) {
                    int from = preferences.get(k).get(i);
                    int to = preferences.get(k).get(j);
                    if(!degrees.containsKey(from)) degrees.put(from, 0);
                    if(!degrees.containsKey(to)) degrees.put(to, 0);
                    Set<Integer> next = graph.containsKey(from) ? graph.get(from) : new HashSet<>();
                    if(next.add(to)) degrees.put(to, degrees.get(to) + 1);
                    graph.put(from, next);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
//        Set<Integer> tieBreakerList = new HashSet<>(graph.get(tieBreaker));
//        List<Integer> othersPref = new ArrayList<>();
//        List<Integer> tieBreakerPref = new ArrayList<>();

        for(Integer key : degrees.keySet()) {
            if(degrees.get(key) == 0) {
                queue.offer(key);
//                if(tieBreakerList.contains(key)) {
//                    tieBreakerPref.add(key);
//                } else {
//                    othersPref.add(key);
//                }
            }
        }
//        for(Integer key : tieBreakerPref) {
//            queue.offer(key);
//        }
//        for(Integer key : othersPref) {
//            queue.offer(key);
//        }

        while(!queue.isEmpty()) {
//          othersPref = new ArrayList<>();
//          tieBreakerPref = new ArrayList<>();
            int cur = queue.poll();
            res.add(cur);
            if(graph.containsKey(cur)) {// that node has
                for (Integer child : graph.get(cur)) {
                    int in = degrees.get(child);
                    in--;
                    degrees.put(child, in);
                    if (in == 0) {
                        queue.offer(child);
//                        if(tieBreakerList.contains(child)) {
//                            tieBreakerPref.add(child);
//                        } else {
//                            othersPref.add(child);
//                        }
                    }
                }
//              for(Integer key : tieBreakerPref) {
//                  queue.offer(key);
//              }
//              for(Integer key : othersPref) {
//                  queue.offer(key);
//              }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> preferences = new ArrayList<>();
        List<Integer> p1 = new ArrayList<>();
        p1.add(2);
        p1.add(3);
        p1.add(5);
        List<Integer> p2 = new ArrayList<>();
        p2.add(4);
        p2.add(2);
        p2.add(1);
        List<Integer> p3 = new ArrayList<>();
        p3.add(4);
        p3.add(1);
        p3.add(5);
        p3.add(6);
        List<Integer> p4 = new ArrayList<>();
        p4.add(4);
        p4.add(7);
        preferences.add(p1);
        preferences.add(p2);
        preferences.add(p3);
        preferences.add(p4);
        System.out.println(sortPreference(preferences, 0));
    }
}
