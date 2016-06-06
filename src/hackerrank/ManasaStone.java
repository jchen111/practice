package hackerrank;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by z001ktb on 5/26/16.
 */
public class ManasaStone {

    public static HashSet<Integer> pool = new HashSet<Integer>();

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0 ; i < T; i++) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            int[][] m = new int[n][n];
            //n^2 * log(n)
            for(int row = 0; row < n; row++) {
                for(int col = 0; col < n; col++) {
                    if(row == 0 && col == 0 && n != 1) {
                        continue;
                    }else if(row == 0) {
                        m[row][col] = m[row][col - 1] + a;
                    }else if(col == 0) {
                        m[row][col] = m[row-1][col] + b;
                    }else {
                        m[row][col] = m[row-1][col-1] + a + b;
                    }

                    if(row + col == (n -1)) {
                        pool.add(m[row][col]); //log(n)
                    }
                }
            }
            //O(n*log(n))
            for (Integer item:pool) {
                queue.add(item); //O(logn)
            }
            while(!queue.isEmpty()) {
                System.out.print(queue.poll() + " "); //O(1)
            }
            System.out.println();
            queue.clear();
            pool.clear();
        }
    }
}
