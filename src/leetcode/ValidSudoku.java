package leetcode;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/11/16.
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> cols = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if(board[j][i] != '.' && !cols.add(board[j][i])) return false;
                int rowIndex = 3 * (i/3);
                int colIndex = 3 * (i%3);
                if(board[rowIndex + j/3][colIndex + j%3] != '.' && !cube.add(board[rowIndex + j/3][colIndex + j%3])) return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9 ; j++){
                board[i][j] = sc.next().charAt(0);
            }
        }
        isValidSudoku(board);
    }
}
