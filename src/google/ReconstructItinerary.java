package google;

import java.util.*;

/**
 * Created by jiaqichen on 11/20/16.
 */
public class ReconstructItinerary {
    static LinkedList<String> itinerary;
    static HashMap<String,PriorityQueue<String>> graph;
    public static List<String> findItinerary(String[][] tickets) {
        graph = new HashMap<String,PriorityQueue<String>>();
        itinerary = new LinkedList<String>();

        for(String[] ticket : tickets){
            String departure = ticket[0];
            String destination = ticket[1];
            PriorityQueue<String> route;
            if(graph.containsKey(departure)){
                route = graph.get(departure);
            }else{
                route = new PriorityQueue<String>();
            }
            route.add(destination);
            graph.put(departure,route);
        }
        dfs("JFK");
        return itinerary;
    }

    public static void dfs(String dept){
        PriorityQueue<String> route = graph.get(dept);
        while(route != null && !route.isEmpty()){
            dfs(route.poll());
        }
        itinerary.addFirst(dept);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] m = new String[n][2];
        for(int i = 0; i < n; i++){
            m[i][0] = sc.next();
            m[i][1] = sc.next();
        }
        findItinerary(m);
    }
}
