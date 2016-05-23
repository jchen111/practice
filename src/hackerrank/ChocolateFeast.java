package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/18/16.
 */
public class ChocolateFeast {

    static int count(int money, int price, int threshold) {
        int bars = money / price;
        int wrappers = bars;
        while(wrappers >= threshold) {
            int leftoverWrappers = wrappers % threshold;
            bars += (wrappers/threshold);
            wrappers = leftoverWrappers + (wrappers/threshold);
        }
        return bars;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            System.out.println(count(n,c,m));
        }
    }
}
