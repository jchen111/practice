package leetcode;

/**
 * Created by jiaqichen on 12/10/16.
 */
public class DungeonGame {
//    private static final int[][] dirs = {{-1,0},{0,-1}};
//    public static int calculateMinimumHP(int[][] dungeon) {
//        int m = dungeon.length;
//        int n = dungeon[0].length;
//        int health = dungeon[m-1][n-1] < 0 ? Math.abs(dungeon[m-1][n-1]) + 1 : 1;
//        return helper(m-1,n-1,m,n,dungeon,health);
//    }
//
//    public static int helper(int r, int c, int m, int n, int[][] dungeon, int health) {
//        if(r == 0 && c == 0){
//            return health;
//        }
//        int minHealth = Integer.MAX_VALUE;
//        for(int[] dir : dirs){
//            int i = r + dir[0];
//            int j = c + dir[1];
//            if(i >= 0 && j >= 0){
//                int h = 0;
//                if(dungeon[i][j] <= 0 && health == 0){
//                    h = Math.abs(dungeon[i][j]) + 1;
//                }else{
//                    h = Math.max(1, health - dungeon[i][j]);
//                }
//                minHealth = Math.min(minHealth,helper(i,j,m,n,dungeon,h));
//            }
//        }
//        return minHealth;
//    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] minHealth = new int[m][n];

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == m-1 && j == n-1) minHealth[i][j] = Math.max(1, 1 - dungeon[i][j]);
                else if(i == m-1) minHealth[i][j] = Math.max(1, minHealth[i][j+1] - dungeon[i][j]);
                else if(j == n-1) minHealth[i][j] = Math.max(1, minHealth[i+1][j] - dungeon[i][j]);
                else
                    minHealth[i][j] = Math.max(1, Math.min(minHealth[i+1][j], minHealth[i][j+1]) -  dungeon[i][j]);
            }
        }

        return minHealth[0][0];
    }

    public static void main(String[] args) {
//        int[][] d = {{-2,-3,-100},{-5,-100,-200},{100,101,-5}};
//        int[][] d = {{2},{1}};
        int[][] d = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(d));
    }
}
