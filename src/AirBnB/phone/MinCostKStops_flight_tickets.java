package AirBnB.phone;

/**
 * 给一些edge和cost，指定起始点和终点，找最多stop k次的最便宜的价格
 * A->B,100
 * B->C,100
 * A->C,500
 * 如果k是1的话，起点终点是A，C的话，那A->B->C的cost最小是200
 *
 * 本质是BFS一层层往外搜，可以把从起点到当前node的最小值存在这个node中，可以用来加速剪枝
 * follow up可以是输出路线，需要保存parent信息
 */

import java.util.*;

public class MinCostKStops_flight_tickets {

    /**
     * Created by z001ktb
     */
//    public static int minCost(List<String> lines, String source, String target, int k) {
//        if (lines.size() == 0 || k < 0) {
//            return 0;
//        }
//
//        Map<String, Node> nodes = new HashMap<>();
//        for (String line : lines) {
//            String[] parts = line.split(",");
//            String[] twoNodes = parts[0].split("->");
//            if (!nodes.containsKey(twoNodes[0])) {
//                nodes.put(twoNodes[0], new Node(twoNodes[0]));
//            }
//            if (!nodes.containsKey(twoNodes[1])) {
//                nodes.put(twoNodes[1], new Node(twoNodes[1]));
//            }
//            nodes.get(twoNodes[0]).nextNodes.put(twoNodes[1], Integer.parseInt(parts[1]));
//        }
//
//        // Parent map for path
//        Map<String, String> parent = new HashMap<>();
//
//        boolean find = bfs(nodes, source, target, k, parent); // parent is only used for follow up
//
//        List<String> path = new ArrayList<>();
//        // Output path
////        if (find) {
////            String cur = target;
////            while (!cur.equals(source)) {
////                path.add(cur);
////                cur = parent.get(cur);
////            }
////            path.add(source);
////            Collections.reverse(path);
////            System.out.println(path);
////        } else {
////            System.out.println("");
////        }
//
//        return find ? nodes.get(target).minCost : -1;
//    }
//
//    private static boolean bfs(Map<String, Node> nodes, String source, String target, int k, Map<String, String> parent) {
//        boolean find = false;
//
//        Queue<String> nodeQ = new LinkedList<>();
//        Queue<Integer> costQ = new LinkedList<>();
//        nodeQ.offer(source);
//        costQ.offer(0);
//
//        int stop = -1;
//        while (!nodeQ.isEmpty()) {
//            stop++;
//            if (stop > k + 1) {
//                break;
//            }
//            int size = nodeQ.size();
//            for (int i = 0; i < size; i++) {
//                Node cur = nodes.get(nodeQ.poll());
//                int curCost = costQ.poll();
//                cur.minCost = Math.min(cur.minCost, curCost);
//
//                if (cur.name.equals(target)) {
//                    find = true;
//                    continue;
//                }
//
//                for (String next : cur.nextNodes.keySet()) {
//                    int nextCost = curCost + cur.nextNodes.get(next);
//                    if (nextCost < nodes.get(next).minCost && (stop < k || stop == k && next.equals(target))) {
//                        // Update path
//                        parent.put(next, cur.name);
//                        nodeQ.offer(next);
//                        costQ.offer(nextCost);
//                    }
//                }
//            }
//        }
//
//        return find;
//    }
//
//
//    static class Node {
//        String name;
//        int minCost;
//        Map<String, Integer> nextNodes;
//
//        Node(String name) {
//            this.name = name;
//            this.minCost = Integer.MAX_VALUE;
//            this.nextNodes = new HashMap<>();
//        }
//    }


    public static int minCostKStop(List<String> flights, String source, String dest, int k) {
        Map<String, Node> nodes = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        for(String flight : flights) {
            String[] parts = flight.split(",");
            int cost = Integer.valueOf(parts[1]);
            String from = parts[0].split("->")[0];
            String to = parts[0].split("->")[1];
            Node f = nodes.containsKey(from) ? nodes.get(from) : new Node(from);
            Node t = nodes.containsKey(to) ? nodes.get(to) : new Node(to);
            nodes.put(from, f);
            nodes.put(to, t);
            f.children.put(t,cost);
        }

        nodes.get(source).minCost = 0;

        Queue<String> nodeq = new LinkedList<String>();
        Queue<Integer> costq = new LinkedList<Integer>();
        boolean found = false;
        int step = -1;

        nodeq.offer(source);
        costq.offer(nodes.get(source).minCost);
        int min = Integer.MAX_VALUE;

        while(!nodeq.isEmpty()) {
            int size = nodeq.size();
            step++;
            if(step > k + 1) break;
            for(int i = 0; i < size; i++) {
                String cur = nodeq.poll();
                int cost = costq.poll();
                if(cost > min) continue;
                if(cur.equals(dest)) {
                    min = Math.min(min,nodes.get(cur).minCost);
                    found = true;
                    continue;
                }
                for(Node child : nodes.get(cur).children.keySet()) {
                    if(step <= k) {
                        if( nodes.get(cur).children.get(child) + cost < child.minCost) parent.put(child.name, cur);
                        child.minCost = Math.min(child.minCost, nodes.get(cur).children.get(child) + cost);
                        nodes.put(child.name, child);
                        nodeq.offer(child.name);
                        costq.offer(child.minCost);
                    }
                }
            }
        }

        if(found) {
            List<String> path = new ArrayList<>();
            String tmp = dest;
            path.add(tmp);
            while(!parent.get(tmp).equals(source)) {
                tmp = parent.get(tmp);
                path.add(tmp);
            }
            path.add(source);
            Collections.reverse(path);
            for(String p : path) {
                System.out.print(p + " ");
            }
            System.out.println();
        }

        return nodes.get(dest).minCost != Integer.MAX_VALUE ? nodes.get(dest).minCost : -1;
    }

    static class Node {
        String name;
        int minCost; // min cost from source node to this node
        Map<Node, Integer> children;
        Node(String n) {
            name = n;
            minCost = Integer.MAX_VALUE;
            children = new HashMap<Node,Integer>();
        }
    }

  public static void main(String[] args) {
    List<String> lines = new ArrayList<>();
    lines.add("A->B,100");
    lines.add("A->C,400");
    lines.add("B->C,100");
    lines.add("C->D,100");
    lines.add("C->A,10");
//    System.out.println(minCostKStop(lines, "A", "D", 0));
//    System.out.println(minCostKStop(lines, "A", "D", 1));
    System.out.println(minCostKStop(lines, "A", "D", 2));
  }
}

//class Main {
//  public static void main(String[] args) {
//    MinCostKStops_flight_tickets mcks = new MinCostKStops_flight_tickets();
//    List<String> lines = new ArrayList<>();
//    lines.add("A->B,100");
//    lines.add("A->C,400");
//    lines.add("B->C,100");
//    lines.add("C->D,100");
//    lines.add("C->A,10");
//    System.out.println(mcks.minCost(lines, "A", "D", 0));
//    System.out.println(mcks.minCost(lines, "A", "D", 1));
//    System.out.println(mcks.minCost(lines, "A", "D", 2));
//  }
//}

