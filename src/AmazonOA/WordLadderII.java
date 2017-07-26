package AmazonOA;

import java.util.*;

/**
 * Created by z001ktb on 6/23/17.
 */
public class WordLadderII {
    static List<List<String>> result;
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        result = new ArrayList<List<String>>();
        Set<String> dic = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        Map<String,List<String>> graph = new HashMap<String,List<String>>();
        for(String word : wordList) {
            dic.add(word);
        }
        dic.add(beginWord);

        int steps = 0;
        int minSteps = Integer.MAX_VALUE;

        visited.add(beginWord);
        List<String> nextLevel = new ArrayList<String>();
        nextLevel.add(beginWord);

        while(!nextLevel.isEmpty()) {
            List<String> tmp = nextLevel;
            nextLevel = new ArrayList<String>();
            for(String cur : tmp) {
                if (cur.equals(endWord)) {
                    minSteps = steps;
                }
                if (steps >= minSteps) continue;

                List<String> neighbors = graph.containsKey(cur)? graph.get(cur) : getNeighbors(cur, dic);
                graph.put(cur, neighbors);
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        nextLevel.add(neighbor);
                    }
                }
            }

            if(!nextLevel.isEmpty()){
                steps++;
            }
        }
        visited = new HashSet<String>();
        List<String> solution = new ArrayList<String>();
        solution.add(endWord);
        visited.add(endWord);
        if(minSteps != Integer.MAX_VALUE) backtrack(endWord, beginWord, minSteps, solution, dic, visited, graph);
        return result;
    }

    private static List<String> getNeighbors(String word, Set<String> dic) {
        List<String> result = new ArrayList<String>();
        char[] chs = word.toCharArray();
        String str;
        for(int i = 0; i < chs.length; i++) {
            char cur = chs[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c != cur){
                    chs[i] = c;
                    str = new String(chs);
                    if(dic.contains(str)) result.add(str);
                    chs[i] = cur;
                }
            }
        }
        return result;
    }

    private static void backtrack(String cur, String des, int steps, List<String> solution, Set<String> dic, Set<String> visited, Map<String,List<String>> graph) {
        if(steps == 0 && cur.equals(des)) {
            result.add(new ArrayList<String>(solution));
            return;
        }else if(steps <= 0){
            return;
        }

        List<String> neighbors = graph.containsKey(cur)? graph.get(cur) : getNeighbors(cur, dic);
        graph.put(cur, neighbors);
        if(neighbors != null) {
            for(String neighbor : neighbors) {
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    solution.add(0, neighbor);
                    backtrack(neighbor, des, steps - 1, solution, dic, visited, graph);
                    visited.remove(neighbor);
                    solution.remove(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"most","mist","miss","lost","fist","fish"};
        String beginWord = "lost";
        String endWord = "miss";

        findLadders(beginWord, endWord, Arrays.asList(words));
    }
}
