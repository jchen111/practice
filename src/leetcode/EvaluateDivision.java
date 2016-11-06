package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by jiaqichen on 11/2/16.
 */
public class EvaluateDivision {
    static HashMap<String,Integer> dist;
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int equationsCount = equations.length;
        int queriesCount = queries.length;
        double[] res = new double[queriesCount];
        HashMap<String,Boolean> visit = new HashMap<String,Boolean>();
        HashMap<String,HashMap<String,Double>> graph = new HashMap<String,HashMap<String,Double>>();
        if(equationsCount == 0) return res;

        for(int i = 0; i < equationsCount; i++){ //construct the graph
            HashMap<String,Double> tmp;
            if(!graph.containsKey(equations[i][0])){
                tmp = new HashMap<String,Double>();
                tmp.put(equations[i][1],values[i]);
                tmp.put(equations[i][0],1.0);
                graph.put(equations[i][0],tmp);

                if(!graph.containsKey(equations[i][1])){
                    tmp = new HashMap<String,Double>();
                    tmp.put(equations[i][0],1.0/values[i]);
                    tmp.put(equations[i][1],1.0);
                    graph.put(equations[i][1],tmp);
                }else{
                    tmp = graph.get(equations[i][1]);
                    tmp.put(equations[i][0],1.0/values[i]);
                    graph.put(equations[i][1],tmp);
                }
            }else{
                tmp = graph.get(equations[i][0]);
                tmp.put(equations[i][1],values[i]);
                graph.put(equations[i][0],tmp);

                if(!graph.containsKey(equations[i][1])){
                    tmp = new HashMap<String,Double>();
                    tmp.put(equations[i][0],1.0/values[i]);
                    tmp.put(equations[i][1],1.0);
                    graph.put(equations[i][1],tmp);
                }else{
                    tmp = graph.get(equations[i][1]);
                    tmp.put(equations[i][0],1.0/values[i]);
                    graph.put(equations[i][1],tmp);
                }
            }
            visit.put(equations[i][1],false);
            visit.put(equations[i][0],false);
        }

        for(int i = 0; i < queriesCount; i++){
            if(graph.containsKey(queries[i][0]) && graph.containsKey(queries[i][1])){
                if(queries[i][0].equals(queries[i][1])) {
                    res[i] = 1.0;
                    continue;
                }
                dist = new HashMap<String,Integer>();
                HashMap<String,Boolean> v = new HashMap<String,Boolean>(visit);
                BFS(queries[i][1],graph,v,dist);
                v = new HashMap<String,Boolean>(visit);
                res[i] = 1.0;
                LinkedList<String> queue = new LinkedList<String>();
                queue.add(queries[i][0]);
                while(!queue.isEmpty()){
                    String cur = queue.removeFirst();
                    v.put(cur,true);
                    int min = Integer.MAX_VALUE;
                    String next = "";
                    for(String nxt : graph.get(cur).keySet()){
                        if(!v.get(nxt) && dist.get(nxt) < min){
                            min = dist.get(nxt);
                            next = nxt;
                        }
                        v.put(nxt,true);
                    }
                    if(!next.isEmpty()) {
                        queue.add(next);
                        res[i] *= graph.get(cur).get(next);
                        if(next.equals(queries[i][1])) break;
                    }
                }
            }else{
                res[i] = -1;
            }
        }
        return res;
    }

    public static void BFS(String dest, HashMap<String,HashMap<String,Double>> graph, HashMap<String,Boolean> visit, HashMap<String,Integer> dist){

        LinkedList<String> queue = new LinkedList<String>();
        queue.add(dest);
        for(String s : graph.keySet()){
            if(s.equals(dest)) dist.put(s,0);
            else dist.put(s,Integer.MAX_VALUE);
        }

        while(!queue.isEmpty()){
            String current = queue.removeFirst();
            visit.put(current,true);
            HashMap<String,Double> neighbors = graph.get(current);
            for(String key : neighbors.keySet()){
                if(!visit.get(key)){
                    int val = dist.get(key);
                    val = dist.get(current) + 1;
                    dist.put(key,val);
                    queue.add(key);
                    visit.put(key,true);
                }
            }
        }
    }

    public static void main(String[] args){
        String[][] equations = {{"a","b"},{"b","c"}};
        double[] values = {1.5,2.5};
        String[][] queries = {{"c","b"}};
        double[] res = calcEquation(equations,values,queries);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
