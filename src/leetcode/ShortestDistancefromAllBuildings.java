package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/27/16.
 */
public class ShortestDistancefromAllBuildings {
    static int[][] distance;
    static int[][] canReachBuildings;
    public static int shortestDistance(int[][] grid) {
        distance = new int[grid.length][grid[0].length];
        canReachBuildings = new int[grid.length][grid[0].length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numOfBuildings = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    bfs(grid,i,j);
                    numOfBuildings++;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < distance.length; i++){
            for(int j = 0; j < distance[0].length; j++){
                if(grid[i][j] == 0 && canReachBuildings[i][j] == numOfBuildings){
                    min = Math.min(min,distance[i][j]);
                }
            }
        }
        return min;
    }

    public static void bfs(int[][] grid, int i, int j){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        LinkedList<List<int[]>> levels = new LinkedList<List<int[]>>();
        List<int[]> currlevel = new LinkedList<int[]>();
        int dist = 0;
        currlevel.add(new int[]{i,j});
        levels.add(0,currlevel);
        distance[i][j] = 0;
        canReachBuildings[i][j] = 0;
        visited[i][j] = true;

        while(!currlevel.isEmpty()){
            List<int[]> plevel = levels.get(dist);
            currlevel = new LinkedList<int[]>();
            for(int k = 0; k < plevel.size(); k++){
                i = plevel.get(k)[0];
                j = plevel.get(k)[1];
                if(i - 1 >= 0 && !visited[i-1][j] && grid[i-1][j] == 0){     //search up
                    visited[i-1][j] = true;
                    currlevel.add(new int[]{i-1,j});
                    distance[i-1][j] += dist + 1;
                    canReachBuildings[i-1][j]++;
                }
                if(i + 1 < grid.length && !visited[i+1][j] && grid[i+1][j] == 0){ //search down
                    visited[i+1][j] = true;
                    currlevel.add(new int[]{i+1,j});
                    distance[i+1][j] += dist + 1;
                    canReachBuildings[i+1][j]++;
                }
                if(j - 1 >= 0 && !visited[i][j-1] && grid[i][j-1] == 0){ //search left
                    visited[i][j-1] = true;
                    currlevel.add(new int[]{i,j-1});
                    distance[i][j-1] += dist + 1;
                    canReachBuildings[i][j-1]++;
                }
                if(j + 1 < grid[0].length && !visited[i][j+1] && grid[i][j+1] == 0){ //search right
                    visited[i][j+1] = true;
                    currlevel.add(new int[]{i,j+1});
                    distance[i][j+1] += dist + 1;
                    canReachBuildings[i][j+1]++;
                }
            }
            if(!currlevel.isEmpty()){
                dist++;
                levels.add(dist,currlevel);
            }

        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(shortestDistance(grid));
    }

}
