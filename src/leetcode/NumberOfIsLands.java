package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/2/16.
 */
public class NumberOfIsLands {
    public static int numIslands(char[][] grid) {
        int row = grid.length;
        if(row == 0){
            return 0;
        }
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    doDFS(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void doDFS(char[][] grid, int rowIndex, int colIndex) {

        if(rowIndex >= 0 && colIndex >= 0 && rowIndex < grid.length && colIndex < grid[0].length && grid[rowIndex][colIndex] == '1'){
            grid[rowIndex][colIndex] = '0';
            doDFS(grid,rowIndex -1,colIndex);
            doDFS(grid,rowIndex,colIndex - 1);
            doDFS(grid,rowIndex,colIndex + 1);
            doDFS(grid,rowIndex+1,colIndex);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] grid = new char[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println(numIslands(grid));
    }
}
