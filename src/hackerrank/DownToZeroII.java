package hackerrank;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by z001ktb on 5/2/16.
 */
public class DownToZeroII {

    static int[] map = new int[1000002];

    static int countMoves(int N) {
        if(N == 0) {
            map[0] = 0;
            return 0;
        }
        if(N == 1) {
            map[1] = 1;
            return 1;
        }
        if(N == 2) {
            map[2] = 2;
            return 2;
        }
        else {
            int min = Integer.MAX_VALUE;
            /**
             * sqrt(N)
             */
            for(int i=2; i*i <= N; i++) {
                if (N % i == 0) {
                    int max = Math.max(i, N / i);
                    map[max] = (map[max] == 0) ? countMoves(max) : map[max];
                    if(map[max] < min) {
                        min = map[max];
                    }

                }
            }
            if(min != Integer.MAX_VALUE) {
                int a = min;
                map[N - 1] = (map[N - 1] == 0) ? countMoves(N - 1) : map[N - 1];
                map[N] = Math.min(a, map[N - 1]) + 1;
                return map[N];
            }
            else {
                map[N-1] = (map[N-1] == 0)? countMoves(N-1):map[N-1];
                map[N] = map[N-1] + 1;
                return map[N];
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        for(int i=0; i<Q; i++) {
            int N = sc.nextInt();
            /**
             * O(N*sqrt(N))
             */
            System.out.println(countMoves(N));
        }
    }
}
