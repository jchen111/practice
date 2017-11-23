package AirBnB.phone;

import java.util.*;

/**
 * Created by z001ktb
 */
public class WizardShortestDistance {

    public static List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int dest) {
        int[] parent = new int[wizards.size()];
        Map<Integer, Wizard> wizardMap = new HashMap<>();
        for(int i = 0; i < wizards.size(); i++) {
            parent[i] = i;
            Wizard cur = new Wizard(i);
            for(int j = 0; j < wizards.get(i).size(); j++) {
                int cost = (int) Math.pow(i - wizards.get(i).get(j), 2);
                cur.neighborCosts.put(wizards.get(i).get(j), cost);
            }
            wizardMap.put(i,cur);
        }

        bfs(source, dest, wizardMap, parent);

        List<Integer> path = new ArrayList<>();
        path.add(dest);
        while(parent[dest] != source) {
            dest = parent[dest];
            path.add(dest);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }

    private static void bfs(int source, int dest, Map<Integer, Wizard> wizardMap, int[] parent) {
        Queue<Integer> nodequeue = new LinkedList<>();
        Queue<Integer> costqueue = new LinkedList<>();
        nodequeue.offer(source);
        costqueue.offer(0);

        while(!nodequeue.isEmpty()) {
            int n = nodequeue.size();
            for(int i = 0; i < n; i++) {
                int cur = nodequeue.poll();
                int curcost = costqueue.poll();
                Wizard curWizard = wizardMap.get(cur);
                curWizard.minCost = Math.min(curWizard.minCost, curcost);
                if(cur == dest) continue;
                for(int next : curWizard.neighborCosts.keySet()) {
                    int nextCost = curcost + curWizard.neighborCosts.get(next);
                    if(nextCost < wizardMap.get(next).minCost) {
                        parent[next] = cur;
                        nodequeue.offer(next);
                        costqueue.offer(nextCost);
                    }
                }
            }
        }
    }

    static class Wizard {
        int id;
        int minCost;
        Map<Integer, Integer> neighborCosts = new HashMap<>();
        Wizard(int id) {
            this.id = id;
            this.minCost = Integer.MAX_VALUE;
        }
    }


    public static void main(String[] args) {
        int[][] ids = { {1,5,9},{2,3,9},{4},{},{},{9},{},{},{},{} };
        List<List<Integer>> wizards = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
          List<Integer> wizard = new ArrayList<>();
          for (int j = 0; j < ids[i].length; j++) {
            wizard.add(ids[i][j]);
          }
          wizards.add(wizard);
        }

        System.out.println(getShortestPath(wizards, 0, 9));
    }
}
