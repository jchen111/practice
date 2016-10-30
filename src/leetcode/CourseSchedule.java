package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/29/16.
 */
public class CourseSchedule {
    static HashMap<Integer,List<Integer>> graph;
    static boolean[] onStack;
    static boolean[] marked;
    static boolean hasCycle;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return false;
        graph = new HashMap<Integer,List<Integer>>();
        onStack = new boolean[numCourses];
        marked = new boolean[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            List<Integer> nextHops;
            if(graph.containsKey(prerequisites[i][0])){
                nextHops = graph.get(prerequisites[i][0]);
            }else{
                nextHops = new LinkedList<Integer>();
            }
            nextHops.add(prerequisites[i][1]);
            graph.put(prerequisites[i][0],nextHops);
        }

        for(int i:graph.keySet()){
            if(!marked[i])
                detectCycle(i);
        }

        for(int i = 0; i < numCourses; i++){
            if(!marked[i]) return false;
        }
        return !hasCycle;
    }

    public static void detectCycle(int startPoint){
        marked[startPoint] = true;
        onStack[startPoint] = true;
        if(graph.containsKey(startPoint)) {
            for (int i = 0; i < graph.get(startPoint).size(); i++) {
                if(!marked[graph.get(startPoint).get(i)]) {
                    detectCycle(graph.get(startPoint).get(i));
                }else if(onStack[graph.get(startPoint).get(i)]){
                    hasCycle = true;
                    return;
                }
            }
        }
        onStack[startPoint] = false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[N][2];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(canFinish(n,matrix));
    }
}
