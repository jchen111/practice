package MS.OTS;

import java.util.*;

public class CourseSchedule {
    // [0,1] 1 -> 0
    /**
     time n courses, m pair of prerequisites, O(Math.max(n,m))
     space O(n + m)
     */
    static class Node {
        int val;
        Set<Integer> inCommingEdges;
        Set<Integer> outGoingEdges;
        public Node(int v) {
            this.val = v;
            inCommingEdges = new HashSet<>();
            outGoingEdges = new HashSet<>();
        }
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return new int[]{};
        Map<Integer, Node> graph = new HashMap<>();
        int[] solution = new int[numCourses];
        int index = 0;
        for(int[] pre : prerequisites) { // m
            Node out = graph.containsKey(pre[1]) ? graph.get(pre[1]) : new Node(pre[1]);
            Node in = graph.containsKey(pre[0]) ? graph.get(pre[0]) : new Node(pre[0]);
            out.outGoingEdges.add(pre[0]);
            in.inCommingEdges.add(pre[1]);
            graph.put(pre[0], in);
            graph.put(pre[1], out);
        }

        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) { // n
            Node node = graph.containsKey(i) ? graph.get(i) : new Node(i);
            if(node.inCommingEdges.isEmpty()) queue.add(node);
        }

        while(!queue.isEmpty()) { // m
            Node cur = queue.poll();
            solution[index++] = cur.val;
            Iterator<Integer> it = cur.outGoingEdges.iterator();
            while(it.hasNext()) {
                int neighbor = it.next();
                if(graph.containsKey(neighbor)){
                    Node nei = graph.get(neighbor);
                    nei.inCommingEdges.remove(cur.val);
                    graph.put(neighbor,nei);
                    if(nei.inCommingEdges.isEmpty()) queue.add(nei);
                }
                it.remove();
            }
            graph.put(cur.val, cur);
        }

        for(int i = 0; i < numCourses; i++) { // n
            Node node = graph.get(i);
            if(!node.inCommingEdges.isEmpty() || !node.outGoingEdges.isEmpty()) return new int[]{};
        }
        return solution;
    }

    public static List<Integer> getOrderingOfTargetCourse(int[][] courses, int n, int target) {
        List[] courseGraph = new ArrayList[n];

        for (int[] course : courses) {
            if (courseGraph[course[0]] == null ) {
                courseGraph[course[0]] = new ArrayList<Integer>();
            }
            courseGraph[course[0]].add(course[1]);
        }

        List<Integer> cur = new ArrayList<>();
        boolean[] vis = new boolean[n];
        cur.add(target);
        vis[target] = true;
        helper(courseGraph, n, target, vis, cur);
        return cur;
    }

    private static boolean helper(List[] courseGraph, int n, int curidx, boolean [] vis, List<Integer> cur) {
        List<Integer> curls = courseGraph[curidx];
        if (curls == null ) {
            return true;
        } else {
            for (int i = 0; i < curls.size(); i++) {
                if (!vis[curls.get(i)]) {
                    cur.add(0, curls.get(i));
                    vis[curls.get(i)] = true;
                    if( helper(courseGraph, n, curls.get(i), vis, cur) ) {
                        return true;
                    }
                    vis[curls.get(i)] = false;
                    cur.remove(0);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] pre = {
                {1,0},
                {2,0},
                {3,2},
                {3,1}
        };

        List<Integer> solution = getOrderingOfTargetCourse(pre,4, 3);
        for(Integer i : solution) {
            System.out.print(i + " ");
        }
    }
}
