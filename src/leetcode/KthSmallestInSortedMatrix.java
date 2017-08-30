package leetcode;

public class KthSmallestInSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return -1;
        int n = matrix.length;
        int res = 0;
        while(k > 0) {
            res = poll(matrix, n);
            k--;
        }
        return res;
    }

    private static int poll(int[][] matrix, int n) {
        int res = matrix[0][0];
        matrix[0][0] = matrix[n - 1][n - 1];
        int i = 0, j = 0;
        while(i < n - 1 || j < n - 1) {
            if( (i < n - 1 && matrix[i][j] > matrix[i + 1][j] ) || ( j < n - 1 && matrix[i][j] > matrix[i][j + 1]) ) {
                if(i < n - 1 && j < n - 1) {
                    if (matrix[i + 1][j] > matrix[i][j + 1]) { // left child > right child
                        swap(matrix, i, j, i, j + 1);
                        j = j + 1;
                    } else {
                        swap(matrix, i, j, i + 1, j);
                        i = i + 1;
                    }
                } else if(i < n - 1 && matrix[i][j] > matrix[i + 1][j]) {
                    swap(matrix, i, j, i + 1, j);
                    i = i + 1;
                } else {
                    swap(matrix, i, j, i, j + 1);
                    j = j + 1;
                }
            } else {
                break;
            }
        }
        return res;
    }

    private static void swap(int[][] matrix, int i, int j, int r, int c) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[r][c];
        matrix[r][c] = tmp;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(matrix, 8));
    }
}
