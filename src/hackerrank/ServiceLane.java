package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/15/16.
 */
public class ServiceLane {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int width[] = new int[n];
        int cache[] = new int[n];
        for(int width_i=0; width_i < n; width_i++){
            width[width_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < t; a0++){
            int i = in.nextInt();
            int j = in.nextInt();
            int min = width[i];
            for(int r = i; r<=j; r++ ) {

                if (width[r] < min) {
                    min = width[r];
                    cache[r] = min;
                }

            }
            System.out.println(min);
        }
    }
}
