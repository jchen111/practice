package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 6/6/16.
 */
public class LarryArray {
    public static boolean verify(int[] A) {
        int length = A.length;
        for(int i = 0; i < A.length-2; i++) {
            while(A[i] > A[i+2] || A[i] > A[i+1]) {
                int left = A[i];
                A[i] = A[i + 1];
                A[i + 1] = A[i + 2];
                A[i + 2] = left;
                return verify(A);
            }
        }
        for(int i = 0; i<A.length-1; i++) {
            if(A[i+1] < A[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T =  sc.nextInt();
        for(int j = 0; j< T; j++) {
            int N = sc.nextInt();
            int A[] = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            if (verify(A)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
