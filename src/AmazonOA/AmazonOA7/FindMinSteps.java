package AmazonOA.AmazonOA7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by z001ktb on 5/17/17.
 */
public class FindMinSteps {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int findMinSteps(int[][] maze, int[] start, int[] end) {
        int steps = 0;
        int m = maze.length;
        if(m == 0) return steps;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(start);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == end[0] && cur[1] == end[1]) return steps;
            visited[cur[0]][cur[1]] = true;
            steps++;
            for(int[] dir : dirs){
                int i = cur[0] + dir[0];
                int j = cur[1] + dir[1];
                if(i >= 0 && j >= 0 && i < m && j < n && !visited[i][j] && maze[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        return steps;
    }
}
