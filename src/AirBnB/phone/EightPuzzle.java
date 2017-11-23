package AirBnB.phone;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by z001ktb
 */
public class EightPuzzle {

    /**
     * https://en.wikipedia.org/wiki/15_puzzle
     * 就是wikipeida里的问题换成九宫格，有8个版
     * 这里我们假设空格为0，所以0周围的数字可以与其交换
     *
     * 最好的应该是A*算法，这里用BFS也是可以做的。最好不要DFS，可能会爆栈。
     * 面经里应该只需要判断是否能solve，其实打印出最短路径也是差不多的
     */

    /**
     * BFS
     * time O(n^3)
     * **/

    static int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
    static int[][] matrix;
    static int m;
    static int n;
    static int origin_i;
    static int origin_j;
    static String recoveredString;
    public static boolean canSolve(int[][] puzzle) {
        m = puzzle.length;
        n = puzzle[0].length;
        recoveredString = "";
        matrix = puzzle;
        for(int i = 0; i < m; i++) { // n^2
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    origin_i = i;
                    origin_j = j;
                }
                if(i == m - 1 && j == n - 1) {
                    recoveredString += 0 + "";
                } else {
                    recoveredString += (i*m + j + 1) + ",";
                }
            }
        }
        return doSolve();
    }

    private static String getMatrixString(int[][] matrix) { // n^2
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == m - 1 && j == n - 1) {
                    sb.append(matrix[i][j]);
                } else {
                    sb.append(matrix[i][j]);
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static int[][] recoverMatrix(String str) { // n^2
        String[] elements = str.split(",");
        int[][] res = new int[m][n];
        for(int i = 0; i < elements.length; i++) {
            int row = i / n;
            int col = i % n;
            res[row][col] = Integer.valueOf(elements[i]);
        }
        return res;
    }

    private static boolean doSolve() {
        Queue<int[]> elementQueue = new LinkedList<>();
        Queue<String> matrixQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        String curMatrixString = getMatrixString(matrix.clone()); // n ^ 2
        elementQueue.offer(new int[]{origin_i, origin_j});
        matrixQueue.offer(curMatrixString);
        visited.add(curMatrixString);

        while(!elementQueue.isEmpty()) { // BFS -> n
            int size = elementQueue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = elementQueue.poll();
                curMatrixString = matrixQueue.poll();
                if(curMatrixString.equals(recoveredString)) return true;

                for (int[] dir : dirs) { // 4
                    int nexti = cur[0] + dir[0];
                    int nextj = cur[1] + dir[1];
                    if(nexti < 0 || nexti >= m || nextj < 0 || nextj >= n) continue;

                    int[][] newmatrix = recoverMatrix(curMatrixString); // n^2

                    int tmp = newmatrix[cur[0]][cur[1]];
                    newmatrix[cur[0]][cur[1]] = newmatrix[nexti][nextj];
                    newmatrix[nexti][nextj] = tmp;

                    String newmatrixString = getMatrixString(newmatrix); // n^2
                    if(visited.contains(newmatrixString)) continue;

                    elementQueue.offer(new int[] {nexti, nextj});
                    matrixQueue.offer(newmatrixString);
                    visited.add(newmatrixString);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//            {1, 2, 3},
//            {4, 5, 0},
//            {6, 7, 8}
//        };
//        int[][] matrix = {
//                {15, 2, 1, 12},
//                {8, 5, 6, 11},
//                {4, 9, 10, 7},
//                {3, 14, 13, 0}
//        };
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 0, 8}
        };
        System.out.println(canSolve(matrix));
    }
}
