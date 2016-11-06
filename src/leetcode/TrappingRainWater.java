package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 11/5/16.
 */
public class TrappingRainWater {

    static int result = 0;
    public static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        result = 0;
        int[][] mark = new int[m][n];
        for(int i = 1; i < m - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(
                    mark[i][j] != -1 &&
                    heightMap[i-1][j] > heightMap[i][j] && //up
                    heightMap[i+1][j] > heightMap[i][j] && //down
                    heightMap[i][j-1] > heightMap[i][j] && //left
                    heightMap[i][j+1] > heightMap[i][j] //right
                    ){
                    BFS(heightMap, mark, i, j, m, n);
                }
            }
        }

        for(int i = 1; i < m - 1; i++ ){
            for(int j = 1; j < n - 1; j++){
                if(mark[i][j] == -1){
                    WaterBFS(heightMap, mark, i, j, 0, "");
                }
            }
        }

        return result;
    }

    public static void WaterBFS(int[][] heightMap, int[][] mark, int i, int j, int height, String dir){
        mark[i][j] = 0;
        int minHeight;
        if(mark[i-1][j] == -1){
            minHeight = Math.min(heightMap[i+1][j],Math.min(heightMap[i][j-1],heightMap[i][j+1]));
            result += (minHeight - heightMap[i][j]);
            WaterBFS(heightMap, mark, i-1, j, minHeight, "down");
        }
        if(mark[i+1][j] == -1){
            minHeight = Math.min(heightMap[i-1][j],Math.min(heightMap[i][j-1],heightMap[i][j+1]));
            result += (minHeight - heightMap[i][j]);
            WaterBFS(heightMap,mark,i+1,j,minHeight, "up");
        }
        if(mark[i][j-1] == -1){
            minHeight = Math.min(Math.min(heightMap[i-1][j],heightMap[i+1][j]),heightMap[i][j+1]);
            result += (minHeight - heightMap[i][j]);
            WaterBFS(heightMap, mark, i, j-1, minHeight, "right");
        }
        if(mark[i][j+1] == -1){
            minHeight = Math.min(Math.min(heightMap[i-1][j],heightMap[i+1][j]),heightMap[i][j-1]);
            result += (minHeight - heightMap[i][j]);
            WaterBFS(heightMap, mark, i, j+1, minHeight, "left");
        }


        switch (dir){
            case "left":
                minHeight = Math.min(Math.min(height,heightMap[i][j+1]),Math.min(heightMap[i+1][j],heightMap[i-1][j]));
                break;
            case "right":
                minHeight = Math.min(Math.min(height,heightMap[i][j-1]),Math.min(heightMap[i+1][j],heightMap[i-1][j]));
                break;
            case "up":
                minHeight = Math.min(Math.min(heightMap[i][j+1],heightMap[i][j-1]),Math.min(height,heightMap[i-1][j]));
                break;
            case "down":
                minHeight = Math.min(Math.min(heightMap[i][j+1],heightMap[i][j-1]),Math.min(height,heightMap[i+1][j]));
                break;
            default:
                minHeight = Math.min(Math.min(heightMap[i][j-1],heightMap[i][j+1]),Math.min(heightMap[i+1][j],heightMap[i-1][j]));
                break;
        }

        if(minHeight >= heightMap[i][j])
            result += (minHeight - heightMap[i][j]);

        return;
    }

    public static void BFS(int[][] heightMap, int[][] mark, int i, int j, int m, int n){

        mark[i][j] = -1;
        if(i-2 >= 0 && j - 1 >=0 && j+1 < n){ // find up
            if(mark[i-1][j] != -1){
                int minHeight = Math.min(heightMap[i+1][j],Math.min(heightMap[i][j-1],heightMap[i][j+1]));
                if( heightMap[i-1][j] < heightMap[i-2][j] &&  //up
                        heightMap[i-1][j] < heightMap[i-1][j-1] && //left
                        heightMap[i-1][j] < heightMap[i-1][j+1] && //right
                        heightMap[i-1][j] < minHeight){ // down
                    BFS(heightMap, mark, i-1, j, m, n);
                }
            }
        }

        if(i+2 < m && j + 1 < n && j-1 >=0){ // find down
            if(mark[i+1][j] != -1){
                int minHeight = Math.min(heightMap[i-1][j],Math.min(heightMap[i][j-1],heightMap[i][j+1]));
                if(heightMap[i+1][j] < heightMap[i+2][j] && //down
                        heightMap[i+1][j] < heightMap[i+1][j-1] && //left
                        heightMap[i+1][j] < heightMap[i+1][j+1] && //right
                        heightMap[i+1][j] < minHeight){ //up
                    BFS(heightMap, mark, i+1, j, m, n);
                }

            }
        }

        if(j - 2 >= 0 && i-1 >= 0 && i+1 < m){ // find left
            if(mark[i][j-1] != -1){
                int minHeight = Math.min(Math.min(heightMap[i-1][j],heightMap[i+1][j]),heightMap[i][j+1]);
                if(heightMap[i][j-1] < heightMap[i-1][j-1] && //up
                        heightMap[i][j-1] < heightMap[i][j-2] && //left
                        heightMap[i][j-1] < heightMap[i+1][j-1] && //down
                        heightMap[i][j-1] < minHeight){ //right
                    BFS(heightMap, mark, i, j-1, m, n);
                }
            }
        }

        if(j+2 < n && i + 1 < m && i-1 >= 0){ //find right
            if(mark[i][j+1] != -1){
                int minHeight = Math.min(Math.min(heightMap[i-1][j],heightMap[i+1][j]),heightMap[i][j-1]);
                if(heightMap[i][j+1] < heightMap[i+1][j+1] && // up
                        heightMap[i][j+1] < heightMap[i-1][j+1] && //down
                        heightMap[i][j+1] < heightMap[i][j+2] && //right
                        heightMap[i][j+1] < minHeight){ // left
                    BFS(heightMap, mark, i, j+1, m, n);
                }
            }
        }
        return;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] M = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                M[i][j] = sc.nextInt();
            }
        }
        System.out.println(trapRainWater(M));
    }
}
