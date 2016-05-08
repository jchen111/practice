package hackerrank;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by z001ktb on 4/30/16.
 */
public class JesseAndCookies {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int op = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            queue.add(sc.nextInt());
        }

        int min = queue.poll();

        while(!queue.isEmpty() && min < K) {
            int sec_min = queue.poll();
            int sweetness = min + 2*sec_min;
            op++;
            queue.add(sweetness);
            min = queue.poll();
        }

        if(queue.isEmpty() && min < K) {
            op = -1;
        }

        System.out.println(op);
    }
}
