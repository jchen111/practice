package AirBnB.phone;

import java.util.*;

/**
 * Created by z001ktb
 */
public class TraverseGraphWithMinimumStops {

    /**
     * n: # of nodes
     * m: # of edges
     * time O(n * (m + n))
     * space O(n)
     * **/

    public static List<Integer> getMin(int[][] edges, int n) {
        Set<Integer> res = new HashSet<>();

        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) { //n
            nodes.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {//m
            nodes.get(edge[0]).add(edge[1]);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }

            res.add(i);
            visited.add(i);
            Set<Integer> thisTimeVisited = new HashSet<>();
            dfs(res, nodes, i, i, visited, thisTimeVisited); //m + n
        }

        return new ArrayList<>(res);
    }

    private static void dfs(Set<Integer> res, Map<Integer, Set<Integer>> nodes, int cur, int start,
                     Set<Integer> visited, Set<Integer> thisTimeVisited) {
        for (int next : nodes.get(cur)) {
            if (res.contains(next) && next != start) {
                res.remove(next);
            }
            if (!thisTimeVisited.contains(next)) {
                thisTimeVisited.add(next);
                visited.add(next);
                dfs(res, nodes, next, start, visited, thisTimeVisited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = {{0,1},{1,2},{2,0},{1,3}};
        List<Integer> res = getMin(input, 4);
        for(Integer integer : res) {
            System.out.print(integer + " ");
        }
    }
}
