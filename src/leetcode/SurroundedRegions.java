package leetcode;

/**
 * Created by z001ktb on 10/22/16.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O'){
                dfs(board,0,i);
            }
            if(board[row-1][i] == 'O'){
                dfs(board,row-1,i);
            }
        }

        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
                dfs(board,i,0);
            }
            if(board[i][col-1] == 'O'){
                dfs(board,i,col-1);
            }
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j){
        if((i >=0 && i < board.length) && (j >= 0 && j < board[0].length)) {
            if (board[i][j] == 'O') {
                board[i][j] = '1';
                dfs(board,i-1,j);
                dfs(board,i+1,j);
                dfs(board,i,j-1);
                dfs(board,i,j+1);
            }
        }
    }
}
