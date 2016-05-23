package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/14/16.
 */
public class SquareNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int counter;
            counter = (int) (Math.floor(Math.sqrt(B)) - Math.ceil(Math.sqrt(A))) + 1;
            System.out.println(counter);
        }
    }
}
