package leetcode;

import java.util.ArrayList;

/**
 * Created by jiaqichen on 10/27/16.
 */
public class ShortestDistancefromAllBuildings {
    class coordinate{
        int row;
        int col;
        coordinate(int i, int j){
            this.row = i;
            this.col = j;
        }
    }

    public int shortestDistance(int[][] grid) {
        int row = grid.length;
        if(row == 0) return -1;
        int col = grid[0].length;
        int path = Integer.MAX_VALUE;
        ArrayList<coordinate> buildings = new ArrayList<coordinate>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1) buildings.add(new coordinate(i,j));
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0){
                    long tmp = 0;
                    for(int k = 0; k < buildings.size(); k++){
                        tmp += calculateShortestPath(grid,i,j,buildings.get(k).row,buildings.get(k).col,tmp);
                    }
                    if(tmp < (long)Integer.MAX_VALUE) path = Math.min(path,(int)tmp);
                }
            }
        }
        if(path == Integer.MAX_VALUE) return -1;
        return path;
    }

    public long calculateShortestPath(int[][] grid, int i, int j, int desRow, int desCol, long path){
        if(i == desCol && j == desCol){
            return path;
        }
        long up = Integer.MAX_VALUE;
        long down = Integer.MAX_VALUE;
        long left = Integer.MAX_VALUE;
        long right = Integer.MAX_VALUE;
        if(i-1 >= 0  && grid[i-1][j] == 0) {
            up = Math.min(up,calculateShortestPath(grid,i-1,j,desRow,desCol,path+1));
        }
        if(i+1 < grid.length && grid[i+1][j] == 0){
            down = Math.min(down,calculateShortestPath(grid,i+1,j,desRow,desCol,path+1));
        }
        if(j-1 >=0 && grid[i][j-1] == 0){
            left = Math.min(left,calculateShortestPath(grid,i,j-1,desRow,desCol,path+1));
        }
        if(j+1 < grid[0].length && grid[i][j+1] == 0){
            right = Math.min(left,calculateShortestPath(grid,i,j+1,desRow,desCol,path+1));
        }
        return Math.min(Math.min(up,down),Math.min(left,right));
    }
}
