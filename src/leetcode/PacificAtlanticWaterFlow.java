package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by z001ktb on 11/12/16.
 */
public class PacificAtlanticWaterFlow {

    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<int[]>();
        if(matrix.length == 0) return result;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] waterFlowCount = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++){ // from top row
            dfs(matrix,0,i,visited, waterFlowCount);
        }
        for(int i = 0; i < matrix.length; i++){ // from left
            dfs(matrix,i,0,visited, waterFlowCount);
        }

        visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++){ // from bottom
            dfs(matrix,matrix.length-1,i,visited, waterFlowCount);
        }
        for(int i = 0; i < matrix.length; i++){ // from right
            dfs(matrix,i,matrix[0].length-1,visited, waterFlowCount);
        }

        for(int i = 0; i < waterFlowCount.length; i++){
            for(int j = 0; j < waterFlowCount[0].length; j++){
                if(waterFlowCount[i][j] == 2)
                    result.add(new int[]{i,j});
            }
        }

        return result;
    }

    public static void dfs(int[][] matrix, int i, int j, boolean[][] visited, int[][] waterFlowCount){
        if(i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        waterFlowCount[i][j]++;
        for(int[] dir : dirs){
            int nexti = i + dir[0];
            int nextj = j + dir[1];
            if(nexti >= 0 && nexti < matrix.length && nextj >= 0 && nextj < matrix[0].length && !visited[nexti][nextj] ) {
               if(matrix[nexti][nextj] >= matrix[i][j]) dfs(matrix,nexti,nextj,visited,waterFlowCount);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        List<int[]> res = pacificAtlantic(matrix);

        for(int i = 0; i < res.size(); i++){
            for(Integer in : res.get(i)){
                System.out.print(in + " ");
            }
            System.out.println();
        }
    }
}
