package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/2/16.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        if(row == 0){
            return;
        }
        int col = matrix[0].length;
        int[][] res = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                res[j][col-1-i] = matrix[i][j];
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = res[i][j];
            }
        }
    }

    public static void rotate2(int[][] matrix){
        int row = matrix.length;
        if(row == 0){
            return ;
        }
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            for(int j = i; j < col; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        int i = 0;
        int j = col - 1;
        while(i < j){
            for(int k = 0; k < row; k++){
                int tmp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = tmp;
            }
            i++;
            j--;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] grid = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        rotate2(grid);
        System.out.println();

    }
}
