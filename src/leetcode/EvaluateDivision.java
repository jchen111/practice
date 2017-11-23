package leetcode;

import java.util.*;

/**
 * Created by jiaqichen on 11/2/16.
 */
public class EvaluateDivision {
    static class Node {
        Map<String, Double> nextHops;
        double costSoFar;
        Node() {
            costSoFar = 1.0;
            nextHops = new HashMap<String, Double>();
        }
    }
    static Map<String, Node> nodeMap;
    static double cost = 1.0;
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if(queries == null || queries.length == 0) return null;
        int n = queries.length;
        nodeMap = new HashMap<String, Node>();
        double[] results = new double[n];
        for(int i = 0; i < equations.length; i++) {
            Node dividend = nodeMap.containsKey(equations[i][0]) ? nodeMap.get(equations[i][0]) : new Node();
            Node divisor = nodeMap.containsKey(equations[i][1]) ? nodeMap.get(equations[i][1]) : new Node();
            dividend.nextHops.put(equations[i][1], values[i]);
            divisor.nextHops.put(equations[i][0], 1.0 / values[i]);
            nodeMap.put(equations[i][0], dividend);
            nodeMap.put(equations[i][1], divisor);
        }

        Set<String> visited;
        for(int i = 0; i < queries.length; i++) {
            visited = new HashSet<String>();
            calCost(queries[i][0], queries[i][1], visited, results, i, 1.0);
            if(results[i] == 0) {
                results[i] = -1;
            }
        }
        return results;
    }

    private static void calCost(String root, String des, Set<String> visited, double[] results, int index, double cost) {
        visited.add(root);
        if(!nodeMap.containsKey(root) || !nodeMap.containsKey(root)) {
            return;
        }
        if (root.equals(des)) {
            results[index] = cost;
            return;
        }

        for(String nxt : nodeMap.get(root).nextHops.keySet()) {
            if(!visited.contains(nxt)) {
                calCost(nxt, des, visited, results, index, cost * nodeMap.get(root).nextHops.get(nxt));
            }
        }
        visited.remove(root);
    }

    public static void main(String[] args){
        String[][] equations = {{"a","b"},{"b","c"}};
        double[] values = {2.0,3.0};
        String[][] queries = {{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};
        double[] res = calcEquation(equations,values,queries);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
