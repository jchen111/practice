package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/1/16.
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new LinkedList<Integer>();
        if(matrix.length == 0){
            return spiral;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int direction = 0;
        while(left <= right && top <= bottom){
            if(direction == 0){ // from left to right
                for(int i = left; i <= right; i++){
                    spiral.add(matrix[top][i]);
                }
                top++;
            }
            if(direction == 1){ // from top to bottom
                for(int i = top; i <= bottom; i++){
                    spiral.add(matrix[i][right]);
                }
                right--;
            }
            if(direction == 2){ // from right to left
                for(int i = right; i >= left; i--){
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(direction == 3){// from bottom to top
                for(int i = bottom; i >= top; i--){
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return spiral;
    }

    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        sc.next();
        int[][] m = {{2, 5, 8 },{4,0,-1}};
    }
}
