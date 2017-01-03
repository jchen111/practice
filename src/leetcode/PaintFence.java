package leetcode;

import java.util.Scanner;

/**
 * Created by z001ktb on 11/13/16.
 */
public class PaintFence {
    public static int numWays(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        if(n == 2) return k*(k-1) + k;
        return (k*(int)Math.pow((int)(k-1),(int)(n-1)) + k*numWays(n-2,k-1));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(numWays(n,k));
    }
}
