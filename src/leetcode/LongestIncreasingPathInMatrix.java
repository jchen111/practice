package leetcode;

/**
 * Created by z001ktb
 */
public class LongestIncreasingPathInMatrix {
    static int max;
    static int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
    static boolean[][] visited;
    static int[][] cache;
    static public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        visited = new boolean[m][n];
        cache = new int[m][n];
        max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, m, n, i, j));
            }
        }
        return max;
    }

    static private int dfs(int[][] matrix, int m, int n, int i, int j) {
        int len = 1;
        visited[i][j] = true;
        for(int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] < matrix[i][j] && !visited[r][c]) {
                if(cache[r][c] != 0) {
                    len = Math.max(len, 1 + cache[r][c]);
                } else {
                    len = Math.max(len, 1 + dfs(matrix, m, n, r, c));
                }
            }
        }
        cache[i][j] = Math.max(cache[i][j], len);
        visited[i][j] = false;
        return len;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
//        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        int[][] matrix = {{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
        System.out.println(longestIncreasingPath(matrix));
    }
}
