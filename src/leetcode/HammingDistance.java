package leetcode;

import java.util.Scanner;

/**
 * Created by z001ktb on 3/22/17.
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int a = x;
        int b = y;
        int hammingDistance = 0;
        for(int i = 0; i < 31; i++){
            int xor = a ^ b;
            xor = xor << 31;
            if(xor == -Math.pow(2,31)) hammingDistance++;
            a = a >> 1;
            b = b >> 1;
        }
        return hammingDistance;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(hammingDistance(x,y));
    }

}
