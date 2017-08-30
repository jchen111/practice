package leetcode;

public class GameOfLife {
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] diagonals = {{1,1},{1,-1},{-1,1},{-1,-1}};
    /**
     10 dead -> live 2
     11 dead -> dead 3
     01 live -> dead 1
     00 live -> live 0
     **/
    public static void gameOfLife(int[][] board) {
        if(board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int numOfAlive = numberOfNeighborsAlive(board, m, n, i, j);
                if(board[i][j] == 0) {
                    if(numOfAlive < 2) {
                        board[i][j] = 1;
                    } else if(numOfAlive == 2 || numOfAlive == 3) {
                        board[i][j] = 0;
                    } else if(numOfAlive > 3) {
                        board[i][j] = 1;
                    }
                } else if(board[i][j] == 1) {
                    if(numOfAlive == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = board[i][j] & 1;
            }
        }
        return;
    }

    public static int numberOfNeighborsAlive(int[][] board, int m, int n, int i, int j) {
        int count = 0;
        for(int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(r >= 0 && r < m && c >= 0 && c < n && (board[r][c]>>1) == 0) {
                count++;
            }
        }
        for(int[] diagonal : diagonals) {
            int r = diagonal[0] + i;
            int c = diagonal[1] + j;
            if(r >= 0 && r < m && c >= 0 && c < n && (board[r][c]>>1) == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board = {{1,1},{1,0}};
        gameOfLife(board);
    }
}
