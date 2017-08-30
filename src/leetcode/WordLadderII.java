package leetcode;

import java.util.*;

public class WordLadderII {

    static class Node {
        String str;
        int distance;
        Node(String s, int dis) {
            this.str = s;
            this.distance = dis;
        }
    }
    // get only one path
    public static List<String> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<String> result = new LinkedList<String>();
        Map<String,List<String>> graph = new HashMap<String,List<String>>();
        Map<String,Integer> distance = new HashMap<String,Integer>();
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        int min = Integer.MAX_VALUE;

        queue.add(endWord);
        wordList.add(beginWord);
        wordList.add(endWord);

        for(String s : wordList){
            distance.put(s,min);
        }

        distance.put(endWord,0);

        //BFS build graph and distance map
        while(!queue.isEmpty()){
            String cur = queue.poll();
            visited.add(cur);
            int dis = distance.get(cur) + 1;
            if(dis > min) break;

            List<String> neighbors = getNeighbors(cur,wordList);
            graph.put(cur,neighbors);
            for(String neighbor : neighbors){
                if(dis < distance.get(neighbor) && !visited.contains(neighbor)){
                    queue.add(neighbor);
                    distance.put(neighbor,dis);
                }

                if(neighbor.equals(beginWord)) min = dis;

            }
        }

        result.add(beginWord);
        queue = new LinkedList<String>();
        queue.add(beginWord);
        visited = new HashSet<String>();

        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(cur.equals(endWord)) break;
            visited.add(cur);
            PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.distance - o2.distance;
                }
            });
            List<String> neighbors = getNeighbors(cur,wordList);
            for(String s : neighbors){
                if(!visited.contains(s)) pq.add(new Node(s,distance.get(s)));
            }
            Node tmp = pq.poll();
            result.add(tmp.str);
            queue.add(tmp.str);
        }

        return result;
    }

    private static List<String> getNeighbors(String s, Set<String> wordList) {
        List<String> result = new ArrayList<String>();
        char[] chs = s.toCharArray();
        for(char c = 'a'; c <= 'z'; c++){
            for(int i = 0; i < s.length(); i++){
                char oldChar = chs[i];
                chs[i] = c;
                String str = new String(chs);
                if(!str.equals(s) && wordList.contains(str)) result.add(str);
                chs[i] = oldChar;
            }
        }
        return result;
    }






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "a";
		String end = "c";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");dict.add("dot");dict.add("dog");
		dict.add("lot");dict.add("log");
		List<String> res = findLadders(start,end,dict);
		for(int i=0;i<res.size();i++){
            System.out.print(res.get(i) +" ");
		}
	}

}
