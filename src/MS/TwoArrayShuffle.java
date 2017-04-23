package MS;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by z001ktb on 4/23/17.
 */
public class TwoArrayShuffle {
    static int[] A;
    public static void makeAwin(int[] B) {
        int N = B.length;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i < N; i++){
            queue.add(A[i]);
        }

        for(int i = 0; i < N; i++){
            List<Integer> tmp = new ArrayList<Integer>();
            int min = queue.poll();
            tmp.add(min);
            while(min < B[i] && !queue.isEmpty()){
                min = queue.poll();
                tmp.add(min);
            }
            if(queue.isEmpty() && min < B[i]) {
                A[i] = tmp.get(0);
                tmp.remove(0);
            }else {
                A[i] = min;
                tmp.remove(tmp.size() - 1);
            }

            for(int k = 0; k < tmp.size(); k++){
                queue.add(tmp.get(k));
            }
        }
    }

    public static int compareCount(int[] B) {
        int countA = 0;
        int countB = 0;
        for(int i = 0; i < B.length; i++){
            if(A[i] > B[i]) countA++;
            if(A[i] < B[i]) countB++;
        }
        return countA > countB ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int N = sc.nextInt();
            A = new int[N];
            int[] B = new int[N];
            for(int i = 0; i < N; i++){
                A[i] = sc.nextInt();
            }
            for(int i = 0; i < N; i++){
                B[i] = sc.nextInt();
            }
            makeAwin(B);
            int res = compareCount(B);

            if(res == 1) System.out.println("A win");
            else System.out.println("B win");

            for(int i = 0; i < N; i++){
                System.out.print(A[i]);
                System.out.print(" ");
            }
        }
    }
}
