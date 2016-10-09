package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/8/16.
 */
public class Search2DMatrix {
    //O(log(m*n))
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        return helper(matrix,target,0,row,0,col);
    }

    public static boolean helper(int[][] matrix, int target, int row_start, int row_end, int column_start, int column_end){
        if(row_start > row_end || column_start > column_end){
            return false;
        }

        if(row_start == row_end && column_start == column_end){
            if(matrix[row_start][column_start] == target)
                return true;
            return false;
        }
        int rmid = (row_start + row_end) / 2;
        int cmid = (column_start + column_end) / 2;
        if(matrix[rmid][cmid] == target){
            return true;
        }
        else if(matrix[rmid][cmid] > target){
            return helper(matrix,target,row_start,row_end,column_start,cmid-1) || helper(matrix,target,row_start,rmid-1,cmid,column_end);
        }
        else{
            return helper(matrix,target,row_start,row_end,cmid+1,column_end) || helper(matrix,target,rmid+1,row_end,column_start,cmid);
        }
    }

    //O(m+n)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while(row <= matrix.length && col >= 0){
            if(matrix[row][col] > target){
                row++;
            }else if(matrix[row][col] < target){
                col--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc  =  new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int target = sc.nextInt();
        int[][] matrix = new int[M][N];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(searchMatrix(matrix,target));
    }
}
