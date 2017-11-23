package AirBnB.phone;

import java.util.*;

/**
 * Created by z001ktb
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        int[] degree = new int[256];
        Arrays.fill(degree, -1);
        String result="";
        if(words == null || words.length == 0) return result;
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                degree[word.charAt(i)] = 0;
            }
        }

        for(int i=0; i<words.length-1; i++){ //build degree array
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set= new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree[c2]++;
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<Character>();
        for(int i = 0; i < degree.length; i++) { // push root nodes
            if(degree[i] == 0) q.add((char)i);
        }
        while(!q.isEmpty()){ // check cycle
            char c = q.poll();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree[c2]--;
                    if(degree[c2] == 0) q.add(c2);
                }
            }
        }
        for(int i = 0; i < degree.length; i++){
            if(degree[i] > 0) return "";
        }
        return result;
    }
}
