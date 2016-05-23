package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/13/16.
 */
public class UtopianTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            if( n == 0 ) {
                System.out.println(1);
            }else {
                int height = 1;
                for(int i=1; i< n+1; i++) {
                    if( i%2 == 0 ) {
                        height += 1;
                    }else {
                        height *= 2;
                    }
                }
                System.out.println(height);
            }
        }
    }
}
