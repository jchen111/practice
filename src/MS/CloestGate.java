package MS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by z001ktb on 5/10/17.
 */
public class CloestGate {
    static boolean[][] visited;
    static int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
    static ArrayList<int[]> result;
    public static ArrayList<int[]> findCloestGate(int[][] maze, int m, int n, int row, int col) {
        result = new ArrayList<int[]>();
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(maze[i][j] == 0){
                    bfs(maze, visited, m, n, i, j);
                    visited = new boolean[m][n];
                }
            }
        }
        dfs(maze, visited, m, n, row, col, maze[row][col]);
        return result;
    }

    public static void dfs(int[][] maze, boolean[][] visited, int m, int n, int row, int col, int len){
        if(len == 0 && maze[row][col] == 0){
            result.add(new int[]{row,col});
            return;
        }
        if(maze[row][col] == -1) return;

        visited[row][col] = true;
        for(int[] dir : directions){
            int r = row + dir[0];
            int c = col + dir[1];
            if(r >= 0 && r < m && c >=0 && c < n && maze[r][c] != -1 && !visited[r][c]){
                dfs(maze, visited, m, n, r, c, len - 1);
            }
        }
        visited[row][col] = false;
    }

    public static void bfs(int[][] maze, boolean[][] visited, int m, int n, int row, int col) {
        ArrayList<int[]> queue = new ArrayList<int[]>();
        queue.add(new int[]{row,col});
        int layer = 0;
        while(!queue.isEmpty()) {
            ArrayList<int[]> tmpQueue = new ArrayList<int[]>();
            for(int i = 0; i < queue.size(); i++){
                int[] cur = queue.get(i);
                maze[cur[0]][cur[1]] = Math.min(maze[cur[0]][cur[1]], layer);
                visited[cur[0]][cur[1]] = true;
                for(int[] dir : directions){
                    int newrow = cur[0] + dir[0];
                    int newcol = cur[1] + dir[1];
                    if(newrow >= 0 &&
                            newrow < m &&
                            newcol >= 0 && newcol < n &&
                            maze[newrow][newcol] != -1 &&
                            !visited[newrow][newcol] &&
                            maze[newrow][newcol] != 0
                            ){
                        tmpQueue.add(new int[]{newrow,newcol});
                    }
                }
            }

            if(!tmpQueue.isEmpty()){
                queue = new ArrayList<int[]>(tmpQueue);
                layer++;
            }else{
                queue = new ArrayList<int[]>();
            }
        }
    }

    public static void main(String[] args) {
        int[][] maze = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                        {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                        {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};
        findCloestGate(maze, 4,4,1,1);

    }
}
