package AmazonOA.phone;

import java.util.*;

/**
 * Created by z001ktb on 5/23/17.
 */
public class EmployeeAndBoss {

    static Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
    static Set<String> people = new HashSet<String>();

    public static Map<String ,Integer> bossAndPeople(String[][] pairs) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        for(String[] pair : pairs){
            Set<String> subordinate = graph.containsKey(pair[1])? graph.get(pair[1]) : new HashSet<String>();
            subordinate.add(pair[0]);
            graph.put(pair[1],subordinate);
            people.add(pair[0]);
            people.add(pair[1]);
        }

        Iterator<String> it = people.iterator();
        while(it.hasNext()){
            String cur = it.next();
            dfs(result, cur, cur, 0, new HashSet<String>());
        }

        return result;
    }


    public static void dfs(Map<String, Integer> result, String source, String cur, int count, Set<String> visited) {
        if(!graph.containsKey(cur)){
            visited.add(cur);
            result.put(source, count);
            return;
        }
        Set<String> sub = graph.get(cur);
        Iterator<String> it = sub.iterator();
        while(it.hasNext()){
            String next = it.next();
            if(!visited.contains(next)) {
                visited.add(next);
                dfs(result, source, next, count+1, visited);
            }
        }
    }

    public static void main(String[] args) {
        String[][] pairs = {{"x","y"},{"y","z"},{"z","s"},{"s","s"}};
        Map<String ,Integer> res = bossAndPeople(pairs);
    }
}
