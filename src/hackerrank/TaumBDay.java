package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/31/16.
 */
public class TaumBDay {

    public static long countTaum(long w, long b, long x, long y, long z) {
        if(x <= y) {
            if (x + z >= y) {
                return b * x + w * y;
            } else {
                return b * x + w * (x + z);
            }
        }else {
            if (y + z >= x) {
                return b * x + w * y;
            } else {
                return (y + z) * b + w * y;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();
            System.out.println(countTaum(w,b,x,y,z));
        }
    }
}
