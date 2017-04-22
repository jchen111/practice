package basicAlgorithm;

import java.util.*;

/**
 * Created by z001ktb on 4/21/17.
 */
public class checkCycleInDirectedGraph {

    static Map<Integer, Vertice> graph = new HashMap<Integer, Vertice>();

    static class Vertice {
        int val;
        Set<Vertice> incommingEdges;
        Set<Vertice> outcommingEdges;
        public Vertice(int val, Set<Vertice> in, Set<Vertice> out) {
            this.val = val;
            this.incommingEdges = in;
            this.outcommingEdges = out;
        }
    }

    public static boolean checkCycle() {
        Queue<Vertice> queue = new LinkedList<Vertice>();
        for(Integer key : graph.keySet()){
            Vertice v = graph.get(key);
            if(v.incommingEdges.isEmpty()) queue.add(v);
        }

        while(!queue.isEmpty()){
            Vertice v = queue.poll();
            Iterator<Vertice> it = v.outcommingEdges.iterator();
            while(it.hasNext()){
                Vertice n = it.next();
                n.incommingEdges.remove(v);
                graph.put(n.val, n);
                if(n.incommingEdges.isEmpty()){
                    queue.add(n);
                }
                it.remove();
            }
            graph.put(v.val, v);
        }

        for(Integer key : graph.keySet()){
            if(!graph.get(key).incommingEdges.isEmpty() || !graph.get(key).outcommingEdges.isEmpty()) return true;
        }
        return false;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // number of graph
        int e = sc.nextInt(); // number of edges
        for(int i = 0; i < e; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            Vertice fromVertice = graph.containsKey(from)? graph.get(from) : new Vertice(from, new HashSet<Vertice>(), new HashSet<Vertice>());
            Vertice toVertice = graph.containsKey(to)? graph.get(to) : new Vertice(to, new HashSet<Vertice>(), new HashSet<Vertice>());

            fromVertice.outcommingEdges.add(toVertice);
            toVertice.incommingEdges.add(fromVertice);

            graph.put(from, fromVertice);
            graph.put(to, toVertice);
        }

        System.out.println(checkCycle());
    }
}
