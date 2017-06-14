package AmazonOA;

import java.util.*;

public class FindLargestConnectedComponent {

    public static ArrayList<String> findLargestConnextedComponent(ArrayList<String[]> pairs) {
        ArrayList<String> res = new ArrayList<String>();
        Map<String, Set<String>> graph = new HashMap<String,Set<String>>();
        for(String[] pair : pairs) {
            String first = pair[0];
            String second = pair[1];
            Set<String> firstSet = graph.containsKey(first)? graph.get(first) : new HashSet<String>();
            firstSet.add(first);
            firstSet.add(second);
            Set<String> secondSet = graph.containsKey(second)? graph.get(second) : new HashSet<String>();
            secondSet.add(first);
            secondSet.add(second);
            graph.put(first, firstSet);
            graph.put(second, secondSet);
        }

        for(String node : graph.keySet()){
            Set<String> neighbors = graph.get(node);
            Iterator<String> it = neighbors.iterator();
            while(it.hasNext()){
                String neighbor = it.next();
                Set<String> neighborSet = graph.get(neighbor);
                if(neighbors != neighborSet){
                    neighborSet.addAll(neighbors);
                    graph.put(neighbor, neighborSet);
                }
            }
        }

        Set<String> largestGroup = new HashSet<String>();
        for(String node : graph.keySet()){
            if(graph.get(node).size() > largestGroup.size()){
                largestGroup = graph.get(node);
            }
        }

        if(largestGroup.size() > 0){
            res = new ArrayList<String>(largestGroup);
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String[]> list = new ArrayList<String[]>();
        for(int i = 0; i < n; i++){
            String[] strs = new String[2];
            strs[0] = sc.next();
            strs[1] = sc.next();
            list.add(strs);
        }

        ArrayList<String> res = findLargestConnextedComponent(list);

        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
