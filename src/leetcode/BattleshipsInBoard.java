package leetcode;

/**
 * Created by jiaqichen on 12/1/16.
 */
public class BattleshipsInBoard {
    static char[][] cpboard;
    static int[][] dirs = {{1,0},{0,1}};
    static public int countBattleships(char[][] board) {
        int count = 0;
        if(board.length == 0) return count;
        cpboard = board;
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                cpboard[i][j] = board[i][j];
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(cpboard[i][j] == 'X') {
                    findBattleships(i,j);
                    count++;
                }
            }
        }
        return count;
    }

    static public void findBattleships(int i, int j) {
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r < cpboard.length && c < cpboard[0].length && cpboard[r][c] == 'X') {
                cpboard[r][c] = '.';
                findBattleships(r,c);
            }
        }
        return;
    }

    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(countBattleships(board));
    }
}
