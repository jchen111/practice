package hackerrank;

import java.util.*;

/**
 * Created by z001ktb on 5/4/16.
 */
public class ComponentsInGraph {

    //each number's candidates is stored here
    static int candidates[] = new int[300001];
    //key: candidates of the set, val: sets in LinkedLists
    static HashMap<Integer,LinkedList<Integer>> sets = new HashMap<Integer,LinkedList<Integer>>();

    //findSet O(1)
    static int findSet(int x) {
        return candidates[x];
    }

    //createSet O(1)
    static void createSet(int x) {
        LinkedList<Integer> set = new LinkedList<Integer>();
        set.add(x);
        sets.put(x,set);
        candidates[x] = x;
    }


    static void mergeSet(int x, int y) {
        int x_parent = findSet(x);
        int y_parent = findSet(y);
        int new_key = Math.max(x_parent,y_parent);
        sets.get(x_parent).addAll(sets.get(y_parent));
        /**
         * remove the merged set
         */
        sets.remove(y_parent);
        /**
         update the candidate for all the elements in the new set
         O(N)
         */
        for(Integer i:sets.get(x_parent)) {
            candidates[i] = new_key;
        }
        LinkedList<Integer> item = sets.get(x_parent);
        sets.remove(x_parent);
        sets.put(new_key,item);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++) {
            int G = sc.nextInt();
            int B = sc.nextInt();
            if(candidates[G]==0){
                createSet(G);
            }
            if(candidates[B] ==0){
                createSet(B);
            }
            /**
             * O(N^2)
             */
            if(findSet(G) != findSet(B)) {
                mergeSet(G,B);
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Iterator it = sets.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,LinkedList<Integer>> pair = (Map.Entry<Integer,LinkedList<Integer>>)it.next();
            if(pair.getValue().size() < min){
                min = pair.getValue().size();
            }
            if(pair.getValue().size() > max){
                max = pair.getValue().size();
            }
        }
        System.out.println(min+" "+max);
    }
}
