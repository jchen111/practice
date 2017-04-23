package leetcode;

/**
 * Created by z001ktb on 4/22/17.
 */
public class CountBattleShips {

    public static int countBattleships(char[][] board) {
        int m = board.length;
        int n = 0;
        if(m > 0) n = board[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X'){
                    if(i == 0 && j == 0){
                        count++;
                    }else if(i > 0 && j > 0){
                        if(board[i-1][j] != 'X' && board[i][j-1] != 'X') count++;
                    }else if(i == 0 && j > 0){
                        if(board[i][j-1] != 'X') count++;
                    }else if(j == 0 && i > 0){
                        if(board[i-1][j] != 'X') count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
