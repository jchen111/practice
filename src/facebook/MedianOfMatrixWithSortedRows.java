package facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by z001ktb on 6/22/17.
 */
public class MedianOfMatrixWithSortedRows {
    /**
     * assume # of numbers in matrix is odd
     * time O(m*n*logk) where k = (m*n + 1)/2
     * space O(k) where k = (m*n + 1)/2
     * */
    public static int findMedian(int[][] matrix) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int k = matrix.length * matrix[0].length;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
                if(pq.size() > (1 + k)/2) {
                    pq.poll();
                }
            }
        }

        return pq.poll();
    }

    static int minR = 0;
    static int minC = 0;
    static int maxR;
    static int maxC;
    public static int findMedianII(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        maxR = m - 1;
        maxC = n - 1;
        int k = 0;
        int median = 0;

        while(k <= (m*n)/2) {
            median = pop(matrix);
            heapify(matrix);
            k++;
        }
        return median;
    }

    private static int pop(int[][] matrix) {
        return matrix[maxR][maxC];
    }

    private static void heapify(int[][] matrix) {
        matrix[maxR][maxC] = matrix[minR][minC];
        int i = maxR;
        int j = maxC;
        while(i > 0 && j > 0) {
            if(matrix[i][j] < matrix[i-1][j] || matrix[i][j] < matrix[i][j-1]){
                if(matrix[i-1][j] > matrix[i][j-1]){
                    swap(matrix, i, j, i-1, j);
                    i = i-1;
                }else {
                    swap(matrix, i, j, i, j-1);
                    j = j-1;
                }
            }else {
                break;
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j, int r, int c) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[r][c];
        matrix[r][c] = tmp;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5},
                {2,6,9},
                {3,6,9}};
        System.out.println(findMedianII(matrix));
    }
}
